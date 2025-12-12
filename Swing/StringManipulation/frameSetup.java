import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class frameSetup extends JFrame implements ChangeListener, ActionListener{
    JPanel panelText;
    JPanel panelAttri;
    JPanel panelMani;
    JTextField textBox;

    JSlider sizeSlider;
    JRadioButton regStyle;
    JRadioButton boldStyle;
    JRadioButton italicStyle;
    JComboBox textColor;
    JComboBox textFont;
    ButtonGroup groupBold;

    String[] colorsArr = {"Black", "Blue", "Red", "Green", "Cyan", "Gray", "Magenta", "Orange", "Yellow"};
    String[] fontsArr = {"Dialog","Serif", "Monospaced", "Comic Sans MS", "Courier New", "Times New Roman", "Verdana", "Georgia", "SansSerif", "MV Boli"};

    frameSetup() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(700, 400));
        this.pack();
        this.setResizable(false);
        this.setTitle("String Manipulator");
        this.setLayout(null);

        panelText = new JPanel();
        panelAttri = new JPanel();
        panelMani = new JPanel();

        // --------------- STRING INPUT ---------------------
        panelText.setBackground(new Color(230, 225, 225));
        panelText.setBounds(0, 0, 700, 134);
        panelText.setLayout(null);


        textBox = new JTextField("Enter Your String", 20);
        textBox.setBounds(25, 28, 650, 70);
        panelText.add(textBox);

        // --------------- STRING ATTRIBUTES ---------------------
        panelAttri.setBackground(new Color(230, 225, 225));
        panelAttri.setBounds(0, 134, 700, 133);
        panelAttri.setLayout(null);

        // Setting up the text for labeling certain parts
        JLabel attriText = new JLabel("Text Attributes");
        attriText.setBounds(308, 0, 120, 20);
        JLabel sizeText = new JLabel("Text Size: ");
        sizeText.setFont(new Font("Dialog", Font.PLAIN, 10));
        sizeText.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel styleText = new JLabel("Style: ");
        styleText.setFont(new Font("Dialog", Font.PLAIN, 10));

        // Setting up the Panels for the Text Attributes
        JPanel sizePanel = new JPanel();
        sizePanel.setBackground(new Color(230, 225, 225));
        sizePanel.setBounds(25, 30, 650, 45);
        JPanel boldPanel = new JPanel();
        boldPanel.setBackground(new Color(230, 225, 225));
        boldPanel.setBounds(295,85,380,40);
        boldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 10));
        JPanel colorFontPanel = new JPanel();
        colorFontPanel.setBackground(new Color(230, 225, 225));
        colorFontPanel.setBounds(25,80,250,40);
        colorFontPanel.setLayout(new GridLayout(2, 2, 20,2));

     
        // Sliders for the Text Size
        sizeSlider = new JSlider(0, 80, 20);
        sizeSlider.setPreferredSize(new Dimension(530, 40));
        sizeSlider.setPaintTicks(true);
        sizeSlider.setMinorTickSpacing(10);
        sizeSlider.setPaintTrack(true);
        sizeSlider.setMajorTickSpacing(20);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setFont(new Font("Dialog", Font.PLAIN, 9));
        sizeSlider.setBackground(new Color(230, 225, 225));

       
        // Radiobuttons for Text Style
        groupBold = new ButtonGroup();

        regStyle = new JRadioButton("Regular");
        regStyle.setFont(new Font("Dialog", Font.PLAIN, 10));
        regStyle.setActionCommand("PLAIN");
        regStyle.setBackground(new Color(230, 225, 225));

        boldStyle = new JRadioButton("Bold");
        boldStyle.setFont(new Font("Dialog", Font.BOLD, 10));
        boldStyle.setActionCommand("BOLD");
        boldStyle.setBackground(new Color(230, 225, 225));

        italicStyle = new JRadioButton("Italized");
        italicStyle.setFont(new Font("Dialog", Font.ITALIC, 10));
        italicStyle.setActionCommand("ITALIC");
        italicStyle.setBackground(new Color(230, 225, 225));

        regStyle.setSelected(true);
        
        // Another text, this labels the combo box
        JLabel colorText = new JLabel("Text Color:");
        colorText.setFont(new Font("Dialog", Font.PLAIN, 10));
        JLabel fontText = new JLabel("Text Font:");
        fontText.setFont(new Font("Dialog", Font.PLAIN, 10));

        // Combo Boxes for color and font
        textColor = new JComboBox(colorsArr);
        textColor.setFont(new Font("Dialog", Font.PLAIN, 10));
        textFont = new JComboBox(fontsArr);
        textFont.setFont(new Font("Dialog", Font.PLAIN, 10));

        // Adding
        groupBold.add(regStyle);
        groupBold.add(boldStyle);
        groupBold.add(italicStyle);

        sizePanel.add(sizeText);
        sizePanel.add(sizeSlider);
        boldPanel.add(styleText);
        boldPanel.add(regStyle);
        boldPanel.add(boldStyle);
        boldPanel.add(italicStyle);
        colorFontPanel.add(colorText);
        colorFontPanel.add(fontText);
        colorFontPanel.add(textColor);
        colorFontPanel.add(textFont);

        panelAttri.add(attriText);
        panelAttri.add(sizePanel);
        panelAttri.add(boldPanel);
        panelAttri.add(colorFontPanel);

        // Event Listeners

        sizeSlider.addChangeListener(this);
        regStyle.addActionListener(this);
        boldStyle.addActionListener(this);
        italicStyle.addActionListener(this);
        textColor.addActionListener(this);
        textFont.addActionListener(this);

        // --------------- STRING INPUT ---------------------
        panelMani.setBackground(new Color(230, 225, 225));
        panelMani.setBounds(0, 267, 700, 133);


        this.add(panelText);
        this.add(panelAttri);
        this.add(panelMani);
        this.setVisible(true);
    }

    public int getSelectedButtonStyle(ButtonGroup bG){
        ButtonModel selectedModel = bG.getSelection();
         if (selectedModel != null) {
            String command = selectedModel.getActionCommand();
            return switch (command) {
                case "PLAIN" -> Font.PLAIN;
                case "BOLD" -> Font.BOLD;
                case "ITALIC" -> Font.ITALIC;
                default -> Font.PLAIN;
            };
        } else {
            return Font.PLAIN;
        }
    } 

    @Override
    public void stateChanged(ChangeEvent e){
        updateTextBox();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        updateTextBox();
    }

    private void updateTextBox() {
        String selectedFont = (String) textFont.getSelectedItem();
        int selectedStyle = getSelectedButtonStyle(groupBold);
        int selectedSize = sizeSlider.getValue();

        textBox.setFont(new Font(selectedFont, selectedStyle, selectedSize));
    
        // Update color
        String selectedColor = (String) textColor.getSelectedItem();
        switch(selectedColor) {
            case "Black":
                textBox.setForeground(Color.BLACK);
                break;
            case "Blue":
                textBox.setForeground(Color.BLUE);
                break;
            case "Red":
                textBox.setForeground(Color.RED);
                break;
            case "Green":
                textBox.setForeground(Color.GREEN);
                break;
             case "Cyan":
                textBox.setForeground(Color.CYAN);
                break;
            case "Gray":
                textBox.setForeground(Color.GRAY);
                break;
            case "Magenta":
                textBox.setForeground(Color.MAGENTA);
                break;
            case "Orange":
                textBox.setForeground(Color.ORANGE);
                break;
            case "Yellow":
                textBox.setForeground(Color.YELLOW);
                break;
        }
    }
}
