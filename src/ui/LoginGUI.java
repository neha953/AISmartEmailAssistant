package ui;

import javax.swing.*;
import service.AuthService;

public class LoginGUI extends JFrame {

    public LoginGUI(AuthService auth) {

        setTitle("Secure Login - AI Email Assistant");
        setSize(350, 220);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center screen

        // Labels
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 30, 100, 25);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 100, 25);

        // Fields
        JTextField userField = new JTextField();
        userField.setBounds(120, 30, 180, 25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 70, 180, 25);

        // Button
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(120, 120, 100, 30);

        // Add components
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginBtn);

        // LOGIN ACTION
        loginBtn.addActionListener(e -> {

            String user = userField.getText().trim();
            String pass = new String(passField.getPassword()).trim();

            // 🔐 Validation (IMPORTANT)
            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "⚠ Please fill all fields!");
                return;
            }

            // 🔐 Login check
            if (auth.login(user, pass)) {

                JOptionPane.showMessageDialog(this,
                        "✅ Login Successful!");

                dispose();

                // Open main app
                new EmailGUI();

            } else {
                JOptionPane.showMessageDialog(this,
                        "❌ Invalid Username or Password!");
            }
        });

        setVisible(true);
    }
}