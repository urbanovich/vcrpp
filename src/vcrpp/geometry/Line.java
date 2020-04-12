package vcrpp.geometry;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends Shape implements Drawable {
	public Line(Point start, Point end) {
		super(start, end);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(mColorOne);
		g2d.setStroke(new BasicStroke(mThickness));
		g2d.drawLine(
			(int) mStartPoint.getX(), (int) mStartPoint.getY(),
			(int) mEndPoint.getX(), (int) mEndPoint.getY());
	}
}

