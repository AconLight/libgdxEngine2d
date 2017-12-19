package com.redartedgames.libgdxengine2d.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hitbox {
	public enum ShapeMode { Circle, Polygon, Rectangle, none };
	public enum BehaviorMode { none, kinematic, dynamic };
	public static BehaviorMode none = BehaviorMode.none;
	public static BehaviorMode kinematic = BehaviorMode.kinematic;
	public static BehaviorMode dynamic = BehaviorMode.dynamic;
	public ShapeMode sMode;
	public BehaviorMode bMode;
	private Circle circle;
	private Polygon polygon;
	public Rectangle rectangle;
	private float colRadius;
	private Vector2 position, oldPosition;
	private float positionX, positionY, circleR;
	
	public float k = 300;
	
	public Hitbox() {
		sMode = ShapeMode.none;
		bMode = BehaviorMode.none;
	}
	public Hitbox(float positionX, float positionY, float radius, BehaviorMode mode){
		sMode = ShapeMode.Circle;
		bMode = mode;
		circle = new Circle(positionX, positionY, radius);
		colRadius = radius;
		circleR = radius;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public Hitbox(float positionX, float positionY, float width, float height, BehaviorMode mode){
		sMode = ShapeMode.Rectangle;
		bMode = mode;
		rectangle = new Rectangle(positionX - width/2, positionY - height/2, width, height);
		colRadius = (float) (Math.sqrt(width*width + height*height)/2);
		this.positionX = positionX;
		this.positionY = positionY;
	}	
	
	
	public void update(float x, float y) {
		switch (sMode) {
			case none: {
				break;
			}
			case Rectangle: {
				rectangle.set(x - rectangle.width/2, y - rectangle.height/2, rectangle.width, rectangle.height);
				break;
			}
			case Circle: {
				positionX = x;
				positionY = y;
				circle.set(x, y, circle.radius);
				break;
			}
			case Polygon: {
				polygon.translate(position.x - oldPosition.x, position.y - oldPosition.y);
				oldPosition.set(position);
				break;
			}
		}
	}
	
	private CollisionHandle circleRect(Circle circle, Rectangle rectangle) {
		CollisionHandle c = new CollisionHandle();
		c.disX = 0;
		c.disY = 0;
		c.isTrue = true;
		float v;
		float dr2, dr, dx, dy;
		boolean flaga = true;
		
		if ((circle.x > rectangle.x && circle.x < rectangle.x+rectangle.width) || (circle.y > rectangle.y && circle.y < rectangle.y+rectangle.height)) {
			if (circle.x + circle.radius > rectangle.x && circle.x < rectangle.x) {
				dx = circle.x + circle.radius - rectangle.x;
				c.disX = -dx*k;
			}
			else if (circle.x > rectangle.x + rectangle.width && circle.x - circle.radius < rectangle.x + rectangle.width) {
				dx = (circle.x - circle.radius) - (rectangle.x + rectangle.width);
				c.disX = -dx*k;
			}
			else if (circle.y + circle.radius > rectangle.y && circle.y < rectangle.y) {
				dy = circle.y + circle.radius - rectangle.y;
				c.disY = -dy*k;
			}
			else if (circle.y > rectangle.y + rectangle.height && circle.y - circle.radius < rectangle.y + rectangle.height) {
				dy = (circle.y - circle.radius) - (rectangle.y + rectangle.height);
				c.disY = -dy*k;
			}
		}
			else {
				
				
				dx = circle.x - rectangle.x;
				dy = circle.y - rectangle.y;
				dr2 = dx*dx + dy*dy;
				dr = (float) Math.sqrt(dr2);
				if (dr2 < circle.radius*circle.radius) {
					c.disX += -k*(dr-circle.radius)*dx/dr;
					c.disY += -k*(dr-circle.radius)*dy/dr;
					flaga = false;
				}
				
				dx = circle.x - (rectangle.x + rectangle.width);
				dy = circle.y - rectangle.y;
				dr2 = dx*dx + dy*dy;
				dr = (float) Math.sqrt(dr2);
				if (dr2 < circle.radius*circle.radius) {
					c.disX += -k*(dr-circle.radius)*dx/dr;
					c.disY += -k*(dr-circle.radius)*dy/dr;
					flaga = false;
				}
				
				dx = circle.x - (rectangle.x + rectangle.width);
				dy = circle.y - (rectangle.y + rectangle.height);
				dr2 = dx*dx + dy*dy;
				dr = (float) Math.sqrt(dr2);
				//Gdx.app.log("Hitbox", "" + dx + ", " + dy);
				//Gdx.app.log("Hitbox, circle", "" + circle.x + ", " + circle.y);
				//Gdx.app.log("Hitbox, rect", "" + (rectangle.x+rectangle.width) + ", " + (rectangle.y+rectangle.height));
				if (dr2 < circle.radius*circle.radius) {
					//Gdx.app.log("Hitbox", "" + dx + ", " + dy);
					c.disX += -k*(dr-circle.radius)*dx/dr;
					c.disY += -k*(dr-circle.radius)*dy/dr;
					flaga = false;
				}
				
				dx = circle.x - rectangle.x;
				dy = circle.y - (rectangle.y + rectangle.height);
				dr2 = dx*dx + dy*dy;
				dr = (float) Math.sqrt(dr2);
				
				if (dr2 < circle.radius*circle.radius) {
					c.disX += -k*(dr-circle.radius)*dx/dr;
					c.disY += -k*(dr-circle.radius)*dy/dr;
					flaga = false;
				}
				
			}
		
		
		return c;
		
	}
	
	private CollisionHandle circleCircle(float circleX, float circleY, float circleR, float circle2X, float circle2Y, float circle2R) {
		CollisionHandle c = new CollisionHandle();
		c.disX = 0;
		c.disY = 0;
		float dx = circleX-circle2X;
		float dy = circleY-circle2Y;
		float dr2 = dx*dx+dy*dy;
		float dr = (float) Math.sqrt(dr2);
		float d = circleR+circle2R-dr;
		
		if (d > 0) {
			c.disX = dx/dr*d*k;
			c.disY = dy/dr*d*k;
			c.isTrue = true;
		}
		else {
			c.disX = 0;
			c.disY = 0;
			c.isTrue = false;
		}
		
		
		//Gdx.app.log("HdisX"+disX, "HdisY"+disY);
		return c;
	}
	
	private CollisionHandle rectRect(Rectangle rect, Rectangle rect2, Rectangle intersection) {
		CollisionHandle c = new CollisionHandle();
		c.disX = 0;
		c.disY = 0;
		c.isTrue = true;
		
		if (rect.y + rect.height/2 > intersection.y ) {
			if (rect.x + rect.width/2 > intersection.x ) {
				if (intersection.width > intersection.height) {
					c.disY = intersection.height*k;
				}
				else {
					c.disX =intersection.width*k;
				}
			}
			else {
				if (intersection.width > intersection.height) {
					c.disY = intersection.height*k;
				}
				else {
					c.disX =-intersection.width*k;
				}
			}
		}
		else {
			if (rect.x + rect.width/2 > intersection.x ) {
				if (intersection.width > intersection.height) {
					c.disY = -intersection.height*k;
				}
				else {
					c.disX = intersection.width*k;
				}
			}
			else {
				if (intersection.width > intersection.height) {
					c.disY = -intersection.height*k;
				}
				else {
					c.disX = -intersection.width*k;
				}
			}
		}

		return c;
	}
	
	private static final BigDecimal TWO = new BigDecimal("2");
	
	public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
	    BigDecimal x0 = new BigDecimal("0");
	    BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
	    while (!x0.equals(x1)) {
	        x0 = x1;
	        x1 = A.divide(x0, SCALE, RoundingMode.HALF_UP);
	        x1 = x1.add(x0);
	        x1 = x1.divide(TWO, SCALE, RoundingMode.HALF_UP);

	    }
	    return x1;
	}
	public boolean isClicked(float x, float y) {
		Hitbox hit = new Hitbox(x, y, 1, 1, BehaviorMode.kinematic);
		CollisionHandle c = checkCol(hit);
		return c.isTrue;
	}
	public CollisionHandle checkCol(Hitbox hitbox) {
		CollisionHandle c = new CollisionHandle();
		c.disX = 0;
		c.disY = 0;
		c.isTrue = false;
		switch (sMode) {
			case Rectangle: {
				switch (hitbox.sMode) {
					case Rectangle: {
						Rectangle intersection = new Rectangle();
						if (Intersector.intersectRectangles(rectangle, hitbox.rectangle, intersection)) {
							c = rectRect(rectangle, hitbox.rectangle, intersection);
						}
						break;
					}
					case Circle: {
						if (Intersector.overlaps(hitbox.circle, rectangle)) {
							c = circleRect(hitbox.circle, rectangle);
							c.disX = -c.disX;
							c.disY = -c.disY;
							c.isTrue = true;
						}
						else {
							c.isTrue = false;
						}
						break;
					}
					case Polygon: {
						float [] verts1 = {rectangle.x, rectangle.y, rectangle.x+rectangle.width, rectangle.y+rectangle.height};
						c.isTrue = Intersector.overlapConvexPolygons(verts1, hitbox.polygon.getTransformedVertices(), null);
						break;
					}
				}
				break;
			}
			case Circle: {
				
				switch (hitbox.sMode) {
					case Rectangle: {
						if (Intersector.overlaps(circle, hitbox.rectangle)) {
							c = circleRect(circle, hitbox.rectangle);
							c.disX = c.disX;
							c.disY = c.disY;
							c.isTrue = true;
						}
						else {
							c.isTrue = false;
						}
						break;
					}
					case Circle: {						
							c = circleCircle(positionX, positionY, circleR, hitbox.positionX, hitbox.positionY, hitbox.circleR);
						break;
					}
					case Polygon: {
						//TODO
						c.isTrue = false;
						break;
					}
				}
				break;
			}
			case Polygon: {
				
				switch (hitbox.sMode) {
					case Rectangle: {
						float [] verts1 = {hitbox.rectangle.x, hitbox.rectangle.y, hitbox.rectangle.x+hitbox.rectangle.width, hitbox.rectangle.y+hitbox.rectangle.height};
						//c.isTrue = Intersector.overlapConvexPolygons(verts1, polygon.getTransformedVertices(), null);
						break;
					}
					case Circle: {
						//TODO
						c.isTrue = false;
						break;
					}
					case Polygon: {
						c.isTrue = Intersector.overlapConvexPolygons(hitbox.polygon.getTransformedVertices(), polygon.getTransformedVertices(), null);
						break;
					}
				}
				break;
			}
			default : {
				c.isTrue = false;
			}
			
			
		}
		return c;
	}
}