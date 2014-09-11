import java.awt.Color;
import java.awt.Graphics2D;


public class Gum extends Pen {

	public void draw(int startX, int startY, int x, int y, int thickness, Color color, Graphics2D paintGraphics )
	{
		super.draw( startX,  startY,  x,  y,  10, Color.WHITE, paintGraphics );
	}

}
