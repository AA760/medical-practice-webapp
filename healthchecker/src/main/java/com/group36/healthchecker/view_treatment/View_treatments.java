package com.group36.healthchecker.view_treatment;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View_treatments{		
	public static void main(String[] args) {
		Treatmentviewer();// runs the method Treatmentviewe()
	}
	public static void Treatmentviewer() {
		System.out.println("Here are all the Treatments: "); 
		JTable treatmenttable = new JTable(); // creating a Jtable named treatmenttable
		Object [] columns = {"Treatment ID","Treatment Name","Description","Effectiveness"};//adding columns to the Jtable
		DefaultTableModel treatmentmodel = new DefaultTableModel();//this creates a new model for the table named treatmentmodel
		
		JFrame TrtFrame = new JFrame("Treatment List"); //new frame is created here
		TrtFrame.setSize(850, 300);//setting the size of the frame
		TrtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//adding the option to close the frame 
		Container TrtContainer = TrtFrame.getContentPane();//creating a new container
		
		JPanel titlePanel = new JPanel();
		JPanel MainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JPanel southPanel = new JPanel();
		/*the few code of lines above are creating new panels*/
		
		JLabel TitleLabel = new JLabel("Treatments");//new label created
		TitleLabel.setFont(new Font("Arial", Font.BOLD, 27));//setting the font for the label
		titlePanel.add(TitleLabel);//adding the label to the panel
		
		JLabel lblID = new JLabel("Treatment ID:"); 
		JTextField txttreatmentID = new JTextField(5);
		northPanel.add(lblID);
		northPanel.add(txttreatmentID);
		/*the few lines of code above creates new label, text field and adds both the label and text field to the panel*/
		
		JLabel lblname = new JLabel("Name:"); 
		JTextField txtname = new JTextField(10);
		northPanel.add(lblname);
		northPanel.add(txtname);
		/*the few lines of code above creates new label, text field and adds both the label and text field to the panel*/
		
		JLabel lbldescription= new JLabel("Description:");
		JTextField txtDescription = new JTextField(15);
		northPanel.add(lbldescription);
		northPanel.add(txtDescription);
		/*the few lines of code above creates new label, text field and adds both the label and text field to the panel*/
		
		JLabel lbleffectiveness = new JLabel("Effectiveness:");
		JTextField txteffectiveness = new JTextField(5);
		northPanel.add(lbleffectiveness);
		northPanel.add(txteffectiveness);
		/*the few lines of code above creates new label, text field and adds both the label and text field to the panel*/
		
		Object [] row = new Object[4];//adding rows to the table
		treatmentmodel.setColumnIdentifiers(columns);//setting the column identifiers
		treatmenttable.setModel(treatmentmodel);//setting the model for the table
		
		treatmenttable.setBackground(Color.white);
		treatmenttable.setForeground(Color.black);
		treatmenttable.setSelectionBackground(Color.white);
		treatmenttable.setGridColor(Color.green);
		treatmenttable.setSelectionForeground(Color.gray);
		treatmenttable.setFont(new Font("Calibri",Font.PLAIN, 11));
		treatmenttable.setRowHeight(40);
		treatmenttable.setAutoCreateRowSorter(true);
		/*the few lines of code above sets the properties of the table, this includes setting the font, adding colors to the table */
		
		JScrollPane tablepane = new JScrollPane(treatmenttable);
		tablepane.setForeground(Color.red);
		tablepane.setBackground(Color.white);
		tablepane.setBounds(20,20,700,450);
		southPanel.add(tablepane);
		/*the few lines of code above creates a new scroll pane in the table, and it sets the properties of the pane such as the color and the bounds*/

		JButton Addbutton = new JButton("Add treatment");//creating a new button
		buttonsPanel.add(Addbutton);//adding the button to the buttons panel
		Addbutton.addActionListener(new ActionListener(){//adding an action listener in the button so the button has a function when its clicked on
			public void actionPerformed(ActionEvent e) {//adding the action that will be performed when the button is clicked
				row[0] = txttreatmentID.getText();
				row[1] = txtname.getText();
				row[2] = txtDescription.getText();
				row[3] = txteffectiveness.getText();
				/*the few lines of code above gets text from the text fields above and adds the text in the designated place in the row*/
				treatmentmodel.addRow(row);//adds the row to the jtable
				
				String url = "jdbc:mysql://172.31.82.87:3306/Group_Project";//connecting with the database using this URL
				String username = "root";//username to connect to the database
				String password = "GrouP#36.";//password to connect to the database
				
				try {
					Connection connect = DriverManager.getConnection(url,username,password);//trying to connect to the database
					System.out.println("Connection Successful");//if connection is successful then it will be displayed
					
					String sql = "INSERT INTO treatment(treatment_Id,name,description,effective_On_Disease_Id)VALUES(?,?,?,?)";//sql query
					PreparedStatement prepstatement = connect.prepareStatement(sql);//creating the statement
					prepstatement.setString(1, txttreatmentID.getText());
					prepstatement.setString(2, txtname.getText());
					prepstatement.setString(3, txtDescription.getText());
					prepstatement.setString(4, txteffectiveness.getText());
					/*the few lines of code above sets the string of the designated attribute by getting text from the text fields*/
					int rows = prepstatement.executeUpdate();//executes the sql query
					if (rows>0) {
						System.out.println("Row has been inserted");
						System.out.println("Inserted data includes: " + txttreatmentID.getText() + ", " + txtname.getText() + ", " + txtDescription.getText() + ", " + txteffectiveness.getText());
						//the line above shows if the data was inserted and what data has been inserted
					}
					prepstatement.close();//closing the statement
					connect.close();//closing the connection to the database
					
				}catch(SQLException e1) {
					System.out.println("Connection Failed");//if the connection with the database is failed this will be displayed
					e1.printStackTrace();//this will show what part of the connection process failed
				}
			}
		});
		
		JButton Deletebutton = new JButton("Delete treatment");//adding a delete button
		buttonsPanel.add(Deletebutton);//adding the button to the panel
		Deletebutton.addActionListener(new ActionListener(){//having an action for the button to perform 
			public void actionPerformed(ActionEvent e) {
				int i = treatmenttable.getSelectedRow();//the row that is selected in the jtable will be defined as the variable i
				if(i>=0) {
					treatmentmodel.removeRow(i);//this will remove the row from the table
				}
				else {
					JOptionPane.showMessageDialog(TrtFrame, "Please Select a Treatment to remove before pressing the delete button");
					//if the user does not select a row then this message will be shown
				}
			}
		});
		
		JButton viewbutton = new JButton("View treatment");//adding a view button
		buttonsPanel.add(viewbutton);//adding the button to the panel 
		viewbutton.addActionListener(new ActionListener(){//adding an action for the button
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://172.31.82.87:3306/Group_Project";
				String username = "root";
				String password = "GrouP#36.";
				/*the few lines of code above is used to set the variables to connect to the database*/
				try {
					Connection connection = DriverManager.getConnection(url, username,password);//trying to connect to the database
					Statement st = connection.createStatement(); //new statement created
					System.out.println("Connection Successful");//this message will be displayed if the connection is successful
				
					String sql = "SELECT * from treatment";//sql query
					ResultSet rs = st.executeQuery(sql);
				
					while(rs.next()) {
						
						//Adding data until database table is all finished
						String id = String.valueOf(rs.getString("treatment_Id")); 
						String name = rs.getString("name");
						String description = rs.getString("description");
						String effective_On_Disease_Id = rs.getString("effective_On_Disease_Id");
						
						String dbTable []= {id,name, description, effective_On_Disease_Id}; //String array to store data into JTable
						DefaultTableModel tblModel = (DefaultTableModel)treatmenttable.getModel();
						
						tblModel.addRow(dbTable);//Adding string array data into the table
											
					}
					st.close();//closing the statement
					connection.close();//closing the connection
					
				} catch (SQLException e1) {
					System.out.println("Connected failed ");//this message will be shown if the connection with the database is failed
					
					e1.printStackTrace();//this will show what part of the code cause the connection to fail
				}
			}
		});
		
		//adding the panel to the frame
		TrtFrame.add(MainPanel);
		
		//adding the sub panels to the main panel
		MainPanel.add(titlePanel);
		MainPanel.add(northPanel);
		MainPanel.add(buttonsPanel);
		MainPanel.add(southPanel);
		
		//setting the visibility of the frame to true
		TrtFrame.setVisible(true);
		
	}
}