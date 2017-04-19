package com.neu.jan17.UI;

import javax.swing.*;

import com.neu.jan17.data.Category;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 使用groupLayout，但是运行显示不出来*/

@SuppressWarnings("serial")
public class AddVehicleToInventory extends JFrame {

	private Category category;
	private JPanel panel;
	private JLabel headline, categoryLabel, yearLabel, makeLabel, modelLabel, trimLabel, typeLabel, priceLabel;
	private JComboBox<Category> categoryCB;
	private JTextField yearText, makeText, modelText, trimText, typeText, priceText;
	private JButton clearButton, confirmButton;

	public AddVehicleToInventory() {
		createComponents();
		createLayout();
		addComponents();
		addActionListener();
		display();
		setSize(400, 400);
		setVisible(true);
	}

	@SuppressWarnings("static-access")
	public void createComponents() {

		headline = new JLabel("ADD VEHICLE");
		categoryLabel = new JLabel("Category");
		yearLabel = new JLabel("Year");
		makeLabel = new JLabel("Make");
		modelLabel = new JLabel("Model");
		trimLabel = new JLabel("Trim");
		typeLabel = new JLabel("Type");
		priceLabel = new JLabel("Price");

		yearText = new JTextField(5);
		makeText = new JTextField(5);
		modelText = new JTextField(5);
		trimText = new JTextField(5);
		typeText = new JTextField(5);
		priceText = new JTextField(5);

		categoryCB = new JComboBox<Category>(category.values());

		clearButton = new JButton("Clear");
		confirmButton = new JButton("Confirm");
	}

	public void createLayout() {
		// setLayout(new BorderLayout(5, 5));
		panel = new JPanel();

		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		// panel.setLayout(new GridLayout(0,2));

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(categoryLabel)
						.addComponent(yearLabel)
						.addComponent(makeLabel)
						.addComponent(modelLabel)
						.addComponent(trimLabel)
						.addComponent(typeLabel)
						.addComponent(priceLabel)
						.addComponent(clearButton))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(headline)
						.addComponent(categoryCB)
						.addComponent(yearText)
						.addComponent(makeText)
						.addComponent(modelText)
						.addComponent(trimText)
						.addComponent(typeText)
						.addComponent(priceText)
						.addComponent(confirmButton)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(headline)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(categoryLabel)
						.addComponent(categoryCB))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(yearLabel)
						.addComponent(yearText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(makeLabel)
						.addComponent(makeText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(trimLabel)
						.addComponent(trimText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(typeLabel)
						.addComponent(typeText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(priceLabel)
						.addComponent(priceText))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(clearButton)
						.addComponent(confirmButton)));

	}

	public void addComponents() {
/*
		Container con = getContentPane();
		con.add("Center", panel);

		  panel.add(headline); panel.add(categoryLabel); panel.add(categoryCB);
		  panel.add(yearLabel); panel.add(yearText); panel.add(makeLabel);
		  panel.add(makeText); panel.add(modelLabel); panel.add(modelText);
		  panel.add(trimLabel); panel.add(trimText); panel.add(typeLabel);
		  panel.add(typeText); panel.add(priceLabel); panel.add(priceText);
		  panel.add(clearButton); panel.add(confirmButton);
		 
*/
	}

	public void addActionListener() {
		clearButton.addActionListener(new ActionListener() {
			@Override
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

	public void display() {
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new AddVehicleToInventory();
	}

}
