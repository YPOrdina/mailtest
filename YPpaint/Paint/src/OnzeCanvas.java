import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class OnzeCanvas extends Canvas implements MouseMotionListener, MouseListener {
	private static final long serialVersionUID = -2969579208851689968L;
	private int x, y;
	private int previousX, previousY;
	private boolean isLastEventAvailable = false;
	static Tool tool = new Pen();
	static int currentThickness = 1;

	OnzeCanvas(int width, int height) {
		this.setSize(width, height);
		this.setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void draw(int startX, int startY, int x, int y) {
		tool.draw(startX, startY, x, y, currentThickness, Paint.colour, (Graphics2D) getGraphics());
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		getMouseCoordinates(arg0);
		this.draw(getStartX(), getStartY(), getX(), getY());
		savePreviousXY();
		this.isLastEventAvailable = true;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Mouse Clicked");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	private void getMouseCoordinates(MouseEvent arg0) {
		x = arg0.getX();
		y = arg0.getY();
	}

	private void savePreviousXY() {
		previousX = getX();
		previousY = getY();
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public int getStartY() {
		return this.isLastEventAvailable ? previousY : getY();
	}

	public int getStartX() {
		return this.isLastEventAvailable ? previousX : getX();
	}

	public void mouseExited(MouseEvent e5) {
		this.isLastEventAvailable = false;
	}

	public void mousePressed(MouseEvent e6) {
		this.isLastEventAvailable = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}