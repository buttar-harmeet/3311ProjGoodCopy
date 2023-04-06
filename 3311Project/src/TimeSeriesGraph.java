import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class TimeSeriesGraph extends Graph {

	@Override
	public JPanel createGraph() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		
		for(int i=0; i < db.datasets.size(); i++) {
			ArrayList<String> array = db.datasets.get(i);
			
			TimeSeries series = new TimeSeries("NHIP/YEAR");
			int year, month, day = 1;
			try {
				ResultSet result = db.getData(array);
				while(result.next()) {
					year = Integer.parseInt(result.getString("REF_DATE").substring(0, 4));
					month = Integer.parseInt(result.getString("REF_DATE").substring(5));
					series.addOrUpdate(new Day(day, month, year), result.getDouble("VALUE"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			dataset.addSeries(series);
		}
		
		
		XYPlot plot = new XYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		
		plot.setDataset(0, dataset);
		plot.setRenderer(0, renderer);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.mapDatasetToRangeAxis(0, 0);

		JFreeChart chart = new JFreeChart("NHIP over the Years",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		panel.add(chartPanel);
		
		return panel;
	}

}
