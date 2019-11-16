
/**
 * 
 */

//import static CourseInfoObject.*;
//import static CourseOfferingInfoObject.*;
//import static notificationObject.*;
import java.sql.*;
import java.util.*;
/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Brennan Couturier
*/
public class DataManager {
	
	Connection connection = null;
	
	
	/**
	 * This is the DataManager constructor that forms a connection to the cs204301ateam2 database
	 * A potential place for update would be the fact that a connection is established every time 
	 * a data manager is created, which may not be necessary as we could have 1 general data manager 
	 * that we pass around references to. Hasn't been decided as of November 13, 2019
	 *  -  Brennan Couturier
	 */
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
		}
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Quiz quiz;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Assignment assignment;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private AssignmentSubmission assignmentSolution;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Notification notification;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private LockerItem locker;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private CourseInfo courseInfo;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private TA_Account account;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private TA_Account account2;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private TA_Account account3;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private TA_Account account4;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private ProfessorAccount professorAccount;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private StudentAccount userAccount;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private AdminAccount adminAccount;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private CourseRegistration courseRegistration;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private CourseOfferingInfo courseOfferingInfo;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Account account5;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private CourseOfferingInfo courseOfferingInfo2;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private AdminAccount adminAccount2;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private ProfessorAccount professorAccount2;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private TA_Account tA_Account;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private StudentAccount studentAccount;
	
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
			
			if(rs != null)
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
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
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
	
	public ArrayList<Message> requestMessages(int userId) throws SQLException 
	{
		//Declare the prepared statement
		PreparedStatement requestMessagesPs;
		
		//Initialize the message request query. Will select all the messages that have the user's id as the to_accountId value
		String requestMessagesQuery = "select * from Message where to_accountId = ?;";
		
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
			requestMessagesPs = connection.prepareStatement(requestMessagesQuery);
			
			//Put the user's id number into the query, so that only messages addressed to that user are retrieved
			requestMessagesPs.setInt(1, userId);
			
			//Execute the query to retrieve a set of SQL rows
			ResultSet rs = requestMessagesPs.executeQuery();
			
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
		
		if (requestMessagesPs != null)
		{
			try
			{
				requestMessagesPs.close();
			}
			catch (SQLException e)
			{
				throw e;
			}
		}
		
		return messages;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void handleCreateStudent() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void handleCreateTA() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void handleCreateProf() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void handleCreateAdmin() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void getNotifications() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void markNotificationsRead() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void getMarks() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void markFeedbackRead() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void addCourseInfo() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void addsAssingmentInfo() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void addMark() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void getLocker() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void getLockerItem() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void requestAssignmentFileassignmentId() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void getAssignmentSpecificationsassignmentId() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void uploadAssignmentSubmissionstudentIdfileassignmentId() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param offeringInfo
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void addCourseOfferingInfo(CourseOfferingInfoObject offeringInfo) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param notification
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void postNotification(notificationObject notification) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param courseId
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<CourseInfoObject> retrieveCourseInfo(int courseId) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param paths
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean uploadFilesToLocker(String... paths) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void createNewQuiz() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void postQuizResults() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void getQuiz() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void submitAnswers() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void getAvailableQuizzes() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void addCourseRegistrationInfoArrayListCourseRegistrationObject() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public double getTotalLockerSize() {
		// begin-user-code
		// TODO Auto-generated method stub
		return 0;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void checkLoginCredentials() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}