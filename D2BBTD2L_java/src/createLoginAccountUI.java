import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import java.util.Scanner;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author bcouturi
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class createLoginAccountUI {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private createLoginAccountControl control;

	
	public createLoginAccountUI(createLoginAccountControl control) {
		this.control = control;
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	public void displayAccountCreationForm() {
		
	}
	
	public void displayStudentAccountCreationForm() {
		System.out.println("Enter username, password, fname, lname");
		Scanner sc = new Scanner(System.in);
		Account ac = new Account();
		ac.username = sc.nextLine();
		ac.password = sc.nextLine();
		ac.firstName = sc.nextLine();
		ac.lastName = sc.nextLine();
		ac.accountType = 1;
		
		enterStudentAccountInfo(ac);
		
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	public void enterStudentAccountInfo(Account ac) {
		//create account with generic info
		int id = control.createAccount(ac,1);
		
		//create student account with specific info
		StudentAccount stdAcc = new StudentAccount();
		stdAcc.accountId = id;
		stdAcc.hasUnreadNotifications = 0;
		control.createStudent(stdAcc);
		displayStudentLoginCreationConfirmation();
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayStudentLoginCreationConfirmation() {
		System.out.println("Success");
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void enterTAAccountInfo(Account ac, String email) {
		// begin-user-code
		// TODO Auto-generated method stub
		int id = control.createAccount(ac,3);
		
		//create ta account with specific info
		TA_Account TA_Acc = new TA_Account();
		TA_Acc.accountId = id;
		TA_Acc.email = email;
		control.createTA(TA_Acc);
		displayTAAccountCreationConfirmation();
		// end-user-code
	}
	
	public void displayTAAccountCreationForm() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayTAAccountCreationConfirmation() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void enterProfAccountInfo() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayProfAccountCreationForm() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayProfAccountCreationConfirmation() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void enterAdminAccountInfo() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayAdminAccountCreationForm() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayAdminAccountCreationConfirmation() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}