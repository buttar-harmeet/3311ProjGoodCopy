import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarGraph extends Graph {

	@Override
	public JPanel createGraph() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.add(new JLabel("Bar Graph"));
		return panel;

	}

}
