package backdoor_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClass{    
    public Connection getConnection() throws ClassNotFoundException, SQLException{       
          Class.forName("com.mysql.jdbc.Driver");
          return DriverManager.getConnection("jdbc:mysql://192.168.1.81/emanon","root","");
    }
}
