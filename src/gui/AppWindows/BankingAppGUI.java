package gui.AppWindows;


import Database_Objects.User;
import gui.BaseWindow.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class BankingAppGUI extends BaseFrame {
    private JTextField currentBalanceField;

    public BankingAppGUI(User user) {
        super("Banking App", user);
    }

    @Override
    protected void addGuiComponents() {
        //Creating welcome message

        String welcomeMessage = "<html>" +
                "<body style='text-align:center'>" +
                "<b> Hello " + user.getUserName() + "</b> <br>" +
                "What would you like to do? </body> </html>";
        JLabel welcomeMessageLabel = new JLabel(welcomeMessage);
        welcomeMessageLabel.setBounds(0, 20, super.getWidth() - 10, 40);
        welcomeMessageLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeMessageLabel);

        //Creating current balance label
        JLabel currentBalance = new JLabel("Current Balance: ");
        currentBalance.setBounds(0, 80, super.getWidth() - 10, 40);
        currentBalance.setFont(new Font("Dialog", Font.BOLD, 22));
        currentBalance.setHorizontalAlignment(SwingConstants.CENTER);
        add(currentBalance);

        //Creating current balance textfield
        currentBalanceField = new JTextField("$" + user.getCurrentBalance());
        currentBalanceField.setBounds(15, 120, super.getWidth() - 50, 40);
        currentBalanceField.setFont(new Font("Dialog", Font.BOLD, 28));
        currentBalanceField.setHorizontalAlignment(SwingConstants.RIGHT);
        //Setting the field to be false to prevent the user changing their balance
        currentBalanceField.setEditable(false);
        add(currentBalanceField);

        //Creating deposit button
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(15, 180, super.getWidth() - 50, 50);
        depositButton.setFont(new Font("Dialog", Font.BOLD, 22));
        depositButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(depositButton);

        //Creating withdraw button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(15, 250, super.getWidth() - 50, 50);
        withdrawButton.setFont(new Font("Dialog", Font.BOLD, 22));
        withdrawButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(withdrawButton);

        //Creating a past transaction button
        JButton pastTransactionButton = new JButton("Past transaction");
        pastTransactionButton.setBounds(15, 320 , super.getWidth() - 50, 50);
        pastTransactionButton.setFont(new Font("Dialog", Font.BOLD, 22));
        pastTransactionButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(pastTransactionButton);

        //Creating a transfer button
        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(15, 390 , super.getWidth() - 50, 50);
        transferButton.setFont(new Font("Dialog", Font.BOLD, 22));
        transferButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(transferButton);

        //Creating a logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(15, 500 , super.getWidth() - 50, 50);
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 22));
        logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(logoutButton);



    }


    private JTextField getCurrentBalanceField() {
        return currentBalanceField;
    }
}
