import Database_Objects.User;
import gui.AppWindows.BankingAppGUI;
import gui.AppWindows.LoginGUI;

import javax.swing.*;
import java.math.BigDecimal;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
                //new RegisterGUI().setVisible(true);
                //new BankingAppGUI(new User(1, "username","password", new BigDecimal("20.00"))).setVisible(true);
            }
        });
    }

}


