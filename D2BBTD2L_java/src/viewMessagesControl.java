import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author bcouturi
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class viewMessagesControl {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private DataManager dm;
	
	public viewMessagesControl()
	{
		dm = new DataManager();
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	 * @throws SQLException 
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<Message> getMessages(int userId) throws SQLException {
		// begin-user-code
		// TODO Auto-generated method stub
		ArrayList<Message> messages = new ArrayList<Message>();
		try
		{
			messages = dm.requestMessages(userId);
		}
		catch (SQLException e)
		{
			throw e;
		}
		
		return messages;
		
		
		// end-user-code
	}
}