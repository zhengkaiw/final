package com.neu.jan17.UI;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import com.neu.jan17.data.Category;
import com.neu.jan17.data.Vehicle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

//更改了一些变量名，直接使用Vehicle类，增加了相应参数，调整了类型和顺序。

@SuppressWarnings("serial")
public class InventoryManagementScreen extends JFrame {


    private JPanel totalPanel;
    private JPanel topPanel;
    private JPanel midPanel;
    private JPanel bottomPanel;
    private JTable inventoryData;
    private JScrollPane inventoryPane;
    private JLabel dealerNameLabel;
    private JButton avehicleButton;
    private JButton updateButton;
    private JButton viewButton;
    private JButton deleteButton;

    public InventoryManagementScreen() {

        Vehicles vehicles = new Vehicles();

    }

    public  InventoryManagementScreen(String dealerId) {

        dealerNameLabel = new JLabel(dealerId);

        Vehicles vehicles = new Vehicles();
        vehicles.addData("2228104413","gmps-aj-dohmann",Category.NEW,2014,"Cadillac","CTS Sedan","3.6L V6 AWD Luxury","CAR",57620.0f,"http://inventory-dmg.assets-cdk.com/5/1/7/13411480715x90.jpg");

        inventoryData = new JTable(new dealerModel(vehicles));
        inventoryData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        inventoryPane = new JScrollPane(inventoryData);

        avehicleButton = new JButton("Add");
        avehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddVehicleToInventory();
            }
        });
        updateButton = new JButton("Update");

        topPanel = new JPanel();
        midPanel = new JPanel();
        bottomPanel = new JPanel();
        topPanel.add(dealerNameLabel);
        midPanel.add(inventoryPane);
        bottomPanel.add(avehicleButton);
        bottomPanel.add(updateButton);

        setLayout(new BorderLayout(2, 2));
        getContentPane().add("Center", midPanel);
        getContentPane().add("South", bottomPanel);
        setVisible(true);
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   /* It's defined in other's file as class Vehicle. 
    * class Vehicle {

        private String category;
        private String year;
        private String make;
        private String model;
        private String trim;
        private String type;
        private String price;

        Vehicle(String category, String year, String make, String model, String trim, String type, String price) {
            this.category = category;
            this.year = year;
            this.make = make;
            this.model = model;
            this.trim = trim;
            this.type = type;
            this.price = price;
        }

    }*/

    class Vehicles {

        Vector<Vehicle> data = new Vector<>();

        Vehicles() {
        }

        public void addData(String id, String webId, Category category, Integer year, String make, String model, String trim, String bodyType, float price,String photo) {
            Vehicle vehicle = new Vehicle();
            vehicle.setAllDetails(id, webId, category, year, make, model, trim, bodyType, price, photo);
            data.add(vehicle);
        }

        public Vehicle showData(int row) {
            return data.get(row);
        }

    }

    class dealerModel extends AbstractTableModel {

        private Vehicles vehicles;
        private String[] name = {"Id","WebId", "Category","Year", "Make", "Model", "Trim", "Bodytype", "Price","Photo"};

        dealerModel(Vehicles vehicles) {
            this.vehicles = vehicles;
        }

        public int getRowCount() {
            return vehicles.data.size();
        }

        public int getColumnCount() {
            return 10;
        }

        public Object getValueAt(int row, int col) {
            Vehicle vehicle = vehicles.showData(row);
            if (col == 0) {
                return vehicle.getId();
            } else if (col == 1) {
                return vehicle.getWebId();
            } else  if (col == 2) {
                return vehicle.getCategory();
            }else if (col == 3) {
                return vehicle.getYear();
            } else if (col == 4) {
                return vehicle.getMake();
            } else if (col == 5) {
                return vehicle.getModel();
            } else if (col == 6) {
                return vehicle.getTrim();
            } else  if (col == 7) {
                return vehicle.getBodyType();
            }else  if (col == 8) {
                return vehicle.getPrice();
            }else {
            	return vehicle.getPhoto();
            }
        }

        public String getColumnName(int colIndex) {
            return name[colIndex];
        }

        public Class getColumnClass(int c) {
            return String.class;
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        public void setValueAt(String aValue, int row, int col) {

        }
    }

    public static void main(String[] args) {


        new InventoryManagementScreen("aj-dohmann");
    }
}
