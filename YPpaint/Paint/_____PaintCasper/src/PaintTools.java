//THIS IS A NEW CLASS
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PaintTools extends JPanel{
	PaintTools(Paint paint,JPanel panels){
		this.setBackground(new Color(0,0,0));
		int heightOfWindow = paint.getSize().height;
		int widthOfPaintTools = 20;
		Dimension dimensionOfPaintTools = new Dimension(widthOfPaintTools,heightOfWindow);
		this.setSize(dimensionOfPaintTools);
		panels.add(this);
	}
}
