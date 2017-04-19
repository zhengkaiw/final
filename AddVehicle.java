package com.neu.jan17.UI;

import javax.swing.*;

import com.neu.jan17.data.Category;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AddVehicle extends JFrame {

	private Category category;
	private JPanel panel,headPanel,bottomPanel;
	private JLabel headline, idLabel, webIdLabel, categoryLabel, yearLabel, makeLabel, modelLabel, trimLabel, typeLabel,
			priceLabel, photoLabel;
	private JComboBox<Category> categoryCB;
	private JTextField idText, webIdText, yearText, makeText, modelText, trimText, typeText, priceText, photoText;
	private JButton clearButton, confirmButton;

	public AddVehicle() {
		createComponents();
		addComponents();
		createLayout();
		addActionListener();
		display();
	}

	@SuppressWarnings("static-access")
	public void createComponents() {

		panel = new JPanel();
		headPanel = new JPanel();
		bottomPanel=new JPanel();

		headline = new JLabel("ADD VEHICLE");
		idLabel = new JLabel("ID");
		webIdLabel = new JLabel("WebId");
		categoryLabel = new JLabel("Category");
		yearLabel = new JLabel("Year");
		makeLabel = new JLabel("Make");
		modelLabel = new JLabel("Model");
		trimLabel = new JLabel("Trim");
		typeLabel = new JLabel("BodyType");
		priceLabel = new JLabel("Price");
		photoLabel = new JLabel("Photo URL");

		idText = new JTextField(5);
		webIdText = new JTextField(5);
		yearText = new JTextField(5);
		makeText = new JTextField(5);
		modelText = new JTextField(5);
		trimText = new JTextField(5);
		typeText = new JTextField(5);
		priceText = new JTextField(5);
		photoText = new JTextField(5);

		categoryCB = new JComboBox<Category>(category.values());

		clearButton = new JButton(" Clear ");
		confirmButton = new JButton("Confirm");
		
	}

	public void addComponents() {

		

		headPanel.add(headline);
		panel.add(idLabel);
		panel.add(idText);
		panel.add(webIdLabel);
		panel.add(webIdText);
		panel.add(categoryLabel);
		panel.add(categoryCB);
		panel.add(yearLabel);
		panel.add(yearText);
		panel.add(makeLabel);
		panel.add(makeText);
		panel.add(modelLabel);
		panel.add(modelText);
		panel.add(trimLabel);
		panel.add(trimText);
		panel.add(typeLabel);
		panel.add(typeText);
		panel.add(priceLabel);
		panel.add(priceText);
		panel.add(photoLabel);
		panel.add(photoText);
		bottomPanel.add(clearButton);
		bottomPanel.add(confirmButton);

	}
	
	public void createLayout() {
		
		setLayout(new BorderLayout(5, 5));
		
		Container con = getContentPane();
		con.add("Center", panel);
		con.add("North", headPanel);
		con.add("South", bottomPanel);
		
		GridLayout grid = new GridLayout(0,2);
		FlowLayout flow=new FlowLayout();
		panel.setLayout(grid);
		panel.setBackground(Color.WHITE);
		bottomPanel.setLayout(flow);
		

		Font f1 = new Font("Meiryo UI",Font.BOLD, 20);
		Font f2 = new Font("Meiryo UI", Font.BOLD, 40);
		Font f3 = new Font("Meiryo UI", Font.BOLD, 30);
		changeFont(con,f1);
		
		//headPanel.setBackground(Color.ORANGE);
		headline.setForeground(Color.RED);
		headline.setFont(f2);
		
		categoryCB.setBackground(Color.WHITE);
		
		clearButton.setBackground(Color.RED);
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(f3);

		confirmButton.setBackground(Color.RED);
		confirmButton.setForeground(Color.WHITE);
		confirmButton.setFont(f3);


	}



	public void addActionListener() {
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearText.setText("");
				makeText.setText("");
				modelText.setText("");
				trimText.setText("");
				typeText.setText("");
				priceText.setText("");
			}
		});
	}
	
	public void changeFont(Component component, Font font) {

		component.setFont(font);
		if (component instanceof Container) {
			for (Component child : ((Container) component).getComponents()) {
				changeFont(child, font);
			}
		}
	}

	public void display() {

		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new AddVehicle();
	}

}
