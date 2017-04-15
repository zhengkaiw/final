import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by zhengkevin on 4/14/17.
 */
public class UI_Dealer extends JFrame {

    private JPanel totalPanel;
    private JPanel panel_top;
    private JPanel panel_mid;
    private JPanel panel_bottom;
    private JTable dealer_data;
    private JScrollPane dealer_pane;
    private JLabel dealer_name;
    private JButton dealer_add;
    private JButton dealer_update;
    private JButton dealer_view;
    private JButton dealer_delete;

    public UI_Dealer() {

        dealerDatas dds = new dealerDatas();

    }

    public UI_Dealer(String dealerId) {

        dealer_name = new JLabel(dealerId);

        dealerDatas dds = new dealerDatas();
        dds.addData("new", "2014", "Cadillac", "CTS Sedan", "3.6L", "CAR", "54442.0");

        dealer_data = new JTable(new dealerModel(dds));
        dealer_data.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        dealer_pane = new JScrollPane(dealer_data);

        dealer_add = new JButton("Add");
        dealer_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UI_add();
            }
        });
        dealer_update = new JButton("Update");

        panel_top = new JPanel();
        panel_mid = new JPanel();
        panel_bottom = new JPanel();
        panel_top.add(dealer_name);
        panel_mid.add(dealer_pane);
        panel_bottom.add(dealer_add);
        panel_bottom.add(dealer_update);

        setLayout(new BorderLayout(2, 2));
        getContentPane().add("North", panel_top);
        getContentPane().add("Center", panel_mid);
        getContentPane().add("South", panel_bottom);
        setVisible(true);
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class dealerData {

        private String category;
        private String year;
        private String make;
        private String model;
        private String trim;
        private String type;
        private String price;

        dealerData(String category, String year, String make, String model, String trim, String type, String price) {
            this.category = category;
            this.year = year;
            this.make = make;
            this.model = model;
            this.trim = trim;
            this.type = type;
            this.price = price;
        }

    }

    class dealerDatas {

        Vector<dealerData> data = new Vector<>();

        dealerDatas() {
        }

        public void addData(String category, String year, String make, String model, String trim, String type, String price) {
            dealerData dd = new dealerData(category, year, make, model, trim, type, price);
            data.add(dd);
        }

        public dealerData showData(int row) {
            return data.get(row);
        }

    }

    class dealerModel extends AbstractTableModel {

        private dealerDatas dds;
        private String[] name = {"Category", "Year", "Make", "Model", "Trim", "Type", "Price"};

        dealerModel(dealerDatas dds) {
            this.dds = dds;
        }

        public int getRowCount() {
            return dds.data.size();
        }

        public int getColumnCount() {
            return 7;
        }

        public Object getValueAt(int row, int col) {
            dealerData dd = dds.showData(row);
            if (col == 0) {
                return dd.category;
            } else if (col == 1) {
                return dd.year;
            } else if (col == 2) {
                return dd.make;
            } else if (col == 3) {
                return dd.model;
            } else if (col == 4) {
                return dd.trim;
            } else if (col == 5) {
                return dd.type;
            } else {
                return dd.price;
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


        new UI_Dealer("aj-dohmann");
    }
}
