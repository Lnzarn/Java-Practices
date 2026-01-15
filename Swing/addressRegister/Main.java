import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class registrationSetup extends JFrame implements ActionListener{
    JPanel mainPanel = new JPanel();
    JPanel centPanel = new JPanel();
   
    JPanel radioPanel = new JPanel();
    JPanel comboPanel = new JPanel();
    
    JTextField nameField = new JTextField(20);
    JTextField mobileField = new JTextField(20);
    JTextField addressField = new JTextField(50);
    JTextArea result = new JTextArea();

    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup group = new ButtonGroup();
    JCheckBox terms = new JCheckBox("Accept Terms and Conditions");

    JButton submit = new JButton("Submit");
    JButton reset = new JButton("Reset");
     JScrollPane eastPanel = new JScrollPane(result);
    String[] dayArr = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
        };

        String[] monthsArr = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        String[] yearArr = {
            "2000", "2001", "2002", "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010", "2011", "2012"
        };

    JComboBox day = new JComboBox(dayArr);
    JComboBox month = new JComboBox(monthsArr);
    JComboBox year = new JComboBox(yearArr);
    JLabel mainLabel = new JLabel("Registration Form");
    public registrationSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(1000,300));
        this.pack();
        this.setResizable(false);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centPanel.setLayout(new GridLayout(7,2,5,5));
        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        comboPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        eastPanel.setLayout(new ScrollPaneLayout());
        
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        mainPanel.add(mainLabel, BorderLayout.NORTH);
        mainPanel.add(centPanel, BorderLayout.CENTER);
        mainPanel.add(eastPanel, BorderLayout.EAST);

        group.add(male);
        group.add(female);

        centPanel.add(new JLabel("Name"));
        centPanel.add(nameField);
        centPanel.add(new JLabel("Mobile"));
        centPanel.add(mobileField);
        centPanel.add(new JLabel("Gender"));
        centPanel.add(radioPanel);
        centPanel.add(new JLabel("DOB"));
        centPanel.add(comboPanel);
        centPanel.add(new JLabel("Address"));
        centPanel.add(addressField);
        centPanel.add(terms);
        centPanel.add(new JLabel(" "));
        centPanel.add(submit);
        centPanel.add(reset);

        radioPanel.add(male);
        radioPanel.add(female);

        comboPanel.add(day);
        comboPanel.add(month);
        comboPanel.add(year);

        eastPanel.setPreferredSize(new Dimension(400,300));
        submit.addActionListener(this);
        reset.addActionListener(this);
        this.add(mainPanel);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object s = e.getSource();

        if(s == submit){
            if (validateInputs()){
                String name = "Name: " + nameField.getText()+"\n";
                String number = "Mobile: " + mobileField.getText()+"\n";
                String gender = "Gender: " + (male.isSelected() ? "Male" : "Female")+"\n";
                String DOB = "DOB: " + (String)day.getSelectedItem()+"/"+(String)month.getSelectedItem()+"/"+(String)year.getSelectedItem()+"\n";
                String address = "Address: "+ addressField.getText()+"\n";

                result.append(name+number+gender+DOB+address+"\n\n");
            }
        } else if (s == reset){
            result.setText("");
            nameField.setText("");
            mobileField.setText("");
            addressField.setText("");
            day.setSelectedIndex(-1);
            month.setSelectedIndex(-1);
            year.setSelectedIndex(-1);
            group.clearSelection();
            terms.setSelected(false);
        }
    }

    public Boolean validateInputs(){
        if(!terms.isSelected()){
                JOptionPane.showMessageDialog(this, "Please Accept Terms and Conditions", "Terms and Condition", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        if(nameField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Your Name", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (mobileField.getText().isEmpty() || !mobileField.getText().matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Please Enter Your Number", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (addressField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Your Address", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!(male.isSelected() || female.isSelected())){
            JOptionPane.showMessageDialog(this, "Please specify your gender", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } 

        return true;
    }
}
public class Main {
    public static void main(String[] args){
        new registrationSetup();
    }
}
