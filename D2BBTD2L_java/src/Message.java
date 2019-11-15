/**
 * 
 */

import java.sql.Timestamp;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author bcouturi
 */
public class Message 
{
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	*/
	private int messageId;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	*/
	private String messageText;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	*/
	private int from_accountId;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	*/
	private int to_accountId;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Account account;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	*/
	private Account account2;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	*/
	private Timestamp timeSent;
	
	/**
	 * This constructor is to be used when retrieving messages from the database, when all values are known
	 * @param messageId The id number of the message
	 * @param timeSent The time the message was stored in the database
	 * @param messageText The textual aspect of the message
	 * @param from_accountId The id of the user sending the message
	 * @param to_accountId The id of the user receiving the message
	 */
	public Message(int messageId, Timestamp timeSent, String messageText, int from_accountId, int to_accountId)
	{
		this.messageId = messageId;
		this.timeSent = timeSent;
		this.messageText = messageText;
		this.from_accountId = from_accountId;
		this.to_accountId = to_accountId;
	}
	
	/**
	 * This sets the message text
	 * @param text The text that the message will contain
	 */
	public void setMessageText(String text)
	{
		messageText = text;
	}
	
	/**
	 * This sets the id of the user the message is from
	 * @param fromId The id of the user the message is from
	 */
	public void setFromAccountId(int fromId)
	{
		from_accountId = fromId;
	}
	
	/**
	 * This sets the id of the user the message is being sent to
	 * @param ToId The id of the user the message is being sent to
	 */
	public void setToAccountId(int ToId)
	{
		to_accountId = ToId;
	}
	
	/**
	 * This sets the time that the message was sent (stored in the database)
	 * @param timeSent The time the message was stored in the database
	 */
	public void setTimeSent(Timestamp timeSent)
	{
		timeSent = timeSent;
	}
	
	public int getMessageId()
	{
		return messageId;
	}
	
	public String getMessageText()
	{
		return messageText;
	}
	
	public int getFromAccountId()
	{
		return from_accountId;
	}
	
	public int getToAccountId()
	{
		return to_accountId;
	}
	
	public Timestamp getTimeSent()
	{
		return timeSent;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void SQLInsertMessage() 
	{
		// begin-user-code
		// TODO Auto-generated method stub
		
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void SQLGetMessages() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}