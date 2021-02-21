
/**
 * 
 * 
 * @author tanvirakhtershakib
 *
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class RetrievePatientsData {
  
  public static void main(String[] args) {
 
    Connection connection = null;
    try {
 
  // Loading the MySQL JDBC driver
 
  String driverName = "com.mysql.jdbc.Driver";
 
  Class.forName(driverName);
 
 
  // Creating a connection to the database
 
  String serverName = "localhost";
 
  String schema = "test";
 
  String url = "jdbc:mysql://" + serverName +  "/" + schema;
 
  String username = "username";
 
  String password = "password";
 
  connection = DriverManager.getConnection(url, username, password);
 
   
 
  System.out.println("Successfully Connected to the database!");
 
   
    } catch (ClassNotFoundException e) {
 
  System.out.println("Could not find the database driver " + e.getMessage());
    } catch (SQLException e) {
 
  System.out.println("Could not connect to the database " + e.getMessage());
    }
 
    try {
 
 
// Getting a result set containing all data from test_table
 
Statement statement = connection.createStatement();
 
ResultSet results = statement.executeQuery("SELECT * FROM test_table");
 
 
 
while (results.next()) {
 
 
  // Getting the data from the current row using the column index - column data are in the VARCHAR format
 
  String data = results.getString(1);
 
  System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);
 
 
  // Getting the data from the current row using the column name - column data are in the VARCHAR format
 
  data = results.getString("test_col");
 
  System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);
 
 
}

 
    } catch (SQLException e) {
 
  System.out.println("Could not retrieve data from the database " + e.getMessage());
    }
 
  }
}
