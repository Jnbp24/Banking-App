package Database_Objects;

import java.math.BigDecimal;
import java.sql.*;

public class JDBCConnection {
    private static final String DB_URL = "jdbc:sqlserver://DESKTOP-9TCQJA9\\SQLEXPRESS;databaseName=BankingApp;user=sa;password=zrz76kfv;";

    private static final String username = "root";
    private static final String password = "password";

    public static User validateLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, "username", "password");

            //Creating sql query
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "Select * From Users Where username = ? AND password = ?"
            );

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            //Returns true if dataretrieval was succesful
            //Returns false if dataretrieval was unsuccesful
            if (resultSet.next()) {
                int userID = resultSet.getInt("id");
                BigDecimal currentbalance = resultSet.getBigDecimal("current_balance");
                return new User(userID, username, password, currentbalance);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Failed");;
            e.printStackTrace();
        }
        //No data was retrieved
        return null;
    }
}
