import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Paint extends JFrame {
	public static final long serialVersionUID = 3758255875540786137L;

	public static final int INITIAL_WIDTH = 1000;
	public static final int INITIAL_HEIGHT = 800;
	public static final int HEIGHT_OF_TOOLBAR = 100;
	public static Color colour = Color.BLACK;

	public static void main(String args[]) {
		startPaint();
	}

	public static void startPaint() {
		Paint paint = new Paint("YP paint");
		createEmptyMenu(paint);
		paint.setVisible(true);
	}

	private static void createEmptyMenu(Paint paint) {
		PaintMenu menu = new PaintMenu(paint);
		paint.add(menu);
		menu.menu();
	}

	public Paint(String title) {
		super(title);

		setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		this.add(new PaintButtonBar(INITIAL_WIDTH, HEIGHT_OF_TOOLBAR), BorderLayout.NORTH);
		this.add(new OnzeCanvas(INITIAL_WIDTH, INITIAL_HEIGHT - HEIGHT_OF_TOOLBAR), BorderLayout.SOUTH);
	}
}
