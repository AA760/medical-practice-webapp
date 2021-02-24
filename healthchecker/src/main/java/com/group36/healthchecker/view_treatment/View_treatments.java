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
		
		JFrame TrtFrame = new JFrame("Add a new Treatment to the List:");
		TrtFrame.setSize(450, 300);
		TrtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container TrtContainer = TrtFrame.getContentPane();
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(new Color(20-244-109));
		TitlePanel.setPreferredSize(new Dimension(350, 40));
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(200-255-255));
		MainPanel.setPreferredSize(new Dimension(100, 100));
		
		JPanel MainPanel2 = new JPanel();
		MainPanel2.setBackground(new Color(78-150-55));
		MainPanel2.setPreferredSize(new Dimension(200, 25));
		
		JPanel MainPanel3 = new JPanel();
		MainPanel2.setBackground(new Color(78-150-55));
		MainPanel2.setPreferredSize(new Dimension(200, 25));
		
		JPanel MainPanel4 = new JPanel();
		MainPanel2.setBackground(new Color(78-150-55));
		MainPanel2.setPreferredSize(new Dimension(200, 25));
		
		JPanel MainPanel5 = new JPanel();
		MainPanel2.setBackground(new Color(78-150-55));
		MainPanel2.setPreferredSize(new Dimension(200, 25));

		JPanel ButtonsPanel = new JPanel();
		ButtonsPanel.setBackground(new Color(200-25-255)); 
		ButtonsPanel.setPreferredSize(new Dimension(400, 70));

		JLabel TitleLabel = new JLabel("Treatments");
		TitleLabel.setFont(new Font("Arial", Font.BOLD, 27));
		
		JLabel InfoCategories = new JLabel("Treatment ID:");
		JLabel InfoCategories1 = new JLabel("Name:");
		JLabel InfoCategories2= new JLabel("Description:");
		JLabel InfoCategories3 = new JLabel("Effectiveness:");
		
		JTextField txttreatmentID = new JTextField(5);
		JTextField txtname = new JTextField(10);
		JTextField txtDescription = new JTextField(15);
		JTextField txteffectiveness = new JTextField(5);
		
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
		
		
		TitlePanel.add(TitleLabel);
		MainPanel.add(InfoCategories);
		MainPanel.add(InfoCategories1);
		MainPanel.add(InfoCategories2);
		MainPanel.add(InfoCategories3);
		MainPanel2.add(txttreatmentID);
		MainPanel3.add(txtname);
		MainPanel4.add(txtDescription);
		MainPanel5.add(txteffectiveness);
		ButtonsPanel.add(Addbutton);
		ButtonsPanel.add(Deletebutton);
		ButtonsPanel.add(Savebutton);
		TrtFrame.add(TitlePanel);
		TrtFrame.add(MainPanel);
		TrtFrame.add(MainPanel2);
		TrtFrame.add(MainPanel3);
		TrtFrame.add(MainPanel4);
		TrtFrame.add(MainPanel5);
		TrtFrame.add(ButtonsPanel);
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