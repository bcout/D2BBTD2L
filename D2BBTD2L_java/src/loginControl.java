import java.sql.SQLException;

public class loginControl 
{
	private DataManager dm;
	private static Account a;
	private boolean loginSuccessful;
	
	public loginControl()
	{
		dm = MainMenu.getDataManager();
	}
	
	public boolean handleLogin(String username, String password) throws SQLException
	{
		try 
		{
			a = dm.getAccountFromLoginInfo(username, password);
		} 
		catch (SQLException e) 
		{
			throw e;
		}
		if (a == null)
		{
			loginSuccessful = false; //No user with that username found
		}
		else
		{
			loginSuccessful = true;
		}
		
		return loginSuccessful;
		
	}
	
	public static Account getAccount()
	{
		return a;
	}

}