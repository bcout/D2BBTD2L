public class MyDataManagerMethods
{
    @SuppressWarnings("deprecation")
	public DataManager()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
		String url = "jdbc:mysql://cs2043.cs.unb.ca:3306/cs204301ateam2";
		try
		{
			connection = DriverManager.getConnection(url, "cs204301ateam2", "Z34SRYfW");
		}
		catch (SQLException e)
		{
			System.err.println("Database connection error.");
			System.err.println(e.getMessage());
		}
	}

    public Account getAccountFromLoginInfo(String usernameIn, String passwordIn) throws SQLException
	{
		PreparedStatement getAccountFromUsernamePs;
		String getAccountFromUsernameQuery = "select * from Account where username = ? and password = sha1(?);";

		Account a = null;

		try
		{
			getAccountFromUsernamePs = connection.prepareStatement(getAccountFromUsernameQuery);
			getAccountFromUsernamePs.setString(1, usernameIn);
			getAccountFromUsernamePs.setString(2, passwordIn);
			ResultSet rs = getAccountFromUsernamePs.executeQuery();

			if (rs.next())
			{
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				int accountType = rs.getInt(4);
				String firstName = rs.getString(5);
				String lastName = rs.getString(6);

				a = new Account(id, username, password, accountType, firstName, lastName);
			}

		}

		catch (SQLException e)
		{
			throw e;
		}

		if (getAccountFromUsernamePs != null)
		{
			try
			{
				getAccountFromUsernamePs.close();
			}
			catch (SQLException e)
			{
				throw e;
			}
		}
		return a;
	}


	/**
	 *
	 * @param idIn
	 * @return
	 * @throws SQLException
	 */

	public Account getAccountFromId(int idIn) throws SQLException
	{
		PreparedStatement getAccountFromIdPs;
		String getAccountFromIdQuery = "select * from Account where accountId = ?;";

		Account a = null;

		try
		{
			getAccountFromIdPs = connection.prepareStatement(getAccountFromIdQuery);
			getAccountFromIdPs.setInt(1, idIn);
			ResultSet rs = getAccountFromIdPs.executeQuery();

			if (rs.next())
			{
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				int accountType = rs.getInt(4);
				String firstName = rs.getString(5);
				String lastName = rs.getString(6);

				a = new Account(id, username, password, accountType, firstName, lastName);
			}
		}
		catch (SQLException e)
		{
			throw e;
		}

		if (getAccountFromIdPs != null)
		{
			try
			{
				getAccountFromIdPs.close();
			}
			catch (SQLException e)
			{
				throw e;
			}
		}

		return a;
	}

    public ArrayList<Account> getAllAccounts() throws SQLException
	{
		PreparedStatement getAllAccountsPs;
		String getAllAccountsQuery = "select * from Account;";

		ArrayList<Account> accounts = new ArrayList<Account>();

		try
		{
			getAllAccountsPs = connection.prepareStatement(getAllAccountsQuery);

			ResultSet rs = getAllAccountsPs.executeQuery();

			while (rs.next())
			{
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				int accountType = rs.getInt(4);
				String firstName = rs.getString(5);
				String lastName = rs.getString(6);

				Account a = new Account(id, username, password, accountType, firstName, lastName);

				accounts.add(a);
			}
		}
		catch (SQLException e)
		{
			throw e;
		}

		if (getAllAccountsPs != null)
		{
			try
			{
				getAllAccountsPs.close();
			}
			catch (SQLException e)
			{
				throw e;
			}

		}

		return accounts;
	}

    public boolean accountExists(int accountId) throws SQLException
	{
		PreparedStatement checkAccountExistsPs;
		String checkAccountExistQuery = "select count(*) from Account where accountId = ?;";
		int rowNum = 0;
		int numAccounts = 0;

		try
		{
			checkAccountExistsPs = connection.prepareStatement(checkAccountExistQuery);
			checkAccountExistsPs.setInt(1, accountId);
			ResultSet rs = checkAccountExistsPs.executeQuery();

			if(rs.next())
			{
				rs.last();
				rowNum = rs.getRow();
				numAccounts = rs.getInt(rowNum);
			}

			if (numAccounts == 1)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			throw e;
		}

		if (checkAccountExistsPs != null)
		{
			try
			{
				checkAccountExistsPs.close();
			}
			catch(SQLException e)
			{
				throw e;
			}
		}

        return false;
	}

    /**
	 *
	 * @param courseNumber
	 * @param courseDescription
	 * @return
	 * @throws SQLException
	 */
	public boolean createCourse(String courseNumber, String courseDescription) throws SQLException
	{
		boolean success = false;

		PreparedStatement createCoursePs;
		String createCourseQuery = "insert into Course(courseNumber, courseDescription) values (?,?);";

		try
		{
			createCoursePs = connection.prepareStatement(createCourseQuery);
			createCoursePs.setString(1, courseNumber);
			createCoursePs.setString(2, courseDescription);

			int numRowsChanged = createCoursePs.executeUpdate();

			if (numRowsChanged == 1)
			{
				success = true;
			}
		}
		catch (SQLException e)
		{
			throw e;
		}

		if (createCoursePs != null)
		{
			try
			{
				createCoursePs.close();
			}
			catch (SQLException e)
			{
				throw e;
			}
		}

		return success;
	}


	/**
	 *
	 * @param messageText
	 * @param from_accountId
	 * @param to_accountId
	 * @return
	 * @throws SQLException
	 */
	public boolean handleMessageSubmit(String messageText, int from_accountId, int to_accountId) throws SQLException
	{

		boolean submitSuccessful = false;

		PreparedStatement submitMessagePs;

		String submitMessageQuery = "insert into Message (sentTimestamp, messageText, from_accountId, to_accountId) values (?, ?, ?, ?);";

		Timestamp timeSent = new Timestamp(System.currentTimeMillis());

		try
		{
			submitMessagePs = connection.prepareStatement(submitMessageQuery);
			submitMessagePs.setTimestamp(1, timeSent);
			submitMessagePs.setString(2, messageText);
			submitMessagePs.setInt(3, from_accountId);
			submitMessagePs.setInt(4, to_accountId);

			int numRowsChanged = submitMessagePs.executeUpdate();

			if (numRowsChanged == 1)
			{
				submitSuccessful = true;
			}
		}
		catch (SQLException e)
		{
			throw e;
		}

		if (submitMessagePs != null)
		{
			try
			{
				submitMessagePs.close();
			}
			catch (SQLException e)
			{
				throw e;
			}
		}

		return submitSuccessful;
	}

	/**
	 * This method retrieves from the database all the messages that have a passed user's id as the recipient's id
	 * @throws SQLException
	 * @param userId The id of the user whose messages will be retrieved
	 */

	public ArrayList<Message> requestMessagesReceived(int userId) throws SQLException
	{
		//Declare the prepared statement
		PreparedStatement requestMessagesReceivedPs;

		//Initialize the message request query. Will select all the messages that have the user's id as the to_accountId value
		String requestMessagesReceivedQuery = "select * from Message where to_accountId = ?;";

		//Create a list of all messages
		ArrayList<Message> messages = new ArrayList<Message>();

		//Declare message variables
		int messageId;
		Timestamp timeSent;
		String messageText;
		int from_accountId;
		int to_accountId;

		try
		{
			//Prepare the message request query
			requestMessagesReceivedPs = connection.prepareStatement(requestMessagesReceivedQuery);

			//Put the user's id number into the query, so that only messages addressed to that user are retrieved
			requestMessagesReceivedPs.setInt(1, userId);

			//Execute the query to retrieve a set of SQL rows
			ResultSet rs = requestMessagesReceivedPs.executeQuery();

			//If there are any message rows retrieved, create message objects out of them then add them to a linked list
			//If there are no message rows retrieved, return an empty list
			while (rs.next())
			{
				messageId = rs.getInt(1);
				timeSent = rs.getTimestamp(2);
				messageText = rs.getString(3);
				from_accountId = rs.getInt(4);
				to_accountId = rs.getInt(5);

				Message m = new Message(messageId, timeSent, messageText, from_accountId, to_accountId);

				messages.add(m);
			}
		}
		catch (SQLException e)
		{
			throw e;
		}

		if (requestMessagesReceivedPs != null)
		{
			try
			{
				requestMessagesReceivedPs.close();
			}
			catch (SQLException e)
			{
				throw e;
			}
		}

		return messages;
	}

	/**
	 *
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Message> requestMessagesSent(int userId) throws SQLException
	{
		PreparedStatement requestMessagesSentPs;

		String requestMessagesSentQuery = "select * from Message where from_accountId = ?;";

		ArrayList<Message> messages = new ArrayList<Message>();

		//Declare message variables
		int messageId;
		Timestamp timeSent;
		String messageText;
		int from_accountId;
		int to_accountId;

		try
		{
			//Prepare the message request query
			requestMessagesSentPs = connection.prepareStatement(requestMessagesSentQuery);

			//Put the user's id number into the query, so that only messages addressed to that user are retrieved
			requestMessagesSentPs.setInt(1, userId);

			//Execute the query to retrieve a set of SQL rows
			ResultSet rs = requestMessagesSentPs.executeQuery();

			//If there are any message rows retrieved, create message objects out of them then add them to a linked list
			//If there are no message rows retrieved, return an empty list
			while (rs.next())
			{
				messageId = rs.getInt(1);
				timeSent = rs.getTimestamp(2);
				messageText = rs.getString(3);
				from_accountId = rs.getInt(4);
				to_accountId = rs.getInt(5);

				Message m = new Message(messageId, timeSent, messageText, from_accountId, to_accountId);

				messages.add(m);
			}
		}
		catch (SQLException e)
		{
			throw e;
		}

		if (requestMessagesSentPs != null)
		{
			try
			{
				requestMessagesSentPs.close();
			}
			catch (SQLException e)
			{
				throw e;
			}
		}

		return messages;
	}
}
