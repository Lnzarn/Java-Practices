import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class frameSetup extends JFrame implements ActionListener {
    
    JPanel mainPanel = new JPanel();
    JPanel userPanel = new JPanel();
    
    JPanel passPanel = new JPanel();

    JLabel username = new JLabel("Username:");
    JLabel password = new JLabel("Password:");
    JTextField userField = new JTextField(20);
    JPasswordField passField = new JPasswordField(20);

    JButton edit = new JButton("Edit");
    JButton submit = new JButton("Submit");

    String userName;
    String passWord;
    String orient;
    public frameSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(400,200));
        this.pack();
        this.setResizable(false);
        this.setTitle("Login");
        
        mainPanel.setLayout(new GridLayout(4, 2, 5, 5));
        userPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        passPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setVerticalAlignment(SwingConstants.TOP);
        password.setHorizontalAlignment(SwingConstants.CENTER);
        password.setVerticalAlignment(SwingConstants.TOP);
        userPanel.add(userField);
        passPanel.add(passField);

        submit.setPreferredSize(new Dimension(20,50));
        mainPanel.add(username);
        mainPanel.add(userPanel);
        mainPanel.add(password);
        mainPanel.add(passPanel);
        mainPanel.add(edit);
        mainPanel.add(submit);

        edit.addActionListener(this);
        submit.addActionListener(this);
        this.add(mainPanel);
        this.setVisible(true);
    }

    @Override

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==edit){
            edit();
        } else if(e.getSource() == submit){
            submit();
        }
    }

    private void edit(){
        JPanel panel = new JPanel(new GridLayout(3,2,5,5));
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JTextField userField = new JTextField(20);
        JPasswordField passField = new JPasswordField(20);
        JRadioButton male = new JRadioButton("Male");
        male.setActionCommand("Male");
        JRadioButton female = new JRadioButton("Female");
        female.setActionCommand("Female");
        male.setSelected(true);
        ButtonGroup orientation = new ButtonGroup();
        orientation.add(male);
        orientation.add(female); 
        panel.add(username);
        panel.add(userField);
        panel.add(password);
        panel.add(passField);
        panel.add(male);
        panel.add(female);

        int r = JOptionPane.showConfirmDialog(this, panel, "Create", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (r == JOptionPane.OK_OPTION){
            userName = userField.getText().trim();
            passWord = new String(passField.getPassword()).trim();
            ButtonModel temp = orientation.getSelection();
            orient = temp.getActionCommand();
        }
    }

    private void submit(){
        if(userName == null){
                JOptionPane.showMessageDialog(null, "There is no account yet.");
        } else {
            if(userName.equals(userField.getText()) && passWord.equals(new String(passField.getPassword()))){
                JOptionPane.showMessageDialog(null, "That is Correct! And you are a " + orient);
            } else JOptionPane.showMessageDialog(null, "That is Wrong!");
        }
    }
}

public class Main {
    public static void main(String[] args){
        new frameSetup();
    }
}
