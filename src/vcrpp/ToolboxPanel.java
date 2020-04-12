package vcrpp;

import vcrpp.geometry.Line;
import vcrpp.geometry.Shape;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;

public class ToolboxPanel extends JPanel {
	private JButton mLineButton;
	private JButton mCircleButton;
	private JButton mRectangleButton;
	private JButton mTriangleButton;
	private ShapeEnum mShapeChoice;
	private Shape mCurrentShape;
	private Color mColorOne;
	private Color mColorTwo;

	private JPanel mColorOnePanel;
	private JPanel mColorTwoPanel;
	private JButton mColorOneButton;
	private JButton mColorTwoButton;
	
	public enum ShapeEnum {
		S_LINE, S_CIRCLE, S_RECTANGLE, S_TRIANGLE, S_NOT_READY, S_POINTS,
	};

	private Color colorArray[] = { Color.white, Color.black, Color.darkGray,
			Color.lightGray, Color.magenta, Color.red, Color.orange,
			Color.yellow, Color.green, Color.blue, };

	public ToolboxPanel() {
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(30, 30));

		// default
		mCurrentShape = new Line(new Point(), new Point());
		mCurrentShape.setReady(false);

		mShapeChoice = ShapeEnum.S_NOT_READY;
		buildToolBoxArea();
	}

	public ShapeEnum getShapeChoice() {
		return mShapeChoice;
	}

	private void addBrushesSection() {

	}

	private void registerMouseEventForButton(final JButton button) {
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (button.getBackground() == Color.gray) {
					button.setBackground(null);
				} else {
					button.setBackground(Color.gray);
				}
			}

			public void mouseReleased(MouseEvent e) {

			}
		});
	}

	private void addShapesSection() {
		mLineButton = new JButton("Line");
		mCircleButton = new JButton("Circle");
		mRectangleButton = new JButton("Rectangle");
		mTriangleButton = new JButton("Triangle");

		registerMouseEventForButton(mLineButton);
		mLineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mCurrentShape = new Line(new Point(), new Point());
				if (mLineButton.getBackground() == Color.gray) {
					mCurrentShape.setReady(true);
					// mShapeChoice = ShapeEnum.S_LINE;
					mCircleButton.setBackground(null);
					mRectangleButton.setBackground(null);
					mTriangleButton.setBackground(null);
				} else {
					mCurrentShape.setReady(false);
					mLineButton.setBackground(null);
					mShapeChoice = ShapeEnum.S_NOT_READY;
				}
			}
		});

		registerMouseEventForButton(mCircleButton);
		mCircleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mCircleButton.getBackground() == Color.gray) {
					// mShapeChoice = ShapeEnum.S_CIRCLE;
					mCurrentShape.setReady(true);
					mLineButton.setBackground(null);
					mRectangleButton.setBackground(null);
					mTriangleButton.setBackground(null);
				} else {
					mCurrentShape.setReady(false);
					mCircleButton.setBackground(null);
					mShapeChoice = ShapeEnum.S_NOT_READY;
				}
			}
		});

		mRectangleButton = new JButton("Rectangle");
		mTriangleButton = new JButton("Triangle");
		JPanel shapePanel = new JPanel();
		GridLayout gridLayout = new GridLayout(2, 2);
		gridLayout.setHgap(2);
		gridLayout.setVgap(2);
		shapePanel.setLayout(gridLayout);
		shapePanel.add(mLineButton);
//		shapePanel.add(mCircleButton);
//		shapePanel.add(mRectangleButton);
//		shapePanel.add(mTriangleButton);
		add(shapePanel);
	}

	private void addColorsSection() {
		JPanel colorMainPanel = new JPanel();
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(3, 10));
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 10; ++j) {
				final JButton colorButton = new JButton();
				colorButton.setPreferredSize(new Dimension(20, 20));
				if (i == 0) {
					colorButton.setBackground(colorArray[j]);
					colorPanel.add(colorButton);
					colorButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (mCurrentShape != null) {
								mCurrentShape.setColorOne(colorButton.getBackground());
							} else {
							}
						}
					});
				} else {
					colorButton.setBackground(Color.white);
				}
				colorPanel.add(colorButton);
			}
		}
		colorMainPanel.add(colorPanel);
		add(colorMainPanel);
	}

	public Shape getCurrentShape() {
		return mCurrentShape;
	}

	public void buildToolBoxArea() {
		// add all the subpanel use gridbag
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		// 1
		addBrushesSection();
		// 2
		addShapesSection();
		// 3
		addColorsSection();

		/*
		 * add(new Button("Images")); add(new
		 * JSeparator(SwingConstants.VERTICAL)); add(new Button("Tools"));
		 * add(new JSeparator(SwingConstants.VERTICAL));
		 * 
		 * JButton mBrushButton = new JButton("Brushes"); // add(new
		 * Button("Brushes")); add(new JSeparator(SwingConstants.VERTICAL));
		 */

		// shapes panel

	}// end buildToolBoxArea

}