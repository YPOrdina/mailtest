import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorActionListener implements ActionListener {
	private Color color;

	public ColorActionListener(Color color) {
		this.color = color;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Paint.colour = this.color;
	}
}
