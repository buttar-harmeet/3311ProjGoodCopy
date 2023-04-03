import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScatterGraph extends Graph {

	@Override
	public JPanel createGraph() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.add(new JLabel("Scatter Graph"));
		return panel;
	}

}
