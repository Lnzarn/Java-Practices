import java.awt.*;
import javax.swing.*;

class frameSetup extends JFrame{
    
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
    public frameSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(400, 500));
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

        result.setPreferredSize(new Dimension(80,70));

        botPanel.add(result, BorderLayout.CENTER);
        botPanel.add(btnPanel, BorderLayout.SOUTH);

        btnPanel.add(add);
        btnPanel.add(reset);
        btnPanel.add(clear);
        this.add(mainPanel);
        this.setVisible(true);
    }
}
public class Main {
    public static void main(String[] args){
        new frameSetup();
    }
}
