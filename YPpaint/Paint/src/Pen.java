import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Pen implements Tool {

	public void draw(int startX, int startY, int x, int y, int thickness, Color color, Graphics2D paintGraphics) {
		updateBefore(startX, startY, x, y);
		paintGraphics.setStroke(getStroke(thickness));
		paintGraphics.setColor(color);
		paintGraphics.drawLine(startX, startY, x, y);
	}

	protected void updateBefore(int startX, int startY, int x, int y) {
	}

	protected BasicStroke getStroke(int thickness) {
		return new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0F);
	}
}