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
		Object [] columns = {"Treatment ID","Treatment Name","Treatment Description","Treatment Effectiveness"};
		DefaultTableModel treatmentmodel = new DefaultTableModel();
		
		JFrame TrtFrame = new JFrame("Treatment List");
		TrtFrame.setSize(450, 300);
		TrtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container TrtContainer = TrtFrame.getContentPane();
		
		JPanel MainPanel = new JPanel();
		//MainPanel.setBackground(new Color(20-244-109));
		//MainPanel.setPreferredSize(new Dimension(350, 40));
		
		JPanel northPanel = new JPanel();
		//northPanel.setBackground(new Color(200-255-255));
		//northPanel.setPreferredSize(new Dimension(100, 100));
		
		JPanel southPanel = new JPanel();
		//southPanel.setBackground(new Color(78-150-55));
		//southPanel.setPreferredSize(new Dimension(200, 25));

		JLabel TitleLabel = new JLabel("Treatments");
		TitleLabel.setFont(new Font("Arial", Font.BOLD, 27));
		
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
		
		JButton Addbutton = new JButton("Add");
		Addbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton Deletebutton = new JButton("Delete");
		Deletebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton Savebutton = new JButton("Save");
		Savebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Connection con = con();
				try {
					String query = "insert into treatment(?,?,?,?)";
					PreparedStatement prepstatement = con.prepareStatement(query);
					prepstatement.setString(1, txttreatmentID.getText());
					prepstatement.setString(2, txtname.getText());
					prepstatement.setString(3, txtDescription.getText());
					prepstatement.setString(4, txteffectiveness.getText());
					prepstatement.execute();
					
					JOptionPane.showMessageDialog(null,"Data Saved");
				} catch(Exception e1) {
					System.out.println("Error"+ e1);
				}
			}
		});
		
		

		TrtFrame.add(MainPanel);
		MainPanel.add(northPanel);
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