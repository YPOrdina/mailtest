import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaintButtonBar extends JPanel {
	private static final long serialVersionUID = -4231725755257399965L;

	public PaintButtonBar(int width, int height) {
		this.setSize(width,height);
		
		createButtonWithIconAndActionListener("icon/pencilIcon.png", new Pen());
		createButtonWithIconAndActionListener("icon/eraserIcon.png", new Gum());
		createButtonWithIconAndActionListener("icon/brushIcon.png", new PaintBucket());
		createButtonWithIconAndActionListener("icon/colorIcon.png", new DashPen());
		
		createButtonWithIconAndActionListener("icon/black.png", Color.BLACK);
		createButtonWithIconAndActionListener("icon/white.png", Color.WHITE);
		createButtonWithIconAndActionListener("icon/grey.png", Color.GRAY);
		createButtonWithIconAndActionListener("icon/red.png", Color.RED);
		createButtonWithIconAndActionListener("icon/green.png", Color.GREEN);
		createButtonWithIconAndActionListener("icon/blue.png", Color.BLUE);
		createButtonWithIconAndActionListener("icon/yellow.png", Color.YELLOW);
		createButtonWithIconAndActionListener("icon/orange.png", Color.ORANGE);
		createButtonWithIconAndActionListener("icon/pink.png", Color.PINK);
		createButtonWithIconAndActionListener("icon/lightBlue.png", Color.CYAN);
		createButtonWithIconAndActionListener("icon/purple.png", Color.MAGENTA);
	}
	
	private void createButtonWithIconAndActionListener(String path, Color color) {
		JButton button = new JButton("",  createImageIcon(path));
		button.addActionListener(new ColorActionListener(color));
        add(button);
	}
	
	private void createButtonWithIconAndActionListener(String path, Tool tool) {
		JButton button = new JButton("",  createImageIcon(path));
		button.addActionListener(new ToolActionListener(tool));
        add(button);
	}

	private ImageIcon createImageIcon(String path) {
		URL imgURL = PaintButtonBar.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find image in system: " + path);
			return null;
		}
	}
}