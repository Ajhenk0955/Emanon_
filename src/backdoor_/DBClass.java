package backdoor_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClass{    
    public Connection getConnection() throws ClassNotFoundException, SQLException{       
          Class.forName("com.mysql.jdbc.Driver");
          return DriverManager.getConnection("jdbc:mysql://localhost/emanon","root","");
    }
}
