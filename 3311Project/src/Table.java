import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	public Table() {
		JFrame frame = new JFrame("Table");        
		
		String[][] data = getData();
		String[] column = {"Date", "Location", "Value"};
	    
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt); 
	    
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.add(sp);          
	    frame.setSize(300,400);   
	    frame.setResizable(true);
	    frame.setVisible(true);    
	}
	
	private static String[][] getData() {
		ArrayList<ArrayList<String>> data = new ArrayList<>();
	    
	    for(int i=0; i < db.datasets.size(); i++) {
			ArrayList<String> array = db.datasets.get(i);
			ArrayList<String> arr = null;
			try {
				ResultSet result = db.getData(array);
				while(result.next()) {
					arr = new ArrayList<>();
					String year = result.getString("REF_DATE").substring(0, 4);
					String month = result.getString("REF_DATE").substring(5);
					arr.add(month+"-"+year);
					arr.add(result.getString("GEO"));
					arr.add(result.getString("VALUE"));
					data.add(arr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    
	    String[][] result = new String[data.size()][3];
	    int index = 0;
	    for(ArrayList<String> list: data) {
	    	result[index][0] = list.get(0);
	    	result[index][1] = list.get(1);
	    	result[index][2] = list.get(2);
	    	index++;
	    }
	    return result;
	}
}
