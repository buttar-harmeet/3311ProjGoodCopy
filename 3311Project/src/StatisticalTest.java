


import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math4.legacy.stat.descriptive.rank.Percentile.*;


public class StatisticalTest {
    
    public StatisticalTest() { 
    	JFrame frame = new JFrame("Statistical Test");
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	
    	double[] data = getData();
    	
    	 // Get a DescriptiveStatistics instance
        DescriptiveStatistics stats = new DescriptiveStatistics();

        // Add the data from the array
        for (int i = 0; i < data.length; i++) {
            stats.addValue(data[i]);
        }

        // Compute some statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        
        JLabel meanLabel = new JLabel("MEAN: "+mean);
        JLabel stdLabel = new JLabel("Standard Deviation: "+std);
        panel.add(meanLabel);
        panel.add(stdLabel);
        
        System.out.println(mean);
        System.out.println(std);
   
    	frame.getContentPane().add(BorderLayout.CENTER, panel);
    	frame.pack();
    	frame.setLocationByPlatform(true);
    	frame.setVisible(true);
    	frame.setResizable(true);
    }
    
    public static double[] getData() {
    	ArrayList<Double> arr = new ArrayList<>();
    	
    	for(int i=0; i < db.datasets.size(); i++) {
			ArrayList<String> array = db.datasets.get(i);

			try {
				ResultSet result = db.getData(array);
				while(result.next()) {
					arr.add(result.getDouble("VALUE"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
    	double[] array = new double[arr.size()];
    	int index = 0;
    	for(double val: arr) {
    		array[index++] = val;
    		System.out.println(val);
    	}
    	return array;
    }
    
}