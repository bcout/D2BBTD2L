import javafx.stage.Stage;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <p>The loginForm will have a drop down menu for the user to select what kind of user they are, admin, prof, student or TA</p>
 * <!-- end-UML-doc -->
 * @author bcouturi
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class loginUI 
{
	private Boolean loginSuccessful;
	
	private int userId;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private loginControl class21;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayLoginForm(Stage stg) 
	{
		
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void enterCredentials() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayLoginConfirmation() 
	{
		//Set the user id here once they've logged in along with other things by calling setUserIdMainMenu and passing it the id of the user who just logged in
		//Thanks Logan
	}
	
	public void setUserIdMainMenu(int userId)
	{
		MainMenu.setUserId(userId);
	}
	
	
}