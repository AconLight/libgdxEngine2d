package com.redartedgames.libgdxengine2d;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class LibgdxEngine2dGame implements ApplicationListener{

	
	
	public static final String VERT_SHADER =  
			"attribute vec2 a_position;\n" +
			"attribute vec4 a_color;\n" +			
			"uniform mat4 u_projTrans;\n" + 
			"varying vec4 vColor;\n" +			
			"void main() {\n" +  
			"	vColor = a_color;\n" +
			"	gl_Position =  u_projTrans * vec4(a_position.xy, 0.0, 1.0);\n" +
			"}";
	
	public static final String FRAG_SHADER = 
            "#ifdef GL_ES\n" +
            "precision mediump float;\n" +
            "#endif\n" +
			"varying vec4 vColor;\n" +
			"varying vec2 vTexCoord;\n" +
			"void main() {\n" +  
			"	gl_FragColor = vec4(vec3(vTexCoord.s), 1.0);\n" + 
			"}";
	
	protected static ShaderProgram createMeshShader() {
		ShaderProgram.pedantic = false;
		ShaderProgram shader = new ShaderProgram(VERT_SHADER, FRAG_SHADER);
		String log = shader.getLog();
		if (!shader.isCompiled())
			throw new GdxRuntimeException(log);		
		if (log!=null && log.length()!=0)
			System.out.println("Shader Log: "+log);
		return shader;
	}
	
	Mesh mesh;
	OrthographicCamera cam;
	ShaderProgram shader;
	SpriteBatch batch;
	
	//The index position
	private int idx = 0;
	
	@Override
	public void create() {
		mesh = new Mesh(true, 0, 0, 
				new VertexAttribute(Usage.Position, POSITION_COMPONENTS, "a_position"),
				new VertexAttribute(Usage.ColorUnpacked, COLOR_COMPONENTS, "a_color"));
		
		shader = createMeshShader();
		cam = new OrthographicCamera();
	}

	@Override
	public void resize(int width, int height) {
	}
	float x = 10;
	@Override
	public void render() {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.7f, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		x += 10*Gdx.graphics.getDeltaTime();
		//this will push the triangles into the batch
		drawTriangle(10+x, 10, 40, 40, Color.RED, Color.GREEN);
		drawTriangle(50+x, 50, 70, 40, Color.BLUE, Color.RED);
		
		//this will render the triangles to GL
		flush();
	}
	
	void flush() {
		//if we've already flushed
		if (idx==0)
			return;
		
		//sends our vertex data to the mesh
		mesh.setVertices(verts);
		
		//no need for depth...
		Gdx.gl.glDepthMask(false);
		
		//enable blending, for alpha
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		//number of vertices we need to render
		int vertexCount = (idx/NUM_COMPONENTS);
		
		//update the camera with our Y-up coordiantes
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//start the shader before setting any uniforms
		shader.begin();
		
		//update the projection matrix so our triangles are rendered in 2D
		shader.setUniformMatrix("u_projTrans", cam.combined);
		
		//render the mesh
		mesh.render(shader, GL20.GL_TRIANGLES, 0, vertexCount);
		
		shader.end();
		
		//re-enable depth to reset states to their default
		Gdx.gl.glDepthMask(true);
		
		//reset index to zero
		idx = 0;
	}
	
	void drawTriangle(float x, float y, float width, float height, Color color, Color color2) {
		//we don't want to hit any index out of bounds exception...
		//so we need to flush the batch if we can't store any more verts
		if (idx==verts.length)
			flush();
		
		//now we push the vertex data into our array
		//we are assuming (0, 0) is lower left, and Y is up
		
		//bottom left vertex
		verts[idx++] = x; 			//Position(x, y) 
		verts[idx++] = y;
		verts[idx++] = color.r; 	//Color(r, g, b, a)
		verts[idx++] = color.g;
		verts[idx++] = color.b;
		verts[idx++] = color.a;
		
		//top left vertex
		verts[idx++] = x; 			//Position(x, y) 
		verts[idx++] = y + height;
		verts[idx++] = color2.r; 	//Color(r, g, b, a)
		verts[idx++] = color2.g;
		verts[idx++] = color2.b;
		verts[idx++] = color2.a;

		//bottom right vertex
		verts[idx++] = x + width;	 //Position(x, y) 
		verts[idx++] = y;
		verts[idx++] = color.r;		 //Color(r, g, b, a)
		verts[idx++] = color.g;
		verts[idx++] = color.b;
		verts[idx++] = color.a;
	}
	
	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		mesh.dispose();
		shader.dispose();
	}

}