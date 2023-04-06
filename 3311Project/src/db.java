import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class db {
	private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    static ArrayList<ArrayList<String>> datasets = new ArrayList<>();
    
    public db() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/db?"
                            + "user=root&password=password");

            statement = connect.createStatement();
            // Result set get the result of the SQL query
//            resultSet = statement
//                    .executeQuery("select * from db.nhip");
//            writeResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        }

    }
    
    public static ResultSet getData(ArrayList<String> dataset) {
		try {
			ResultSet result = statement.executeQuery("Select GEO, VALUE, REF_DATE from db.nhip "
					+ "WHERE GEO = '"+ dataset.get(0)+"' AND REF_DATE BETWEEN "+ dataset.get(1) + " AND "+ dataset.get(2));
			return result;
			 //writeResultSet(result);
		} catch (SQLException e) {
			System.out.println("Select GEO, VALUE, REF_DATE from db.nhip "
					+ "WHERE GEO = '"+dataset.get(0)+"' AND REF_DATE BETWEEN "+ dataset.get(1) + " AND "+ dataset.get(2));
			System.out.println("Error occured in getData()\n");
			e.printStackTrace();
		}
    	return null;
    }

    private static void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
        	//REF_DATE, GEO, DGUID, NHPI, UOM, UOM_ID, SCALAR_FACTOR, SCALAR_ID, VECTOR, COORDINATE, VAL, STAT
            String refDate = resultSet.getString("REF_DATE");
            String geo = resultSet.getString("GEO");
            String Val = resultSet.getString("VALUE");

            
            
            
            System.out.println("refDate: " + refDate);
            System.out.println("GEO: " + geo);
            System.out.println("VAL:" + Val);
            System.out.println("---------------------------------------");
        }
    }
    
    public static Vector<String> getGEO(){
    	Vector<String> list = new Vector<>();
    	
    	ResultSet result = null;
    	try {
			result = statement.executeQuery("select Distinct GEO from db.nhip");
			while(result.next()) list.add(result.getString("GEO"));
			
		} catch (SQLException e) {
			System.out.println("Error occured in getData()\n");
			e.printStackTrace();
		}
    	
    	return list;
    }

}
