package pic;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnector 
{
	static Connection con;

	public static Connection doConnect()
	{
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/first","root","Naman@3246");
			System.out.println("Connected........");
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
		return con;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		doConnect();
	}
}
