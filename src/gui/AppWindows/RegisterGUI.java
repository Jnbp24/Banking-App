package gui.AppWindows;

import gui.BaseWindow.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class RegisterGUI extends BaseFrame {
    public RegisterGUI(){
        super("Banking App Registration");
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
        passwordLabel.setBounds(20,220,super.getWidth()-50,24);
        passwordLabel.setFont(new Font("Dialog",Font.PLAIN,20));
        add(passwordLabel);

        //Creating password textfield for the password input
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20,260,super.getWidth()-50,40);
        passwordField.setFont(new Font("Dialog",Font.PLAIN,28));
        add(passwordField);

        //Re-enter password field
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(20,320,super.getWidth()-50,40);
        confirmPasswordLabel.setFont(new Font("Dialog",Font.PLAIN,20));
        add(confirmPasswordLabel);

        //Creating "re-enter password" textfield for the password input
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(20,360,super.getWidth()-50,40);
        confirmPasswordField.setFont(new Font("Dialog",Font.PLAIN,28));
        add(confirmPasswordField);


        //Creating button to register user
        JButton loginButton = new JButton("Register");
        loginButton.setBounds(20,460,super.getWidth()-50,40);
        loginButton.setFont(new Font("Dialog",Font.PLAIN,20));
        add(loginButton);

        //Creating register button to create new user
        JLabel loginLabel = new JLabel("<html> <a href=\"#\">Already have an account? Login here</a> </html>");
        loginLabel.setBounds(0,510,super.getWidth()-10,30);
        loginLabel.setFont(new Font("Dialog",Font.PLAIN,20));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);
    }
}
