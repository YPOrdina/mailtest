import java.awt.Color;
import java.awt.Graphics2D;


public class PaintBucket implements Tool {


	public void draw(int startX, int startY, int x, int y, int thickness, Color color, Graphics2D paintGraphics )
	{
		paintGraphics.setColor(color);		
		//hier iets slims a la paintGraphics.drawLine(startX, startY, x, y);
	}
}