//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//
//public class MouseListenerForPaint extends MouseAdapter implements MouseMotionListener,
//		MouseListener {
//	private int x, y;
//	private int previousX, previousY;
//	private boolean isLastEventAvailable = false;
//	private Paint parent;
//
//	public MouseListenerForPaint(Paint parent) {
//		this.parent = parent;
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent e) {
//		getMouseCoordinates(e);
//		this.parent.draw(getStartX(), getStartY(), getX(), getY());
//		savePreviousXY();
//		this.isLastEventAvailable = true;
//	}
//
//	private void getMouseCoordinates(MouseEvent e2) {
//		x = e2.getX();
//		y = e2.getY();
//	}
//
//	private void savePreviousXY() {
//		previousX = getX();
//		previousY = getY();
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public int getX() {
//		return x;
//	}
//
//	public int getStartY() {
//		return this.isLastEventAvailable ? previousY : getY();
//	}
//
//	public int getStartX() {
//		return this.isLastEventAvailable ? previousX : getX();
//	}
//	
//	public void mouseExited(MouseEvent e5) {
//		this.isLastEventAvailable = false;
//	}
//
//	public void mousePressed(MouseEvent e6) {
//		this.isLastEventAvailable = false;
//	}
//}