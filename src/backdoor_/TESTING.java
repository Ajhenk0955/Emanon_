package backdoor_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class TESTING{

	public static void main(String[] arg) throws Exception{
		//main class
		
		Class.forName("com.mysql.jdbc.Driver");
		//load the jdbc driver class
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/emanon","root","");/* red colored part has to be as per your database*/
		/*make connection with the database(db name ecommerce, user is root and password is not set in my case put yours in those places with password if you have set password for the database*/
		PreparedStatement statement = con.prepareStatement("SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
				+ " FROM `patient`"
				+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
				+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
				+ " WHERE Service = 'Test'");
		/*sql structure to select instances from the table*/
		ResultSet result = statement.executeQuery();
		/*execution of the database query*/ 
		
		while(result.next()){
			System.out.println(result.getString(1) +"\t"+ result.getString(2) +"\t" + result.getString(3));
			/*print the result with three attributes from the table 'products in my case' */
			}
		}
	}