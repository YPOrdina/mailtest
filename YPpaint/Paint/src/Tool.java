import java.awt.Color;
import java.awt.Graphics2D;


public interface Tool {
	
	public abstract void draw(int startX, int startY, int x, int y, int thickness, Color color, Graphics2D paintGraphics );
}
