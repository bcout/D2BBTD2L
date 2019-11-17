import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;

import javafx.scene.control.Button;

/**
 * This class handles all of the GUI aspects of the viewMessages use case
 * @author Brennan Couturier, 3638808
 *
 */
public class viewMessagesUI {
	
	
	
	//Non-javafx variables
	//-------------------------------------------------------------------------------
	
	private viewMessagesControl vmc;
	
	//-------------------------------------------------------------------------------
	
	//Javafx variables
	//-------------------------------------------------------------------------------
	/**
	 * This button will display all of the messages the current user has sent
	 */
	private Button btnSentItems;
	
	/**
	 * This button will display all of the messages the current user has recieved
	 */
	private Button btnRecievedItems;
	
	//-------------------------------------------------------------------------------
	
	public viewMessagesUI()
	{
		vmc = new viewMessagesControl();
	}
	
	private void initViewMessagesComponents()
	{
		btnSentItems = new Button("Sent Items");
		btnSentItems.setOnAction(this::processSentItemsButtonPress);
		
		btnRecievedItems = new Button("Inbox");
		btnRecievedItems.setOnAction(this::processRecievedItemsButtonPress);
	}

	public void initViewMessagesScene()
	{
		initViewMessagesComponents();
		
	}
	
	public void displayMessages(int userId) {
		// begin-user-code
		// TODO Auto-generated method stub
		ArrayList<Message> messages = new ArrayList<Message>();
		
		try
		{
			messages = vmc.getMessages(userId);
		}
		catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		
		if (messages.isEmpty())
		{
			System.out.println("No messages");
		}
		else
		{
			System.out.println("Messages");
			for (int i = 0; i < messages.size(); i++)
			{
				int messageId = messages.get(i).getMessageId();
				System.out.println(i + ": " + messageId);
			}
		}
	}
	
	private void processSentItemsButtonPress(ActionEvent event)
	{
		
	}
	
	private void processRecievedItemsButtonPress(ActionEvent event)
	{
		
	}
}