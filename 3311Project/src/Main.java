//package statsVisualiser.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.*;

public class Main {
	
	private static final int BTN_WIDTH = 250;
	private static final int BTN_HEIGHT = 100;

    public static void main(String[] args) throws Exception {
    	
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
        	tableFrame();
        });

        JButton viewCharts = new JButton("View Graphs / Charts");
        viewCharts.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));
        viewCharts.addActionListener(e -> {
        	createChartFrame();
        });

        JButton viewStatistics = new JButton("View Statistical Tests");
        viewStatistics.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));
        viewStatistics.addActionListener(e -> {
        	statisticalTestFrame();
        });

        JButton viewMachineTest = new JButton("View Machine Tests");
        viewMachineTest.setPreferredSize(new Dimension(BTN_WIDTH,BTN_HEIGHT));
        viewMachineTest.addActionListener(e -> {
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
        //chooseCountryLabel.setBounds(100, 10, 200, 100);
        Vector<String> provincesNames = new Vector<String>();
        provincesNames.add("Ontario");
        provincesNames.add("Quebec");
        provincesNames.add("Saskatchewan");
        provincesNames.add("Manitoba");
        provincesNames.add("Alberta");
        provincesNames.add("British Columbia");
        provincesNames.add("PEI");
        provincesNames.add("Nova Scotia");
        provincesNames.add("Nunavut");
        provincesNames.sort(null);
        JComboBox<String> countriesList = new JComboBox<String>(provincesNames);
        //countriesList.setBounds(250, 10, 100, 100 );

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

        JFrame frame = new JFrame("Table/Raw Data Frame");
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
        textArea.setFont(Font.getFont(Font.SANS_SERIF));
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
    public static void createChartFrame() {
    	new Charts();
        }

    public static void statisticalTestFrame() {

        JFrame frame = new JFrame("Statistical Test");
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

    }



