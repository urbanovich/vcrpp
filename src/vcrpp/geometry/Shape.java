package vcrpp.geometry;

import java.awt.Color;
import java.awt.Point;

public abstract class Shape {
	protected Point mStartPoint;
	protected Point mEndPoint;
	protected Color mColorOne;
	protected Color mColorTwo;
	protected float mThickness;
	protected boolean mReady;
	
	public Shape(Point start, Point end) {
		mStartPoint = start;
		mEndPoint = end;
		mThickness = 10.0f;
		mColorOne = Color.black;
		mColorTwo = Color.gray;
	}
	
	public Shape(Point start, Point end, float thickness, Color color) {
		mStartPoint = start;
		mEndPoint = end;
		mThickness = thickness;
		mColorOne = color;
	}
	
	public boolean isReady() {
		return mReady;
	}
	
	public void setReady(boolean ready) {
		mReady = ready;
	}
	
	public float getThickness() {
		return mThickness;
	}

	public void setThickness(float mThickness) {
		this.mThickness = mThickness;
	}

	public Point getStartPoint() {
		return mStartPoint;
	}

	public void setStartPoint(Point mStartPoint) {
		this.mStartPoint = mStartPoint;
	}

	public Point getEndPoint() {
		return mEndPoint;
	}

	public void setEndPoint(Point mEndPoint) {
		this.mEndPoint = mEndPoint;
	}
	
	public Color getColorOne() {
		return mColorOne;
	}

	public void setColorOne(Color mColor) {
		this.mColorOne = mColor;
	}
	
	public Color getColorTwo() {
		return mColorTwo;
	}

	public void setColorTwo(Color mColorTwo) {
		this.mColorTwo = mColorTwo;
	}

}
