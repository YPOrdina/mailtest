import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Paint extends JFrame {
	private static final long serialVersionUID = 3758255875540786137L;
	public static final int INITIAL_WIDTH = 400; //THIS IS NEW
	public static final int INITIAL_HEIGHT = 400;//THIS IS NEW

	public static void main(String args[]) {
		startPaint();
	}

	public static void startPaint() {
		Paint paint = new Paint("YP paint");
		addDefaultMouseListener(paint);
		paint.setVisible(true);
	}

	private static void addDefaultMouseListener(Paint paint) {
		MouseListenerForPaint mouseListenerForPaint = new MouseListenerForPaint(
				paint);
		paint.addMouseMotionListener(mouseListenerForPaint);
		paint.addMouseListener(mouseListenerForPaint);
	}

	public Paint(String title) {
		super(title);
		setSize(INITIAL_WIDTH, INITIAL_HEIGHT);	 //THIS IS NEW
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		menu();
		JPanel panels = new JPanel();			 //THIS IS NEW
		panels.setLayout(new BorderLayout(10,0));//THIS IS NEW
		new PaintTools(this,panels);			 //THIS IS NEW
		new Canvas(this,panels);				 //THIS IS NEW
		this.add(panels);
	}

	public void menu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);

		menuBar.add(fileMenu);
	}
	
	public void draw(int startX, int startY, int x, int y) {
		Graphics paintGraphics = getGraphics();
		paintGraphics.setColor(Color.blue);
		paintGraphics.drawLine(startX, startY, x, y);
	}
}
