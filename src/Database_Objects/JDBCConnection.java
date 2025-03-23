package Database_Objects;

import java.math.BigDecimal;
import java.sql.*;

public class JDBCConnection {
    private static final String DB_URL = "jdbc:sqlserver://DESKTOP-9TCQJA9\\SQLEXPRESS;database=BankingApp;username=sa;password=zrz76kfv;";


    public static User validateLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL,username,password);
            System.out.println("Connection OK");

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
                int userID = resultSet.getInt("user_id");
                BigDecimal currentbalance = resultSet.getBigDecimal("current_balance");
                return new User(userID, username, password, currentbalance);
            }

        } catch (SQLException e) {
            System.out.println("Failed");;
            e.printStackTrace();
        }
        //No data was retrieved
        return null;
    }


    //Registers new user to database
    public static boolean register(String username, String password){
        try{
            if(!checkUser(username)){
                Connection connection = DriverManager.getConnection(DB_URL);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "Insert into Users(username, password) " + "Values(?,?)"
                );

                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                preparedStatement.executeUpdate();
                //Returns true if user has been correctly registered
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //Returns false if username is already taken
        return false;
    }


    private static boolean checkUser(String username){
        try{
            Connection connection = DriverManager.getConnection(DB_URL);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "Select * From Users Where username = ?"
            );

            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Returns false, meaning the username is not already taken
            if(resultSet.next()){
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        //Returns true, meaning the username is already taken
        return true;
    }
}
