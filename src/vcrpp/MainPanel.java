package vcrpp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class MainPanel extends JPanel {
	private DrawingPanel mDrawPanel;
	private ToolboxPanel mToolboxPanel;

	public MainPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.green);
		buildGui();
	}

	private void buildGui() {
		mToolboxPanel = new ToolboxPanel();
		mDrawPanel = new DrawingPanel(mToolboxPanel);
		add(mToolboxPanel);
		add(mDrawPanel);
	}
}