package DatabasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnector {
	
	private static DataConnector thisDataConnector;
	private Statement stmt;
	private Connection con;
	private ResultSet rs;
		
	//mysql strings for enginDesktop machine
	private String MYSQL_PORT="3306";
	private String MYSQL_IP="localhost";
	private String MYSQL_DATABASE_NAME="gemi_takip";
	private String MYSQL_USERNAME="root";
	private String MYSQL_PASSWORD="";
	//End of mysql strings for enginDesktop machine
	
	private DataConnector(){
		startConnection();
	}
	
	public static DataConnector getInstance(){
		if( thisDataConnector == null)
			thisDataConnector = new DataConnector();
		return thisDataConnector;
			
	}
	
	private boolean startConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(("jdbc:mysql://"+MYSQL_IP+":"+MYSQL_PORT+"/"+MYSQL_DATABASE_NAME), MYSQL_USERNAME, MYSQL_PASSWORD);
			stmt = con.createStatement();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet query(String query){
		try{
			rs = stmt.executeQuery(query);
			return rs;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean update(String query){
		try{
			stmt.executeUpdate(query);
			System.out.println("query ok");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public void printLastQueryResult(){
		try {
			if (rs != null){
				while(rs.next()){
					ResultSetMetaData rsMetaData = rs.getMetaData();
					int numberOfColumns = rsMetaData.getColumnCount()+1;
					for (int i=1;i<numberOfColumns;i++){
						System.out.println("column: " + rsMetaData.getColumnName(i) + " value: " + rs.getString(i));
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public int countRows(String tableName) throws SQLException {
		// select the number of rows in the table
		int rowCount = -1;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName);
			// get the number of rows from the result set
			rs.last();
			rowCount = rs.getRow();
			} 
		finally {
			}
		return rowCount;
	}
	
}
