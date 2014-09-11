import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolActionListener implements ActionListener {
	private Tool tool;

	public ToolActionListener(Tool tool) {
		this.tool = tool;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OnzeCanvas.tool = this.tool;
	}
}
