import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Penguin implements ActionListener {

    JLabel label;
    JButton button;

    public Penguin() {

       
        label = new JLabel();
        button = new JButton();

    
        ImageIcon penguinIcon = new ImageIcon("penguin.jpg");
        Image scaledImg = penguinIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);


        label.setText("Hello, I am Peng!");
        label.setForeground(new Color(111, 156, 222));
        label.setIcon(scaledIcon);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setFont(new Font("MV Boli", Font.PLAIN, 40));
        label.setIconTextGap(-25);
        label.setBounds(0, 0, 450, 450);

      
        button.setBounds(105, 450, 200, 50);
        button.addActionListener(this);  
        button.setText("I Love You!");
        button.setFocusable(false);

   
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Testing");
        frame.setSize(430, 600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);

       
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            label.setText("I Love You Too!");
        }
    }

    public static void main(String[] args) {
        new Penguin();  // launch the GUI
    }
}
