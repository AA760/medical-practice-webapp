package com.group36.healthchecker.repository;

/**
 * 
 * 
 * @author tanvirakhtershakib
 *
 *
 */


import java.sql.*;

public class SearchPatientsName {
   public static void main(String[] args) throws Exception {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      Connection con = DriverManager.getConnection(
         "jdbc:derby://localhost:1527/testDb","username", "password");
      
      Statement stmt = con.createStatement();
      String query[] = {
         "SELECT * FROM emp where id = 1", 
         "select name from emp where name like 'tanvir_'", 
         "select name from emp where name like 'tanvir%'" 
      };
      
      for(String q : query) {
         ResultSet rs = stmt.executeQuery(q);
         System.out.println("Search for Patient's name"+q);
         
         while (rs.next()) {
            String name = rs.getString("name");
            System.out.print(name+"  ");
         }
         System.out.println();
      }
   }
}
