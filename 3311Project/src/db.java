import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class db {
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public db() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/db?"
                            + "user=root&password=password");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
//            resultSet = statement
//                    .executeQuery("select * from db.nhip");
//            writeResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        }

    }
    
    public ResultSet getData(String city, String year1, String year2) {
    	ResultSet result = null;
		try {
			result = statement.executeQuery("Select VALUE, REF_DATE from db.nhip where "
					+ "GEO = "+city+" AND REF_DATE BETWEEN "+ year1 + " AND "+ year2);
		} catch (SQLException e) {
			System.out.println("Error occured in getData()\n");
			e.printStackTrace();
		}
    	return result;
    }


    private void writeResultSet(ResultSet resultSet) throws SQLException {
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
    
    public Vector<String> getGEO(){
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

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
