package backdoor_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClass{    
    public Connection getConnection() throws ClassNotFoundException, SQLException{       
          Class.forName("com.mysql.jdbc.Driver");
          return DriverManager.getConnection("jdbc:mysql://sql5.freesqldatabase.com:3306/sql575408","sql575408","bQ9*gN2!");
    }
}
