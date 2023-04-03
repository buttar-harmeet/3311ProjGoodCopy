import javax.swing.JLabel;
import javax.swing.JPanel;

public class PieGraph extends Graph {

	@Override
	public JPanel createGraph() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.add(new JLabel("Pie Graph"));
		return panel;
	}

}
