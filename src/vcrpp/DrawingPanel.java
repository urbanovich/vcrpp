package vcrpp;

import vcrpp.geometry.Circle;
import vcrpp.geometry.Drawable;
import vcrpp.geometry.Line;
import vcrpp.geometry.Shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	private ArrayList<Drawable> mShapes;
	private ArrayList<Point> mPoints;
	private Shape mCurrentShape;
	private Point mStartPoint;
	private Point mEndPoint;
	private Point mCurrentPoint;

	private ToolboxPanel mToolBox;

	/**
	 * Constructor
	 * 
	 * @param toolBox
	 */
	public DrawingPanel(ToolboxPanel toolBox) {
		setBackground(Color.blue);
		setPreferredSize(new Dimension(400, 400));

		mToolBox = toolBox;
		mShapes = new ArrayList<Drawable>();
		mPoints = new ArrayList<Point>();
		mStartPoint = new Point();
		mEndPoint = new Point();
		mCurrentShape = null;
		registerMouseListener();
	}

	/**
	 * Hook up mouse event
	 */
	private void registerMouseListener() {
		MouseListener listener = new MouseListener() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (mCurrentShape != null) {
					mShapes.add((Drawable) mCurrentShape);
					mCurrentShape = null;
				}
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//check currentshape
				if (!mToolBox.getCurrentShape().isReady()) {
					mPoints.add(new Point(e.getPoint()));
				} else {
					if (mToolBox.getCurrentShape() instanceof Line) {
						mCurrentShape = new Line(e.getPoint(), e.getPoint());
					} else if (mToolBox.getCurrentShape() instanceof Circle) {
						mCurrentShape = new Circle(e.getPoint(), e.getPoint());
						mCurrentShape.setColorTwo(mToolBox.getCurrentShape().getColorTwo());
					} 
					// TODO: add the code for the other shapes here
					mCurrentShape.setColorOne(mToolBox.getCurrentShape().getColorOne());
					mCurrentShape.setThickness(mToolBox.getCurrentShape().getThickness());
				}
				
				mStartPoint = e.getPoint();
				ToolboxPanel.ShapeEnum userChoice = mToolBox.getShapeChoice();
				if (userChoice == ToolboxPanel.ShapeEnum.S_LINE) {
					mCurrentShape = new Line(mStartPoint, mStartPoint);
				} else if (userChoice == ToolboxPanel.ShapeEnum.S_CIRCLE) {
					mCurrentShape = new Circle(mStartPoint, mStartPoint);
				} else if (userChoice == ToolboxPanel.ShapeEnum.S_NOT_READY) {
					
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		};

		MouseMotionListener motionListener = new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (!mToolBox.getCurrentShape().isReady()) {
					mPoints.add(new Point(e.getPoint()));
				} else {
					mCurrentShape.setEndPoint(e.getPoint());
				}
				repaint();
			}
		};

		addMouseListener(listener);
		addMouseMotionListener(motionListener);
	}

	void addShape(Drawable s) {
		mShapes.add(s);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (mCurrentShape != null) {
			Drawable d = (Drawable) mCurrentShape;
			d.draw(g);
		}
		
		for (Drawable shape : mShapes) {
			shape.draw(g);
		}
		
		for (Point p : mPoints) {
			g.drawOval((int) p.getX(), (int) p.getY(), 5, 5);
		}
	}

}