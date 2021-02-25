package com.group36.healthchecker.view_treatment;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View_treatments{		
	public static void main(String[] args) {
		//SpringApplication.run(View_treatments.class,args);
		Treatmentviewer();
	}
	public static void Treatmentviewer() {
		System.out.println("Here are all the Treatments: ");
		JTable treatmenttable = new JTable();
		Object [] columns = {"Treatment ID","Treatment Name","Description","Effectiveness"};
		DefaultTableModel treatmentmodel = new DefaultTableModel();
		
		JFrame TrtFrame = new JFrame("Treatment List");
		TrtFrame.setSize(850, 300);
		TrtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container TrtContainer = TrtFrame.getContentPane();
		
		JPanel titlePanel = new JPanel();
		JPanel MainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		JLabel TitleLabel = new JLabel("Treatments");
		TitleLabel.setFont(new Font("Arial", Font.BOLD, 27));
		titlePanel.add(TitleLabel);
		
		JLabel lblID = new JLabel("Treatment ID:");
		JTextField txttreatmentID = new JTextField(5);
		northPanel.add(lblID);
		northPanel.add(txttreatmentID);
		
		JLabel lblname = new JLabel("Name:");
		JTextField txtname = new JTextField(10);
		northPanel.add(lblname);
		northPanel.add(txtname);
		
		JLabel lbldescription= new JLabel("Description:");
		JTextField txtDescription = new JTextField(15);
		northPanel.add(lbldescription);
		northPanel.add(txtDescription);
		
		JLabel lbleffectiveness = new JLabel("Effectiveness:");
		JTextField txteffectiveness = new JTextField(5);
		northPanel.add(lbleffectiveness);
		northPanel.add(txteffectiveness);
		
		Object [] row = new Object[4];
		treatmentmodel.setColumnIdentifiers(columns);
		treatmenttable.setModel(treatmentmodel);
		
		treatmenttable.setBackground(Color.white);
		treatmenttable.setForeground(Color.black);
		treatmenttable.setSelectionBackground(Color.white);
		treatmenttable.setGridColor(Color.green);
		treatmenttable.setSelectionForeground(Color.gray);
		treatmenttable.setFont(new Font("Calibri",Font.PLAIN, 11));
		treatmenttable.setRowHeight(40);
		treatmenttable.setAutoCreateRowSorter(true);
		
		JScrollPane tablepane = new JScrollPane(treatmenttable);
		tablepane.setForeground(Color.red);
		tablepane.setBackground(Color.white);
		tablepane.setBounds(20,20,700,450);
		southPanel.add(tablepane);

		JButton Addbutton = new JButton("Add treatment");
		buttonsPanel.add(Addbutton);
		Addbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				row[0] = txttreatmentID.getText();
				row[1] = txtname.getText();
				row[2] = txtDescription.getText();
				row[3] = txteffectiveness.getText();
				
				treatmentmodel.addRow(row);
				
				String url = "jdbc:mysql://172.31.82.87:3306/Group_Project";
				String username = "root";
				String password = "GrouP#36.";
				
				try {
					Connection connect = DriverManager.getConnection(url,username,password);
					System.out.println("Connection Successful");
					
					String sql = "INSERT INTO treatment(treatment_Id,name,description,effective_On_Disease_Id)VALUES(?,?,?,?)";
					PreparedStatement prepstatement = connect.prepareStatement(sql);
					prepstatement.setString(1, txttreatmentID.getText());
					prepstatement.setString(2, txtname.getText());
					prepstatement.setString(3, txtDescription.getText());
					prepstatement.setString(4, txteffectiveness.getText());
					
					int rows = prepstatement.executeUpdate();
					if (rows>0) {
						System.out.println("Row has been inserted");
						System.out.println("Inserted data includes: " + txttreatmentID.getText() + " " + txtname.getText() + " " + txtDescription.getText() + " " + txteffectiveness.getText());
					}
					prepstatement.close();
					connect.close();
					
				}catch(SQLException e1) {
					System.out.println("Connection Failed");
					e1.printStackTrace();
				}
			}
		});
		
		JButton Deletebutton = new JButton("Delete treatment");
		buttonsPanel.add(Deletebutton);
		Deletebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int i = treatmenttable.getSelectedRow();
				if(i>=0) {
					treatmentmodel.removeRow(i);
				}
				else {
					JOptionPane.showMessageDialog(TrtFrame, "Please Select a Treatment to remove");
				}
			}
		});
		
		JButton viewbutton = new JButton("View treatment");
		buttonsPanel.add(viewbutton);
		viewbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://172.31.82.87:3306/Group_Project";
				String username = "root";
				String password = "GrouP#36.";
				
				try {
					Connection connection = DriverManager.getConnection(url, username,password);
					Statement st = connection.createStatement(); 
					System.out.println("Connection Successful");
				//mySql query 
				
					String sql = "SELECT * from treatment";
					ResultSet rs = st.executeQuery(sql);
				
					while(rs.next()) {
						
					//Adding data until db table is all finished
						
						String id = String.valueOf(rs.getString("treatment_Id")); 
						String name = rs.getString("name");
						String description = rs.getString("description");
						String effective_On_Disease_Id = rs.getString("effective_On_Disease_Id");
					
					//String array for store data into JTable
						
						String dbTable []= {id,name, description, effective_On_Disease_Id}; 
						DefaultTableModel tblModel = (DefaultTableModel)treatmenttable.getModel();
						
					//Adding string array data into the table
						tblModel.addRow(dbTable);
											
					}
					st.close();
					connection.close();
					
				} catch (SQLException e1) {
					System.out.println("Connected failed ");
					
					e1.printStackTrace();
				}
			}
		});
		
		TrtFrame.add(MainPanel);
		MainPanel.add(titlePanel);
		MainPanel.add(northPanel);
		MainPanel.add(buttonsPanel);
		MainPanel.add(southPanel);
		TrtFrame.setVisible(true);
		
	}
	
	static Connection con() {
		try {
			//String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://172.31.82.87:3306/Group_Project";
			//Class.forName(driver);
			
			return DriverManager.getConnection(url,"root","GrouP#36");
		} catch (Exception e) {
			System.out.println("Connection With Database Failed" + e);
		}
		return null;
	}
}