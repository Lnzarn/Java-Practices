import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

class UserEntry {
    String entryUsername;
    String entryPassword;
    String email;
    String platform;
    Boolean isLocked;

    public UserEntry(String username, String password, String email, String platform) {
        this.entryUsername = username;
        this.entryPassword = password;
        this.email = email;
        this.platform = platform;
        this.isLocked = false;
    }

    public String getEntryUsername() {
        return this.entryUsername;
    }

    public String getEntryPassword() {
        return this.entryPassword;
    }
    
    public String getEmail() {
        return this.email;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setEntryPassword(String newPassword) {
        this.entryPassword = newPassword;
    }
}

class frameSetup extends JFrame implements ActionListener {
    // ----- Content Sizing -----
    Insets insets = this.getInsets();
    int titleBarH = insets.top;
    int frameSizeW = 700;
    int frameSizeH = 434 + titleBarH;

    // ----- Panels Setup -----
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    JPanel sidePanel = new JPanel();
    JPanel midPanel = new JPanel();
    JScrollPane scrollPane;

    // ---- header setup -----
    JPanel header_l = new JPanel();
    JLabel username = new JLabel();
    JPanel header_c = new JPanel();
    JLabel titleHeader = new JLabel();
    JPanel header_r = new JPanel();
    JLabel time = new JLabel();

    // ---- side panel setup -----
    JButton createEntryBtn = new JButton("Create");
    JButton deleteEntryBtn = new JButton("Delete");
    JButton sortBtn = new JButton("Sort");
    JButton searchBtn = new JButton("Search");

    java.util.List<UserEntry> userEntries = new ArrayList<>();
    java.util.Map<UserEntry, JPanel> entryPanelMap = new HashMap<>();

    public frameSetup() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(frameSizeW, frameSizeH));
        this.pack();
        this.setResizable(false);
        this.setTitle("PasswordTracker");

        // main panel configurations -----
        mainPanel.setLayout(new BorderLayout(8, 8));
        mainPanel.setBackground(new Color(230, 230, 230));

        // header ------
        headerPanel.setLayout(new GridLayout(1, 3));
        headerPanel.setBackground(new Color(217, 217, 217));
        headerPanel.setPreferredSize(new Dimension(700, 56));
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        username.setText("Username: Admin");
        username.setVerticalAlignment(SwingConstants.CENTER);
        username.setHorizontalAlignment(SwingConstants.LEFT);
        header_l.setBackground(new Color(217, 217, 217));
        header_l.setLayout(new BorderLayout());
        header_l.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
        header_l.add(username, BorderLayout.CENTER);

        titleHeader.setText("Password Tracker");
        titleHeader.setFont(new Font("Dialog", Font.BOLD, 15));
        titleHeader.setHorizontalAlignment(SwingConstants.CENTER);
        header_c.setBackground(new Color(217, 217, 217));
        header_c.setLayout(new BorderLayout());
        header_c.add(titleHeader, BorderLayout.CENTER);

