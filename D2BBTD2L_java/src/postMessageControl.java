import java.sql.SQLException;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author bcouturi
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class postMessageControl 
{
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private DataManager dm;
	
	public postMessageControl()
	{
		dm = new DataManager();
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	 * @throws SQLException 
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean postMessage(String messageText, int from_accountId, int to_accountId) throws SQLException 
	{
		// begin-user-code
		// TODO Auto-generated method stub
		boolean successful;
		
		try
		{
			successful = dm.handleMessageSubmit(messageText, from_accountId, to_accountId);
		}
		catch (SQLException e)
		{
			throw e;
		}
		
		return successful;
		
		// end-user-code
	}
}