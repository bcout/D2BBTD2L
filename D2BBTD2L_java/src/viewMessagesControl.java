import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class handles all the interaction between the datamanager and the view messages UI.
 * @author Brennan Couturier, 3638808
 *
 */
public class viewMessagesControl
{

	private DataManager dm;

	public viewMessagesControl()
	{
		dm = MainMenu.getDataManager();
	}


	public Message[] getMessagesReceived(int userId)
	{
		ArrayList<Message> messages = new ArrayList<Message>();
		try
		{
			messages = dm.requestMessagesReceived(userId);
		}
		catch (SQLException e)
		{
			
		}

		return messages.toArray(new Message[0]);
	}

	public Message[] getMessagesSent(int userId) 
	{
		ArrayList<Message> messages = new ArrayList<Message>();
		try
		{
			messages = dm.requestMessagesSent(userId);
		}
		catch (SQLException e)
		{
			
		}

		return messages.toArray(new Message[0]);
	}
}
