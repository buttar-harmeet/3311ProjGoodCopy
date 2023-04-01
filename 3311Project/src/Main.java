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


    public static void main(String[] args) throws Exception {

        JFrame f = new JFrame("NHPI Statistics");

        // Set top bar
        JLabel chooseCountryLabel = new JLabel("Choose a Province: ");
        chooseCountryLabel.setBounds(100, 10, 200, 100);
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
        countriesList.setBounds(250, 10, 100, 100 );

        JLabel from = new JLabel("From");
        from.setBounds(400, 10, 100, 100);
        JLabel to = new JLabel("To");
        to.setBounds(700, 10, 100, 100);
        Vector<String> years = new Vector<String>();
        for (int i = 2021; i >= 2010; i--) {
            years.add("" + i);
        }
        JComboBox<String> fromList = new JComboBox<String>(years);
        fromList.setBounds(450, 10, 200, 100);
        JComboBox<String> toList = new JComboBox<String>(years);
        toList.setBounds(750, 10, 200, 100);

        f.add(chooseCountryLabel);
        f.add(countriesList);
        f.add(from);
        f.add(fromList);
        f.add(to);
        f.add(toList);


        JButton viewTables = new JButton("View Tables / Raw Data");
        viewTables.setBounds(50, 100, 200, 300);
        viewTables.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createChartFrame();
            }
        });

        JButton viewCharts = new JButton("View Graphs / Charts");
        viewCharts.setBounds(300, 100, 200, 300);
        viewCharts.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createChartFrame();
            }
        });

        JButton viewStatistics = new JButton("View Statistical Tests");
        viewStatistics.setBounds(550, 100, 200, 300);
        viewStatistics.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statisticalTestFrame();
            }
        });

        JButton viewMachineTest = new JButton("View Machine Tests");
        viewMachineTest.setBounds(800, 100, 200, 300);
        viewMachineTest.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statisticalTestFrame();
            }
        });

        f.add(viewTables);
        f.add(viewCharts);
        f.add(viewStatistics);
        f.add(viewMachineTest);
        f.setSize(1050, 600);
        f.setLayout(null);
        f.setVisible(true);
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