        // Update time with actual current time
        updateTime();
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> updateTime());
        timer.start();
        
        time.setHorizontalAlignment(SwingConstants.RIGHT);
        time.setVerticalAlignment(SwingConstants.CENTER);
        header_r.setBackground(new Color(217, 217, 217));
        header_r.setLayout(new BorderLayout());
        header_r.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        header_r.add(time, BorderLayout.CENTER);

        headerPanel.add(header_l);
        headerPanel.add(header_c);
        headerPanel.add(header_r);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // ---- side panel -----
        sidePanel.setLayout(new FlowLayout());
        sidePanel.setBackground(new Color(217, 217, 217));
        sidePanel.setPreferredSize(new Dimension(128, 377));
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        createEntryBtn.setPreferredSize(new Dimension(105, 40));
        createEntryBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        createEntryBtn.addActionListener(this);

        deleteEntryBtn.setPreferredSize(new Dimension(105, 40));
        deleteEntryBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        deleteEntryBtn.addActionListener(this);

        sortBtn.setPreferredSize(new Dimension(105, 40));
        sortBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        searchBtn.setPreferredSize(new Dimension(105, 40));
        searchBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        sidePanel.add(createEntryBtn);
        sidePanel.add(deleteEntryBtn);
        sidePanel.add(sortBtn);
        sidePanel.add(searchBtn);

        mainPanel.add(sidePanel, BorderLayout.WEST);

        // --- mid panel (where the entries are) -----
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        midPanel.setBackground(new Color(255, 255, 255));
        
        // Add scroll pane for entries
        scrollPane = new JScrollPane(midPanel);
        scrollPane.setPreferredSize(new Dimension(576, 370));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        time.setText(sdf.format(new Date()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createEntryBtn) {
            createEntryDialog();
        } else if (e.getSource() == deleteEntryBtn) {
            deleteEntryDialog();
        }
    }

    private void createEntryDialog() {
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JTextField emailField = new JTextField(20);
        JTextField platformField = new JTextField(20);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Platform:"));
        panel.add(platformField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Create New Entry",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String email = emailField.getText().trim();
            String platform = platformField.getText().trim();

            if (username.isEmpty() || password.isEmpty() || email.isEmpty() || platform.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            UserEntry entry = new UserEntry(username, password, email, platform);
            userEntries.add(entry);
            addEntryPanel(entry);
        }
    }

    private void deleteEntryDialog() {
        if (userEntries.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No entries to delete!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String input = JOptionPane.showInputDialog(this, 
            "Enter entry position to delete (1-" + userEntries.size() + "):", 
            "Delete Entry", 
            JOptionPane.QUESTION_MESSAGE);

        if (input != null && !input.trim().isEmpty()) {
            try {
                int position = Integer.parseInt(input.trim());
                if (position < 1 || position > userEntries.size()) {
                    JOptionPane.showMessageDialog(this, 
                        "Invalid position! Must be between 1 and " + userEntries.size(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                UserEntry entryToRemove = userEntries.get(position - 1);
                JPanel panelToRemove = entryPanelMap.get(entryToRemove);
                
                userEntries.remove(position - 1);
                entryPanelMap.remove(entryToRemove);
                midPanel.remove(panelToRemove);
                
                midPanel.revalidate();
                midPanel.repaint();
                
                JOptionPane.showMessageDialog(this, "Entry deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addEntryPanel(UserEntry entry) {
        JPanel entryPanel = new JPanel(new BorderLayout());
        entryPanel.setBackground(new Color(244, 244, 244));
        entryPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 38)));
        entryPanel.setMaximumSize(new Dimension(564, 80));
        entryPanel.setPreferredSize(new Dimension(564, 80));

        JPanel infoBoxPanel = new JPanel(new GridBagLayout());
        infoBoxPanel.setBackground(new Color(244, 244, 244));
        infoBoxPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 2, 5);

        JLabel usernameLabel = new JLabel("Username: " + entry.getEntryUsername());
        usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        infoBoxPanel.add(usernameLabel, gbc);

        JLabel passwordLabel = new JLabel("Password: " + entry.getEntryPassword());
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        infoBoxPanel.add(passwordLabel, gbc);

        JLabel emailLabel = new JLabel("Email: " + entry.getEmail());
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        infoBoxPanel.add(emailLabel, gbc);

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBackground(new Color(244, 244, 244));

        JLabel platformLabel = new JLabel("Platform: " + entry.getPlatform());
        platformLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(244, 244, 244));
        
        JButton editBtn = new JButton("Edit");
        JButton lockBtn = new JButton("Lock");

        editBtn.addActionListener(e -> {
            if (!entry.isLocked) {
                String newPassword = JOptionPane.showInputDialog(this, "Edit Password:", entry.getEntryPassword());
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    entry.setEntryPassword(newPassword.trim());
                    passwordLabel.setText("Password: " + (entry.isLocked ? "********" : entry.getEntryPassword()));
                }
            }
        });

        lockBtn.addActionListener(e -> {
            if (entry.isLocked) {
                entry.isLocked = false;
                lockBtn.setText("Lock");
                editBtn.setEnabled(true);
                passwordLabel.setText("Password: " + entry.getEntryPassword());
            } else {
                entry.isLocked = true;
                lockBtn.setText("Unlock");
                editBtn.setEnabled(false);
                passwordLabel.setText("Password: ********");
            }
        });

        buttonPanel.add(editBtn);
        buttonPanel.add(lockBtn);

        infoPanel.add(platformLabel, BorderLayout.CENTER);
        infoPanel.add(buttonPanel, BorderLayout.EAST);

        entryPanel.add(infoBoxPanel, BorderLayout.CENTER);
        entryPanel.add(infoPanel, BorderLayout.SOUTH);

        entryPanelMap.put(entry, entryPanel);
        midPanel.add(entryPanel);
        midPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        
        midPanel.revalidate();
        midPanel.repaint();
    }
}

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new frameSetup();
        });
    }
}