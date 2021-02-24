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
		
		JButton Addbutton = new JButton("Add treatment");
		buttonsPanel.add(Addbutton);
		Addbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton Deletebutton = new JButton("Delete treatment");
		buttonsPanel.add(Deletebutton);
		Deletebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton Savebutton = new JButton("Save treatment");
		buttonsPanel.add(Savebutton);
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
		
		Object [] row = new Object[4];
		treatmentmodel.setColumnIdentifiers(columns);
		treatmenttable.setModel(treatmentmodel);
		
		treatmenttable.setBackground(Color.white);
		treatmenttable.setForeground(Color.black);
		treatmenttable.setSelectionBackground(Color.white);
		treatmenttable.setGridColor(Color.green);
		treatmenttable.setSelectionForeground(Color.gray);
		treatmenttable.setFont(new Font("Calibri",Font.PLAIN, 13));
		treatmenttable.setRowHeight(40);
		treatmenttable.setAutoCreateRowSorter(true);
		
		JScrollPane tablepane = new JScrollPane(treatmenttable);
		tablepane.setForeground(Color.red);
		tablepane.setBackground(Color.white);
		tablepane.setBounds(10,10,700,350);
		southPanel.add(tablepane);

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