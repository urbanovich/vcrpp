package vcrpp.geometry;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Circle extends Shape implements Drawable {
	private Color mInnerColor;

	public Circle(Point start, Point end) {
		super(start, end);
	}

	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(mColorOne);
		g2d.setStroke(new BasicStroke(mThickness));
		
		g2d.drawOval((int)mStartPoint.getX(), (int)mStartPoint.getY(),
				(int)Math.abs(mStartPoint.getX() - mEndPoint.getX()),
				(int)Math.abs(mStartPoint.getY() - mEndPoint.getY()));
		g2d.setColor(mColorTwo);
		g2d.fillOval((int)mStartPoint.getX() + (int)mThickness/2, (int)mStartPoint.getY() + (int)mThickness/2,
				(int)Math.abs(mStartPoint.getX() - mEndPoint.getX()) - (int)mThickness,
				(int)Math.abs(mStartPoint.getY() - mEndPoint.getY()) - (int)mThickness);

	}

}