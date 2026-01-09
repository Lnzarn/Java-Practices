import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class detailsgetter extends JFrame implements ActionListener {
    
    JTextField firstName;
    JTextField lastName;
    JRadioButton male, female;
    JButton submit;
    ButtonGroup genderGroup;

    private detailsgetter(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(460, 160));
        this.pack();
        this.setTitle("Details");
        this.setLayout(null);
        this.setResizable(false);

        JLabel labelFirst = new JLabel("First Name");
        JLabel labelLast = new JLabel("Last Name");
        JPanel firstQuarter = new JPanel(new FlowLayout());
        firstQuarter.setBounds(30, 30, 200, 60);
        JPanel secondQuarter = new JPanel(new FlowLayout());
        secondQuarter.setBounds(245, 30, 200, 60);

        firstName = new JTextField();
        firstName.setPreferredSize(new Dimension(200, 30));

        lastName = new JTextField();
        lastName.setPreferredSize(new Dimension(200, 30));

        secondQuarter.add(labelLast);
        secondQuarter.add(lastName);
        firstQuarter.add(labelFirst);
        firstQuarter.add(firstName);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new FlowLayout());
        genderPanel.setBounds(30, 120, 200, 30);
        
        male = new JRadioButton("Male", true);
        male.setActionCommand("Male");
        female = new JRadioButton("Female");
        female.setActionCommand("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        genderPanel.add(male);
        genderPanel.add(female);

        submit = new JButton("Submit");
        submit.setBounds(245, 120, 200, 30);
        submit.addActionListener(this);
        this.add(firstQuarter);
        this.add(secondQuarter);
        this.add(genderPanel);
        this.add(submit);

        this.setVisible(true);
    }
    
    public String getGenderButtonValue(){
        ButtonModel selectedButton = genderGroup.getSelection();

        String command = (String) selectedButton.getActionCommand();
        return command;
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == submit){
            if(firstName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "First Name is Required", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Last Name is Required", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to save?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "This is saved.");
                System.out.println("Name: " + firstName.getText() + " " + lastName.getText() + "\nGender: " + getGenderButtonValue());
            } else if (choice == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "This is not saved");
            }
        }
    }
    public static void main(String[] args) {
        new detailsgetter();
    }
}
