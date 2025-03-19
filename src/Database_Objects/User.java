package Database_Objects;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class User {
    private final int id;
    private final String userName;
    private final String password;
    private BigDecimal currentBalance;

    public User(int id, String userName, String password, BigDecimal currentBalance) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.currentBalance = currentBalance;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal newBalance) {
        //Stores new value in currentbalance
        //.setScale formats the bigDecimal to 2 decimal points
        //RoundingMode.Floor rounds the number down
        currentBalance = newBalance.setScale(2, RoundingMode.FLOOR);
    }
}
