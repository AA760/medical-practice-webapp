package com.group36.healthchecker.view_treatment;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
	public static void Treatmentviewer() {
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
		ButtonsPanel.setPreferredSize(new Dimension(350, 75));

		JLabel TitleLabel = new JLabel("Treatments");
		TitleLabel.setFont(new Font("Arial", Font.BOLD, 27));
		
		JLabel InfoCategories = new JLabel("Treatment ID:");
		JLabel InfoCategories1 = new JLabel("Name:");
		JLabel InfoCategories2= new JLabel("Description:");
		JLabel InfoCategories3 = new JLabel("Effectiveness:");
		
		TitlePanel.add(TitleLabel);
		MainPanel.add(InfoCategories);
		MainPanel.add(InfoCategories1);
		MainPanel.add(InfoCategories2);
		MainPanel.add(InfoCategories3);
		TrtFrame.add(TitlePanel);
		TrtFrame.add(MainPanel);
		TrtFrame.add(MainPanel2);
		TrtFrame.add(ButtonsPanel);
		TrtFrame.setVisible(true);
	}
}