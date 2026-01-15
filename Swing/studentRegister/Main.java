import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class frameSetup extends JFrame implements ActionListener{
    
    JPanel mainPanel = new JPanel();
    JPanel centPanel = new JPanel();
    JPanel botPanel = new JPanel();
    JPanel btnPanel = new JPanel();
    JPanel radPanel = new JPanel();
    
    JLabel mainLabel = new JLabel("Registration");
    JTextField nameField = new JTextField();
    JTextField mobField = new JTextField();
    JTextField birthField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField emailConField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JPasswordField passConField = new JPasswordField();
    

    String[] coursesArr = {"BSCS", "BSIT"};
    JComboBox<String> courses = new JComboBox<>(coursesArr);

    JRadioButton btnOne = new JRadioButton("1ST SEM");
    JRadioButton btnTwo = new JRadioButton("2ND SEM");
    ButtonGroup group = new ButtonGroup();

    JTextArea result = new JTextArea();
    JButton add = new JButton("ADD");
    JButton reset = new JButton("RESET");
    JButton clear = new JButton("CLEAR");

    int userNo = 1;
    ArrayList<String> registrations = new ArrayList<>(); 
    public frameSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(750, 500));
        this.pack();
        this.setResizable(false);

        mainPanel.setLayout(new BorderLayout());
        centPanel.setLayout(new GridLayout(9,2,10,10));
        centPanel.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
        botPanel.setLayout(new BorderLayout());
        btnPanel.setLayout(new GridLayout(1,3,15,15));
        radPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(mainLabel, BorderLayout.NORTH);
        mainPanel.add(centPanel, BorderLayout.CENTER);
        mainPanel.add(botPanel, BorderLayout.SOUTH);

        centPanel.add(new JLabel("NAME:"));
        centPanel.add(nameField);
        centPanel.add(new JLabel("BIRTHDAY (MM/DD/YYYY):"));
        centPanel.add(birthField);
        centPanel.add(new JLabel("MOBILE NO.:"));
        centPanel.add(mobField);
        centPanel.add(new JLabel("EMAIL ADDRESS:"));
        centPanel.add(emailField);
        centPanel.add(new JLabel("CONFIRM EMAIL:"));
        centPanel.add(emailConField);
        centPanel.add(new JLabel("PASSWORD:"));
        centPanel.add(passField);
        centPanel.add(new JLabel("CONFIRM PASSWORD:"));
        centPanel.add(passConField);
        centPanel.add(new JLabel("COURSE:"));
        centPanel.add(courses);
        centPanel.add(new JLabel("SEMESTER:"));
        centPanel.add(radPanel);

        radPanel.add(btnOne);
        radPanel.add(btnTwo);
        group.add(btnOne);
        group.add(btnTwo);

        courses.setSelectedIndex(-1);
        result.setPreferredSize(new Dimension(50,120));
        JScrollPane resultScroll = new JScrollPane(result);

        botPanel.add(resultScroll, BorderLayout.CENTER);
        botPanel.add(btnPanel, BorderLayout.SOUTH);

        btnPanel.add(add);
        btnPanel.add(reset);
        btnPanel.add(clear);

        add.addActionListener(this);
        clear.addActionListener(this);
        reset.addActionListener(this);
        this.add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == add){
            if(validateInputs()){
                String userDetail = getDetails();
                userNo++;
                result.append(userDetail+"\n");
            }
        } else if(e.getSource()== clear){
            result.setText("");
        } else if(e.getSource()== reset){
            nameField.setText("");
            mobField.setText("");
            birthField.setText("");
            emailField.setText("");
            emailConField.setText("");
            passField.setText("");
            passConField.setText("");
            courses.setSelectedIndex(-1);
            group.clearSelection();
        }
    }

    public Boolean validateInputs(){
        if (nameField.getText().isEmpty() || mobField.getText().isEmpty() || birthField.getText().isEmpty() || 
        emailField.getText().isEmpty() || new String(passField.getPassword()).isEmpty()||!(btnOne.isSelected() || 
        btnTwo.isSelected())||(courses.getSelectedItem() == null)){
                JOptionPane.showMessageDialog(null, "Missing Details. Please fill the form up!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
        } 
        if(!birthField.getText().trim().matches("(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}")){
            JOptionPane.showMessageDialog(null, "For your birthday, please follow MM/DD/YYYY using numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!mobField.getText().trim().matches("\\d{11}")){
            JOptionPane.showMessageDialog(null, "Only 11 digits Mobile Number.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;   
        }  else if (!(emailField.getText().trim().contains("@gmail.com")||emailField.getText().trim().contains("@yahoo.com"))){
            JOptionPane.showMessageDialog(null, "Please enter a valid email! (gmail.com/yahoo.com)", "Error", JOptionPane.ERROR_MESSAGE);
            return false;   
        }   

        if(!new String(passField.getPassword()).equals(new String(passConField.getPassword()))){
            JOptionPane.showMessageDialog(null, "Password Doesn't Match!", "Error", JOptionPane.ERROR_MESSAGE);
            return false; 
        } else if (!emailField.getText().trim().equals(emailConField.getText().trim())){
            JOptionPane.showMessageDialog(null, "Email Doesn't Match!", "Error", JOptionPane.ERROR_MESSAGE);
            return false; 
        }

        return true;
    }
    public String getDetails(){
        String name = nameField.getText().trim();
        String bday = birthField.getText().trim();
        String number = mobField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passField.getPassword()).trim();
        String course = (String) courses.getSelectedItem();
        String sem = (btnOne.isSelected() ? "1ST SEM" : "2ND SEM");
        return String.valueOf(userNo)+". Name: "+name+" Birthday: "+bday+" Password: "+password+" Course: "+course+" SEMESTER: "+sem+" " +number+" "+email;
    }
}
public class Main {
    public static void main(String[] args){
        new frameSetup();
    }
}
