import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhengkevin on 4/14/17.
 */
public class UI_add extends JFrame {

    private JPanel panel;
    private JLabel l_category;
    private JLabel l_year;
    private JLabel l_make;
    private JLabel l_model;
    private JLabel l_trim;
    private JLabel l_type;
    private JLabel l_price;
    private JTextField tf_category;
    private JTextField tf_year;
    private JTextField tf_make;
    private JTextField tf_model;
    private JTextField tf_trim;
    private JTextField tf_type;
    private JTextField tf_price;
    private JButton b_clear;
    private JButton b_confirm;


    public UI_add() {

        l_category = new JLabel("Category");
        l_year = new JLabel("Year");
        l_make = new JLabel("Make");
        l_model = new JLabel("Model");
        l_trim = new JLabel("Trim");
        l_type = new JLabel("Type");
        l_price = new JLabel("Price");

        tf_category = new JTextField(5);
        tf_year = new JTextField(5);
        tf_make = new JTextField(5);
        tf_model = new JTextField(5);
        tf_trim = new JTextField(5);
        tf_type = new JTextField(5);
        tf_price = new JTextField(5);

        b_clear = new JButton("Clear");
        b_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_category.setText("");
                tf_year.setText("");
                tf_make.setText("");
                tf_model.setText("");
                tf_trim.setText("");
                tf_type.setText("");
                tf_price.setText("");
            }
        });
        b_confirm = new JButton("Confirm");
        b_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tf1 = tf_category.getText();
                String tf2 = tf_year.getText();
                String tf3 = tf_make.getText();
                String tf4 = tf_model.getText();
                String tf5 = tf_trim.getText();
                String tf6 = tf_type.getText();
                String tf7 = tf_price.getText();

                dispose();
            }
        });

        panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));
        panel.add(l_category);
        panel.add(tf_category);
        panel.add(l_year);
        panel.add(tf_year);
        panel.add(l_make);
        panel.add(tf_make);
        panel.add(l_model);
        panel.add(tf_model);
        panel.add(l_trim);
        panel.add(tf_trim);
        panel.add(l_type);
        panel.add(tf_type);
        panel.add(l_price);
        panel.add(tf_price);

        panel.add(b_clear);
        panel.add(b_confirm);

        setLayout(new BorderLayout(5, 5));
        getContentPane().add("Center", panel);
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new UI_add();
    }

}
