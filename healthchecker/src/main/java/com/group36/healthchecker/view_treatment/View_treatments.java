package com.group36.healthchecker.view_treatment;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View_treatments{		
	public static void main(String[] args) {
		Treatmentviewer();
	}
	private static void Treatmentviewer() {
		JFrame TrtFrame = new JFrame("Treatments");
		TrtFrame.setSize(450, 300);
		TrtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container TrtContainer = TrtFrame.getContentPane();
		TrtContainer.setBackground(new Color(200-155-200));
		TrtContainer.setLayout(new FlowLayout());
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(new Color(20-244-109));
		TitlePanel.setPreferredSize(new Dimension(350, 40));
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(200-255-255));
		MainPanel.setPreferredSize(new Dimension(100, 100));
		
		JPanel MainPanel2 = new JPanel();
		MainPanel2.setBackground(new Color(78-150-55));
		MainPanel2.setPreferredSize(new Dimension(250, 100));

		JPanel ButtonsPanel = new JPanel();
		ButtonsPanel.setBackground(new Color(200-25-255)); 
		ButtonsPanel.setPreferredSize(new Dimension(400, 70));

		JLabel TitleLabel = new JLabel("Treatments");
		TitleLabel.setFont(new Font("Arial", Font.BOLD, 27));
		
		JLabel InfoCategories = new JLabel("Treatment ID:");
		JLabel InfoCategories1 = new JLabel("Name:");
		JLabel InfoCategories2= new JLabel("Description:");
		JLabel InfoCategories3 = new JLabel("Effectiveness:");
		
		JTextField txttreatmentID = new JTextField();
		JTextField txtname = new JTextField();
		JTextField txtDescription = new JTextField();
		JTextField txteffectiveness = new JTextField();
		
		JButton Prevbutton = new JButton("Previous");
		Prevbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton Addbutton = new JButton("Add");
		Addbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton Editbutton = new JButton("Edit");
		Editbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton Deletebutton = new JButton("Delete");
		Deletebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton Nextbutton = new JButton("Next");
		Nextbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton Savebutton = new JButton("Save");
		Savebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Savetodb();
			}
		});
		
		
		TitlePanel.add(TitleLabel);
		MainPanel.add(InfoCategories);
		MainPanel.add(InfoCategories1);
		MainPanel.add(InfoCategories2);
		MainPanel.add(InfoCategories3);
		MainPanel2.add(txttreatmentID);
		MainPanel2.add(txtname);
		MainPanel2.add(txtDescription);
		MainPanel2.add(txteffectiveness);
		ButtonsPanel.add(Prevbutton);
		ButtonsPanel.add(Addbutton);
		ButtonsPanel.add(Editbutton);
		ButtonsPanel.add(Deletebutton);
		ButtonsPanel.add(Nextbutton);
		ButtonsPanel.add(Savebutton);
		TrtFrame.add(TitlePanel);
		TrtFrame.add(MainPanel);
		TrtFrame.add(MainPanel2);
		TrtFrame.add(ButtonsPanel);
		TrtFrame.setVisible(true);
	}
	
	static Connection con() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://172.31.82.87:3306/Group_Project";
			Class.forName(driver);
			
			return DriverManager.getConnection(url,"root","GrouP#36");
		} catch (Exception e) {
			System.out.println("Connection With Database Failed" + e);
		}
		return null;
	}
	
	private static void Savetodb() {
		Connection con = con();
		try {
			String query = "insert into treatment(?,?,?,?)";
			PreparedStatement prepstatement = con.prepareStatement(query);
			prepstatement.setString(1,txttreatmentID.getText());
			prepstatement.setString(2,txtname.getText());
			prepstatement.setString(3,txtDescription.getText());
			prepstatement.setString(4,txteffectiveness.getText());
			prepstatement.execute();
			
			JOptionPane.showMessageDialog(null,"Data Saved");
		} catch(Exception e) {
			System.out.println("Error"+ e);
		}
	}

}