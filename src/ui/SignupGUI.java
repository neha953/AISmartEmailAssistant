package ui;

import javax.swing.*;
import service.AuthService;

public class SignupGUI extends JFrame {

    public SignupGUI(AuthService auth) {

        setTitle("Sign Up");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField userField = new JTextField();
        userField.setBounds(100, 20, 150, 25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 60, 150, 25);

        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(100, 100, 100, 30);

        add(new JLabel("Username")).setBounds(20, 20, 80, 25);
        add(userField);

        add(new JLabel("Password")).setBounds(20, 60, 80, 25);
        add(passField);

        add(signupBtn);

        signupBtn.addActionListener(e -> {

            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (auth.register(user, pass)) {

                JOptionPane.showMessageDialog(this, "Account Created!");

                dispose();
                new LoginGUI(auth);

            } else {
                JOptionPane.showMessageDialog(this, "User already exists!");
            }
        });

        setVisible(true);
    }
}