package gui.AppWindows;

import gui.BaseWindow.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends BaseFrame {

    public LoginGUI() {
        super("Banking App Login");
    }

    @Override
    protected void addGuiComponents() {

        //Creating headertext
        JLabel bankingAppLabel = new JLabel("Banking Application");
        bankingAppLabel.setBounds(0,20,super.getWidth(),40);
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD,32));
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingAppLabel);

        //Creating usenamelabel
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20,120,super.getWidth()-30,24);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(usernameLabel);

        //Creating textfield for the username input
        JTextField usernameField =new JTextField();
        usernameField.setBounds(20,160,super.getWidth()-50,40);
        usernameField.setFont(new Font("Dialog",Font.PLAIN,28));
        add(usernameField);

        //Creating passwordLabel
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20,280,super.getWidth()-50,24);
        passwordLabel.setFont(new Font("Dialog",Font.PLAIN,20));
        add(passwordLabel);

        //Creating password textfield for the password input
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20,320,super.getWidth()-50,40);
        passwordField.setFont(new Font("Dialog",Font.PLAIN,28));
        add(passwordField);

        //Creating button to confirm login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20,460,super.getWidth()-50,40);
        loginButton.setFont(new Font("Dialog",Font.PLAIN,20));
        add(loginButton);

        //Creating register button to create new user
        JLabel registerLabel = new JLabel("<html> <a href=\"#\">Don't have an account? Register here</a> </html>");
        registerLabel.setBounds(0,510,super.getWidth()-10,30);
        registerLabel.setFont(new Font("Dialog",Font.PLAIN,20));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);

    }
}
