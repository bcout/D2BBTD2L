/**
 * 
 */

import java.util.*;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Brennan Couturier 3638808
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class postMessageUI {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private postMessageControl pmc;
	
	private boolean postSuccessful;
	private int from_id;
	private int to_id;
	private Scanner scan = new Scanner(System.in);
	private String messageText;
	
	public postMessageUI()
	{
		pmc = new postMessageControl();
	}
	
	public postMessageUI(int num)
	{
		
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayCreateMessageForm() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Enter sender id");
		from_id = scan.nextInt();
		System.out.println("Enter recipient id");
		to_id = scan.nextInt();
		
		postMessageUI pmu = new postMessageUI(1);
		pmu.writeMessage();
		
		scan.close();
		
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void writeMessage() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Enter message:");
		messageText = scan.nextLine();
		
		System.out.println(messageText);
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayPostMessageConfirmation() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}