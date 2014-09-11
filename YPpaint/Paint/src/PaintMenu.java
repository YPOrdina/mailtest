import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintMenu extends JMenuBar {

	private static final long serialVersionUID = -2780138759620422138L;
	private Paint parent;

	public PaintMenu(Paint parent) {
		this.parent = parent;
	}

	public void menu() {
		JMenuBar menuBar = new JMenuBar();
		parent.setJMenuBar(menuBar);

		/**
		 * Create fileMenu and action performers
		 */
		JMenu fileMenu = new JMenu("File");
		JMenuItem newItem = new JMenuItem(new AbstractAction("New") {
			public void actionPerformed(ActionEvent e) {
				System.out.println("New");
			}
		});
		JMenuItem openItem = new JMenuItem(new AbstractAction("Open") {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				BufferedImage image = null;
				int returnValue = fc.showOpenDialog(parent);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					// image = ImageIO.read(new File(fc.getSelectedFile()));
				}
				System.out.println("Open");
			}
		});
		JMenuItem saveItem = new JMenuItem(new AbstractAction("Save") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(parent);
				System.out.println("Save");
			}
		});

		// Add fileMenuItems to the menu
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);

		/**
		 * Create toolsMenu, submenu and action performers
		 */
		JMenu toolsMenu = new JMenu("Tools");
		
		JMenu brushes = new JMenu("Brushes");
		JMenu colour = new JMenu("Colour");
		JMenu extra = new JMenu("Extra");
		JMenu thick = new JMenu("Thickness");
		
		JMenuItem pencil = new JMenuItem(new AbstractAction("Pencil") {
			public void actionPerformed(ActionEvent e) {
				OnzeCanvas.tool = new Pen();
			}
		});
		JMenuItem brush = new JMenuItem(new AbstractAction("Brush") {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Brush");
				OnzeCanvas.tool = new Brush();
			}
		});

		JMenuItem dashPen = new JMenuItem(new AbstractAction("Dash Pen") {
			public void actionPerformed(ActionEvent e) {
				OnzeCanvas.tool = new DashPen();
			}
		});

		
		JMenuItem chooseColour = new JMenuItem(new AbstractAction(
				"Custom colour") {
			public void actionPerformed(ActionEvent e) {
				Paint.colour = JColorChooser.showDialog(parent,
						"Choose colour",Color.blue);
			}
		});
		
		JMenuItem eraser = new JMenuItem(new AbstractAction(
				"Eraser") {
			public void actionPerformed(ActionEvent e) {
				OnzeCanvas.tool = new Gum();
			}
		});
		
		JMenuItem l1 = new JMenuItem(new AbstractAction(
				"1") {
			public void actionPerformed(ActionEvent e) {
				OnzeCanvas.currentThickness = 1;
			}
		});
		
		JMenuItem l3 = new JMenuItem(new AbstractAction(
				"3") {
			public void actionPerformed(ActionEvent e) {
				OnzeCanvas.currentThickness = 3;
			}
		});
		
		JMenuItem l5 = new JMenuItem(new AbstractAction(
				"5") {
			public void actionPerformed(ActionEvent e) {
				OnzeCanvas.currentThickness = 5;
			}
		});
		
		JMenuItem l10 = new JMenuItem(new AbstractAction(
				"10") {
			public void actionPerformed(ActionEvent e) {
				OnzeCanvas.currentThickness = 10;
			}
		});

		// Add all items to the toolsMenu
		brushes.add(pencil);
		brushes.add(brush);
		brushes.add(dashPen);
		colour.add(chooseColour);
		extra.add(eraser);
		thick.add(l1);
		thick.add(l3);
		thick.add(l5);
		thick.add(l10);
		

		toolsMenu.add(brushes);
		toolsMenu.add(colour);
		toolsMenu.add(extra);
		toolsMenu.add(thick);
		menuBar.add(fileMenu);
		menuBar.add(toolsMenu);
	}

}
