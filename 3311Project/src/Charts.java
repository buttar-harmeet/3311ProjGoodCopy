import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Charts {
	
	private static final int MIN_CHARTS = 1;
	private static final int MAX_CHARTS = 3;
	
	private static int currentCharts = 3;
	
	public Charts() {
		JFrame frame = new JFrame("Chart Frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        
        
//        JTextArea textArea = new JTextArea(15, 50);
//        textArea.setWrapStyleWord(true);
//        textArea.setEditable(false);
//        textArea.setFont(Font.getFont(Font.SANS_SERIF));
//        JScrollPane scroller = new JScrollPane(textArea);
//        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//        JPanel inputpanel = new JPanel();

        JLabel label = new JLabel("Select upto 3 graphs");
        panel.add(label);
        
        JCheckBox LineGraph = new JCheckBox("Line", true);
        JCheckBox TimeSeriesGraph = new JCheckBox("Time Series", true);
        JCheckBox BarGraph = new JCheckBox("Bar", true);
        JCheckBox PieGraph = new JCheckBox("Pie");
        JCheckBox ScatterGraph = new JCheckBox("Scatter");
        
        ActionListener actionListener = new ActionHandler();
        LineGraph.addActionListener(actionListener);
        TimeSeriesGraph.addActionListener(actionListener);
        BarGraph.addActionListener(actionListener);
        PieGraph.addActionListener(actionListener);
        ScatterGraph.addActionListener(actionListener);
       
        
        JPanel graphTypes = new JPanel();
        graphTypes.setLayout(new BoxLayout(graphTypes, BoxLayout.X_AXIS));
        graphTypes.add(LineGraph);
        graphTypes.add(TimeSeriesGraph);
        graphTypes.add(BarGraph);
        graphTypes.add(PieGraph);
        graphTypes.add(ScatterGraph);
        
        panel.add(graphTypes);
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setResizable(true);
        frame.setVisible(true);
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
	        	}
	        } else {
	        	currentCharts--;
	        	if(currentCharts < MIN_CHARTS) {
	        		currentCharts++;
	        		checkbox.setSelected(true);
	        	}
	        }
	    }
	}

}

