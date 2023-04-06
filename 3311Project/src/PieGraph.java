import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.TableOrder;

public class PieGraph extends Graph {

	@Override
	public JPanel createGraph() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(int i=0; i < db.datasets.size(); i++) {
			ArrayList<String> array = db.datasets.get(i);
			
			int year;
			try {
				ResultSet result = db.getData(array);
				while(result.next()) {
					String geo = result.getString("GEO");
					year = Integer.parseInt(result.getString("REF_DATE").substring(0, 4));
					dataset.addValue(result.getDouble("VALUE"), geo.toString(), String.valueOf(year));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		JFreeChart pieChart = ChartFactory.createMultiplePieChart("NHIP / Year", dataset,
				TableOrder.BY_COLUMN, true, true, false);

		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		panel.add(chartPanel);
		
		return panel;
	}

}
