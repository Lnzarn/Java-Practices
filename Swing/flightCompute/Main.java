import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class setupFrame extends JFrame implements ActionListener,ItemListener{
    
    JPanel mainPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    
    JTextField destiField = new JTextField();
    JTextField retField = new JTextField();
    JTextField vouchField = new JTextField();
    JTextField resultField = new JTextField(20);
    
    JComboBox fromBox = new JComboBox();
    JComboBox toBox = new JComboBox();

    JRadioButton oneWay = new JRadioButton("One Way");
    JRadioButton returnTrip = new JRadioButton("Return Trip");
    JRadioButton domestic = new JRadioButton("Domestic");
    JRadioButton international = new JRadioButton("International");
    JRadioButton pwd = new JRadioButton("PWD");

    ButtonGroup groupOne = new ButtonGroup();
    ButtonGroup groupTwo = new ButtonGroup();

    JCheckBox addOne = new JCheckBox("Additional 25kg");
    JCheckBox addTwo = new JCheckBox("Additional 35kg");
    JCheckBox addThree = new JCheckBox("Add Meals");
    JCheckBox addFour = new JCheckBox("Exclusive Seat");

    JButton computeBtn = new JButton("COMPUTE");

    String[] domArr = {"Manila", "Cebu"};
    String[] interArr = {"Hong Kong", "Manila"};

    int totalCost = 0;
    public setupFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(400,500));
        this.pack();
        this.setResizable(true);

        mainPanel.setLayout(new BorderLayout());

        contentPanel.setLayout(new GridLayout(11, 2, 6, 6));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(12,6,6,12));

        contentPanel.add(oneWay);
        contentPanel.add(returnTrip);
        contentPanel.add(domestic);
        contentPanel.add(international);
        contentPanel.add(new JLabel("DESTINATION:"));
        contentPanel.add(new JLabel("RETURN:"));
        contentPanel.add(destiField);
        contentPanel.add(retField);
        contentPanel.add(new JLabel("FROM:"));
        contentPanel.add(fromBox);
        contentPanel.add(new JLabel("TO:"));
        contentPanel.add(toBox);
        contentPanel.add(new JLabel("ADD ONS:"));
        contentPanel.add(new JLabel(" "));
        contentPanel.add(addOne);
        contentPanel.add(addTwo);
        contentPanel.add(addThree);
        contentPanel.add(addFour);
        contentPanel.add(new JLabel("DISCOUNTS:"));
        contentPanel.add(new JLabel("VOUCHERS:"));
        contentPanel.add(pwd);
        contentPanel.add(vouchField);

        groupOne.add(oneWay);
        groupOne.add(returnTrip);
        groupTwo.add(domestic);
        groupTwo.add(international);
        resultPanel.setLayout(new GridLayout(3, 1, 5, 5));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(computeBtn);
        
        resultPanel.add(buttonPanel);
        resultPanel.add(new JLabel("TOTAL COST:"));
        resultPanel.add(resultField);

        JLabel mainLabel = new JLabel("Enrique Transport");
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(mainLabel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        fromBox.setSelectedIndex(-1);
        toBox.setSelectedIndex(-1);
        oneWay.addActionListener(this);
        returnTrip.addActionListener(this);
        domestic.addActionListener(this);
        international.addActionListener(this);
        addOne.addActionListener(this);
        addTwo.addActionListener(this);
        addThree.addActionListener(this);
        addFour.addActionListener(this);
        pwd.addActionListener(this);
        computeBtn.addActionListener(this);
        fromBox.addItemListener(this);
        toBox.addItemListener(this);
        this.add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==oneWay){
            retField.setEnabled(false);
        } else if (e.getSource()==returnTrip) {
            retField.setEnabled(true);
        } else if (e.getSource()==domestic) {
            fromBox.removeAllItems();
            toBox.removeAllItems();
            for (String x : domArr){
                fromBox.addItem(x);
            }
            for (String x : domArr){
                toBox.addItem(x);
            }
        } else if (e.getSource()==international) {
            fromBox.removeAllItems();
            toBox.removeAllItems();
            for (String x : interArr){
                fromBox.addItem(x);
            }
            for (String x : interArr){
                toBox.addItem(x);
            }
        }  else if (e.getSource()==computeBtn) {
            computeTotal();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == fromBox){
            destiField.setText((String) fromBox.getSelectedItem() + " to " + (String) toBox.getSelectedItem());
            retField.setText((String) toBox.getSelectedItem() + " to " + (String) fromBox.getSelectedItem());
        } else if(e.getSource()== toBox){
            destiField.setText((String) fromBox.getSelectedItem() + " to " + (String) toBox.getSelectedItem());
            retField.setText((String) toBox.getSelectedItem() + " to " + (String) fromBox.getSelectedItem());
        }
    }
    private void computeTotal(){
        totalCost = 0;
        

        if("Manila".equals((String) fromBox.getSelectedItem()) && "Cebu".equals((String) toBox.getSelectedItem())){
            totalCost += 1500;
        } else if ("Cebu".equals((String) fromBox.getSelectedItem()) && "Manila".equals((String) toBox.getSelectedItem())){
            totalCost += 1600;
        } else if ("Manila".equals((String) fromBox.getSelectedItem()) && "Hong Kong".equals((String) toBox.getSelectedItem())){
            totalCost += 3600;
        } else if ("Hong Kong".equals((String) fromBox.getSelectedItem()) && "Manila".equals((String) toBox.getSelectedItem())){
            totalCost += 2600;
        } 

        
        if("DISCOUNT!".equals(vouchField.getText())){
            totalCost += totalCost*.1;
        }  else if (pwd.isSelected()) {
            totalCost -= totalCost*.05;
        }
        if (addOne.isSelected()) {
            totalCost += totalCost*.05;
        } 
        if (addTwo.isSelected()) {
            totalCost += totalCost*.07;
        } 
        if (addThree.isSelected()) {
            totalCost += totalCost*.03;
        } 
        if (addFour.isSelected()) {
            totalCost += totalCost*.05;
        } 
        
        
        resultField.setText(String.valueOf(totalCost));
    }
}


public class Main {
    public static void main(String[] args){
        new setupFrame();
    }
}
