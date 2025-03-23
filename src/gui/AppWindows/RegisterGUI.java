package gui.AppWindows;

import Database_Objects.JDBCConnection;
import gui.BaseWindow.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterGUI extends BaseFrame {
    public RegisterGUI() {
        super("Banking App Registration");
    }

    @Override
    protected void addGuiComponents() {

        //Creating headertext
        JLabel bankingAppLabel = new JLabel("Banking Application");
        bankingAppLabel.setBounds(0, 20, super.getWidth(), 40);
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingAppLabel);

        //Creating usenamelabel
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 120, super.getWidth() - 30, 24);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(usernameLabel);

        //Creating textfield for the username input
        JTextField usernameField = new JTextField();
        usernameField.setBounds(20, 160, super.getWidth() - 50, 40);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(usernameField);

        //Creating passwordLabel
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 220, super.getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        //Creating password textfield for the password input
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 260, super.getWidth() - 50, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(passwordField);

        //Re-enter password field
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(20, 320, super.getWidth() - 50, 40);
        confirmPasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(confirmPasswordLabel);

        //Creating "re-enter password" textfield for the password input
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(20, 360, super.getWidth() - 50, 40);
        confirmPasswordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(confirmPasswordField);


        //Creating button to register user
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 460, super.getWidth() - 50, 40);
        registerButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

                if (validateUserInput(username, password, confirmPassword)) {
                    //Attempt to register the user
                    if (JDBCConnection.register(username, password)) {
                        RegisterGUI.this.dispose();

                        LoginGUI loginGUI = new LoginGUI();
                        loginGUI.setVisible(true);

                        JOptionPane.showMessageDialog(loginGUI, "Account succesfully registered!");
                    } else {
                        JOptionPane.showMessageDialog(RegisterGUI.this, "Error: Username already in use");
                    }
                } else {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Error: Username must be at least 6 characters \n" +
                            "and passwords must match");
                }

            }
        });

        add(registerButton);

        //Creating login button incase the user already has an account
        JLabel loginLabel = new JLabel("<html> <a href=\"#\">Already have an account? Login here</a> </html>");
        loginLabel.setBounds(0, 510, super.getWidth() - 10, 30);
        loginLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterGUI.this.dispose();

                new LoginGUI().setVisible(true);
            }
        });
        add(loginLabel);
    }

    private boolean validateUserInput(String username, String password, String confirmPassword) {
        //None of the fields may be left empty
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) return false;

        //Username must be at least 6 characters long
        if (username.length() < 6) return false;

        //Password must match the confirmed password
        if (!password.equals(confirmPassword)) return false;

        //If none of the conditions above are met, user input is valid
        return true;

    }
}
