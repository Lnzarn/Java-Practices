import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class storeSetup extends JFrame implements ActionListener, ItemListener{
    JPanel mainPanel = new JPanel();
    JPanel centPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel discountPanel = new JPanel();
    JPanel botPanel = new JPanel();
    
    JLabel mainLabel = new JLabel("PUP Lagoon Store");
    String[] courses = {"BSCS", "BSIT", "BAMS", "BSIK"};
    JTextField nameField = new JTextField();
    JComboBox courseField = new JComboBox(courses);

    JCheckBox shake = new JCheckBox("Shake");
    JCheckBox fewa = new JCheckBox("Fewa");
    JCheckBox siomai = new JCheckBox("Sioma w/ Rice");
    JCheckBox gulaman = new JCheckBox("Gulaman");
    JCheckBox fried = new JCheckBox("Fried Noodles");
    JCheckBox hotcake = new JCheckBox("Hotcake");
    JCheckBox chicken = new JCheckBox("Chicken w/ Rice");
    JCheckBox water = new JCheckBox("Water");

    JRadioButton pwd = new JRadioButton("PWD");
    JRadioButton senior = new JRadioButton("Senior");
    JRadioButton noDisc = new JRadioButton("No Discount");
    ButtonGroup group = new ButtonGroup();

    JTextField total = new JTextField();
    JTextField money = new JTextField();
    JTextField change = new JTextField();
    JTextField vat = new JTextField();

    JButton confirm = new JButton("Confirm");
    JButton reset = new JButton("Reset");
    double totalPrice = 0;

    public storeSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(400,500));
        this.pack();
        this.setResizable(false);

        mainPanel.setLayout(new BorderLayout());
        centPanel.setLayout(new GridLayout(7,2,5,5));
        southPanel.setLayout(new BorderLayout());
        discountPanel.setLayout(new GridLayout(2,3,10,10));
        botPanel.setLayout(new GridLayout(5,2,5,5));

        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(mainLabel, BorderLayout.NORTH);
        mainPanel.add(centPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        centPanel.add(new JLabel("NAME:"));
        centPanel.add(nameField);
        centPanel.add(new JLabel("COURSE"));
        centPanel.add(courseField);
        centPanel.add(new JLabel("ITEMS:"));
        centPanel.add(new JLabel(" "));
        centPanel.add(shake);
        centPanel.add(fewa);
        centPanel.add(siomai);
        centPanel.add(gulaman);
        centPanel.add(fried);
        centPanel.add(hotcake);
        centPanel.add(chicken);
        centPanel.add(water);

        southPanel.add(discountPanel, BorderLayout.NORTH);
        southPanel.add(botPanel, BorderLayout.CENTER);

        discountPanel.add(new JLabel("DISCOUNT:"));
        discountPanel.add(new JLabel(" "));
        discountPanel.add(new JLabel(" "));
        discountPanel.add(pwd);
        discountPanel.add(senior);
        discountPanel.add(noDisc);

        botPanel.add(new JLabel("TOTAL:"));
        botPanel.add(total);
        botPanel.add(new JLabel("MONEY INSERTED:"));
        botPanel.add(money);
        botPanel.add(new JLabel("CHANGE:"));
        botPanel.add(change);
        botPanel.add(new JLabel("VAT:"));
        botPanel.add(vat);
        botPanel.add(confirm);
        botPanel.add(reset);

        group.add(pwd);
        group.add(senior);
        group.add(noDisc);

        total.setEditable(false);
        change.setEditable(false);
        vat.setEditable(false);
        confirm.addActionListener(this);
        reset.addActionListener(this);
        shake.addItemListener(this);
        fewa.addItemListener(this);
        siomai.addItemListener(this);
        gulaman.addItemListener(this);
        chicken.addItemListener(this);
        water.addItemListener(this);
        hotcake.addItemListener(this);
        fried.addItemListener(this);
        this.add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object s = e.getSource();
        
        if(s == confirm){
            if(nameField.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please Enter your name", "No Name", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (totalPrice == 0){
                JOptionPane.showMessageDialog(this, "Please pick any product!", "No Products", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (money.getText().isEmpty() || !money.getText().matches("\\d+")){
                JOptionPane.showMessageDialog(this, "Please Enter Appropriate Money!", "No Money", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            if (pwd.isSelected()){
                totalPrice = totalPrice*.75;
            } else if(senior.isSelected()){
                totalPrice = totalPrice*.70;
            } 
            double moneyOwn = Double.parseDouble(money.getText());
            double changeLeft = moneyOwn - totalPrice;
            if (changeLeft < 0){
                JOptionPane.showMessageDialog(this, "Not Enough Money!", "Not Enough", JOptionPane.ERROR_MESSAGE);
                return;
            }
            total.setText(String.valueOf(totalPrice));
            change.setText(String.valueOf(changeLeft));
            vat.setText(String.valueOf(totalPrice*.12));
            JOptionPane.showMessageDialog(this, "Successful!", "Thank you!", JOptionPane.INFORMATION_MESSAGE);
            resetAll();
        }  else if(s == reset){
            resetAll();
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        Object s = e.getSource();
        double tempTotal = 0;
        if(s == shake)tempTotal += 20;
        if(s ==fewa)tempTotal += 60;
        if(s ==siomai) tempTotal += 60;
        if(s ==gulaman) tempTotal += 10;
        if(s ==fried) tempTotal += 40;  
        if(s ==hotcake) tempTotal += 20;
        if(s ==chicken)tempTotal += 70;
        if(s ==water)tempTotal += 10;
    
        if(e.getStateChange()== ItemEvent.SELECTED){
            totalPrice += tempTotal;
        } else if (e.getStateChange()== ItemEvent.DESELECTED){
            totalPrice -= tempTotal;
        }

        total.setText(String.valueOf(totalPrice));
    }
    public void resetAll(){
        shake.setSelected(false);
        fewa.setSelected(false);
        siomai.setSelected(false);
        gulaman.setSelected(false);
        fried.setSelected(false);
        hotcake.setSelected(false);
        chicken.setSelected(false);
        water.setSelected(false);
        nameField.setText("");
        courseField.setSelectedIndex(-1);
        money.setText("");
        change.setText("");
        total.setText("");
        vat.setText("");
        group.clearSelection();
        totalPrice = 0;
        }

}

public class Main {
    public static void main(String[] args){
        new storeSetup();
    }
}