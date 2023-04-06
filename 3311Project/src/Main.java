//package statsVisualiser.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;

public class Main {
	
	private static final int BTN_WIDTH = 250;
	private static final int BTN_HEIGHT = 100;
	

    public static void main(String[] args) throws Exception {
    	new db();
        createMainFrame();
    }

    public static void createMainFrame() {
    	JFrame f = new JFrame("NHPI Statistics");
        
        JPanel topbar = new JPanel();
        topbar.setLayout(new BoxLayout(topbar, BoxLayout.Y_AXIS));
        topbar.setMinimumSize(topbar.getMinimumSize());
        addDataSet(topbar);
        addDataSet(topbar);
        
        JButton btn = new JButton("Add dataset");
        btn.addActionListener(e -> {
        	topbar.remove(topbar.getComponentCount() -  1);
        	addDataSet(topbar);
        	topbar.add(btn);
        	topbar.setMinimumSize(topbar.getMinimumSize());
        	f.validate();
        	f.repaint();
        });
        topbar.add(btn);
        
        f.getContentPane().add(topbar, BorderLayout.NORTH);
        
        JPanel buttons = new JPanel();

        JButton viewTables = new JButton("View Tables / Raw Data");
        viewTables.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));
        viewTables.addActionListener(e -> {
        	updateDatasets(topbar);
        	tableFrame();
        });

        JButton viewCharts = new JButton("View Graphs / Charts");
        viewCharts.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));
        viewCharts.addActionListener(e -> {
        	updateDatasets(topbar);
        	createChartFrame();
        });

        JButton viewStatistics = new JButton("View Statistical Tests");
        viewStatistics.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));
        viewStatistics.addActionListener(e -> {
        	updateDatasets(topbar);
        	statisticalTestFrame();
        });

        JButton viewMachineTest = new JButton("View Machine Tests");
        viewMachineTest.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));
        viewMachineTest.addActionListener(e -> {
        	updateDatasets(topbar);
        	machineTestFrame();
        });

        buttons.add(viewTables);
        buttons.add(viewCharts);
        buttons.add(viewStatistics);
        buttons.add(viewMachineTest);
        
        f.getContentPane().add(buttons, BorderLayout.CENTER);
      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(f.getMaximumSize());
        f.setVisible(true);
    }
    
    public static void addDataSet(JPanel container) {
    	JPanel panel = new JPanel();
    	
    	// Set top bar
        JLabel chooseCountryLabel = new JLabel("Choose a Province: ");
        JLabel from = new JLabel("From");
        JLabel to = new JLabel("To");

        Vector<String> years = new Vector<String>();
        for (int i = 2021; i >= 2010; i--) {
            years.add("" + i);
        }
        
        Vector<String> months = new Vector<>();
        for(int i=1; i < 13; i++) {
        	if(i < 10)
        		months.add("0"+i);
        	else
        		months.add(""+i);
        }
        
        JComboBox<String> countriesList = new JComboBox<String>(db.getGEO());
        JComboBox<String> fromMonthList = new JComboBox<String>(months);
        JComboBox<String> fromList = new JComboBox<String>(years);
        JComboBox<String> toMonthList = new JComboBox<String>(months);
        JComboBox<String> toList = new JComboBox<String>(years);


        panel.add(chooseCountryLabel);
        panel.add(countriesList);
        
        panel.add(from);
        panel.add(fromMonthList);
        panel.add(fromList);
        
        panel.add(to);
        panel.add(toMonthList);
        panel.add(toList);
        
        JButton btn = new JButton("-");
        btn.addActionListener(e -> {
        	if(container.getComponentCount() > 3){
        		container.remove(panel);	
        		container.setSize(container.getWidth(),container.getHeight() - panel.getHeight());
        		container.validate();
        		container.repaint();
        	}
        });
        panel.add(btn);
        container.add(panel);
    }


    public static void tableFrame() {
        new Table();
    }
    public static void createChartFrame() {
    	new Charts();
        }

    public static void statisticalTestFrame() {
    	new StatisticalTest();

    }
    public static void machineTestFrame() {

        JFrame frame = new JFrame("Machine Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        JTextArea textArea = new JTextArea(15, 50);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel inputpanel = new JPanel();

        panel.add(scroller);

        panel.add(inputpanel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);

    }
    
    @SuppressWarnings("unchecked")
	private static void updateDatasets(JPanel panel) {
    	db.datasets = new ArrayList<>();
    	for(int i=0; i < panel.getComponentCount() - 1; i++) {
    		JPanel temp = (JPanel) panel.getComponent(i);
    		// index -> 1 for city,3 and 4 for starting month and year, 6 and 7 for ending month and year
    		String city = String.valueOf(((JComboBox<String>)temp.getComponent(1)).getSelectedItem());
    		String month1 = String.valueOf(((JComboBox<String>)temp.getComponent(3)).getSelectedItem());
    		String year1 = String.valueOf(((JComboBox<String>)temp.getComponent(4)).getSelectedItem());
    		String month2 = String.valueOf(((JComboBox<String>)temp.getComponent(6)).getSelectedItem());
    		String year2 = String.valueOf(((JComboBox<String>)temp.getComponent(7)).getSelectedItem());
    		
    		ArrayList<String> list = new ArrayList<String>();
    		list.add(city);
    		list.add(year1+"-"+month1);
    		list.add(year2+"-"+month2);
    		
    		db.datasets.add(list);
    	}
    }

    }



