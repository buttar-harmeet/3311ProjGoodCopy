import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Charts {
	
	private static final int MIN_CHARTS = 1;
	private static final int MAX_CHARTS = 3;
	
	private static int currentCharts = 3;
	private static Set<Graph> graphs = new HashSet<>();
	
	private Graph Line = new LineGraph();
	private Graph Bar = new BarGraph();
	private Graph Pie = new PieGraph();
	private Graph Scatter = new ScatterGraph();
	private Graph TimeSeries = new TimeSeriesGraph();
	
	private static Charts instance;
	
	public static void getInstance() {
		if(instance == null)
			instance = new Charts();
		
		instance = null;
	}
	
	public Charts() {
		JFrame frame = new JFrame("Chart Frame");
		graphs = new HashSet<>();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        
        JPanel graphTypes = new JPanel();
        graphTypes.setLayout(new BoxLayout(graphTypes, BoxLayout.X_AXIS));
        
        JPanel graphsPanel = new JPanel();
        graphsPanel.setLayout(new BoxLayout(graphsPanel, BoxLayout.X_AXIS));
        

        JLabel label = new JLabel("Select upto 3 graphs");
        panel.add(label);
        
        JCheckBox LineGraph = new JCheckBox("Line", true);
        graphs.add(Line);
        JCheckBox TimeSeriesGraph = new JCheckBox("Time Series", true);
        graphs.add(TimeSeries);;
        JCheckBox BarGraph = new JCheckBox("Bar", true);
        graphs.add(Bar);
        JCheckBox PieGraph = new JCheckBox("Pie");
        JCheckBox ScatterGraph = new JCheckBox("Scatter");
        
        ActionListener actionListener = new ActionHandler();
        LineGraph.addActionListener(actionListener);
        TimeSeriesGraph.addActionListener(actionListener);
        BarGraph.addActionListener(actionListener);
        PieGraph.addActionListener(actionListener);
        ScatterGraph.addActionListener(actionListener);
       
        JButton btn = new JButton("Apply");
        btn.addActionListener(e -> {
        	reloadPanel(graphsPanel);
        });
        
        graphTypes.add(LineGraph);
        graphTypes.add(TimeSeriesGraph);
        graphTypes.add(BarGraph);
        graphTypes.add(PieGraph);
        graphTypes.add(ScatterGraph);
        graphTypes.add(btn);
        
        
        panel.add(graphTypes);
        
        
        for(Graph graph: graphs)
        	graphsPanel.add(graph.createGraph());
        
        panel.add(graphsPanel);        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setResizable(true);
        frame.setVisible(true);
	}
	
	private static void reloadPanel(JPanel panel) {
		panel.removeAll();
		for(Graph graph: graphs) panel.add(graph.createGraph());
		panel.validate();
		panel.repaint();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class ActionHandler implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent event) {
	        JCheckBox checkbox = (JCheckBox) event.getSource();
	        if(checkbox.isSelected()) {
	        	currentCharts++;
	        	
	        	if(currentCharts > MAX_CHARTS) {
	        		checkbox.setSelected(false);
	        		currentCharts--;
	        	} else {
		        	// Line to add graph type.
	        		graphs.add(getGraph(checkbox.getText()));
	        	}
	        } else {
	        	currentCharts--;
	        	if(currentCharts < MIN_CHARTS) {
	        		currentCharts++;
	        		checkbox.setSelected(true);
	        	} else {
	        		// Line to remove graph type.
	        		graphs.remove(getGraph(checkbox.getText()));
	        	}
	        }
	    }
	    
	}
	
	private Graph getGraph(String s) {
		if(s.equals("Line")) return Line;
		else if(s.equals("Time Series")) return TimeSeries;
		else if(s.equals("Bar")) return Bar;
		else if(s.equals("Scatter")) return Scatter;
		else if(s.equals("Pie")) return Pie;
		
		return null;
	}

}

