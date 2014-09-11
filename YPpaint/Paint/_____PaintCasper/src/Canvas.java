//THIS IS A NEW CLASS
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Canvas extends JPanel{//THIS IS A NEW CLASS
	Canvas(Paint paint,JPanel panels){
		this.setBackground(new Color(255,255,255));
		int widthOfWindow = paint.getSize().width;
		int heightOfWindow = paint.getSize().height;
		Dimension dimensionOfCanvas = new Dimension(widthOfWindow-20,heightOfWindow); //20 is width of PaintTools, need to make a variable with acces (parameter?)
		this.setSize(dimensionOfCanvas);
		panels.add(this);
	}
}
