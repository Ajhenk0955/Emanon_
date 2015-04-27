package backdoor_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class TESTING{

	public static void main(String[] arg) throws Exception{
		String text = "123-45-6789";
		String end = text.replace("-","");
		System.out.println(Integer.parseInt(end));
		}
	}