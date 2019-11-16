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
		sc.close();
		enterStudentAccountInfo(ac);
		
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	public void enterStudentAccountInfo(Account ac) {
		//create account with generic info
		int id = control.createAccount(ac);
		if (id == -1) {
			displayFailureMessage();
		} else {
			//create student account with specific info
			StudentAccount stdAcc = new StudentAccount();
			stdAcc.accountId = id;
			stdAcc.hasUnreadNotifications = 0;
			control.createStudent(stdAcc);
			displayStudentLoginCreationConfirmation();
		}
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayStudentLoginCreationConfirmation() {
		System.out.println("Success");
	}

	public void displayFailureMessage() {
		System.out.println("Failure");
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void enterTAAccountInfo(Account ac, String email) {
		int id = control.createAccount(ac);
		if (id == -1) {
			displayFailureMessage();
		} else {
			//create ta account with specific info
			TA_Account TA_Acc = new TA_Account();
			TA_Acc.accountId = id;
			TA_Acc.email = email;
			control.createTA(TA_Acc);
			displayTAAccountCreationConfirmation();
		}
	}
	
	public void displayTAAccountCreationForm() {
		System.out.println("Enter username, password, fname, lname, email");
		Scanner sc = new Scanner(System.in);
		Account ac = new Account();
		ac.username = sc.nextLine();
		ac.password = sc.nextLine();
		ac.firstName = sc.nextLine();
		ac.lastName = sc.nextLine();
		String email = sc.nextLine();
		ac.accountType = 3;
		sc.close();
		enterTAAccountInfo(ac, email);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayTAAccountCreationConfirmation() {
		System.out.println("Success");
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void enterProfAccountInfo(Account ac, String faculty) {
		int id = control.createAccount(ac);
		
		if (id == -1) {
			displayFailureMessage();
		} else {
			ProfessorAccount profAc = new ProfessorAccount();
			profAc.accountId = id;
			profAc.faculty = faculty;
			control.createProf(profAc);
			displayProfAccountCreationConfirmation();
		}
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayProfAccountCreationForm() {
		System.out.println("Enter username, password, fname, lname, faculty");
		Scanner sc = new Scanner(System.in);
		Account ac = new Account();
		ac.username = sc.nextLine();
		ac.password = sc.nextLine();
		ac.firstName = sc.nextLine();
		ac.lastName = sc.nextLine();
		String faculty = sc.nextLine();
		ac.accountType = 4;
		sc.close();
		enterProfAccountInfo(ac, faculty);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayProfAccountCreationConfirmation() {
		System.out.println("Success");
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void enterAdminAccountInfo(Account ac, String position) {
		int id = control.createAccount(ac);
		if (id == -1) {
			displayFailureMessage();
		} else {
			AdminAccount adminAc = new AdminAccount();
			adminAc.accountId = id;
			adminAc.position = position;
			control.createAdmin(adminAc);
			displayAdminAccountCreationConfirmation();
		}
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayAdminAccountCreationForm() {
		System.out.println("Enter username, password, fname, lname, position");
		Scanner sc = new Scanner(System.in);
		Account ac = new Account();
		ac.username = sc.nextLine();
		ac.password = sc.nextLine();
		ac.firstName = sc.nextLine();
		ac.lastName = sc.nextLine();
		String position = sc.nextLine();
		ac.accountType = 2;
		sc.close();
		enterAdminAccountInfo(ac, position);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayAdminAccountCreationConfirmation() {
		System.out.println("Success");
	}
}