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
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*; 
import javafx.stage.Stage; 
import javafx.scene.text.Text.*; 
import javafx.scene.paint.*; 
import javafx.scene.text.*;
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

	private ComboBox typesComboBox;
	private TextField unameTF;
	private TextField passTF;
	private TextField fnameTF;
	private TextField lnameTF;
	
	private TextField emailTF;
	private TextField facultyTF;
	private TextField positionTF;
	
	private Button enterStudent;
	private Button enterTA;
	private Button enterProf;
	private Button enterAdmin;
	
	Label emailL = new Label("E-mail:");
	Label facultyL = new Label("Faculty:");
	Label positionL = new Label("Position:");
	
	private GridPane root;
	private GridPane specific;
	
	private Text message;
	public createLoginAccountUI(createLoginAccountControl control) {
		this.control = control;
	}
	
	public void initSceneComponents() {
		String[] types  = {"Student", "Professor", "TA", "Administrator"};
		typesComboBox = new ComboBox(FXCollections.observableArrayList(types));
		
	
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
        	  String type = (String)typesComboBox.getValue();
        	  
        	  if (type.equals("Student")) {
        		  specific.getChildren().removeAll(specific.getChildren());
        		  specific.setConstraints(enterStudent,0,0);
        		  specific.getChildren().add(enterStudent);
        	  }
        	  else if (type.equals("Administrator")) {
        		  specific.getChildren().removeAll(specific.getChildren());
        		  specific.setConstraints(positionL,0,0);
        		  specific.setConstraints(positionTF,1,0);
        		  specific.setConstraints(enterAdmin,0,1,2,1);
        		  specific.getChildren().addAll(positionL,positionTF,enterAdmin);
        	  }
        	  
        	  else if (type.equals("Professor")) {
        		  specific.getChildren().removeAll(specific.getChildren());
        		  specific.setConstraints(facultyL,0,0);
        		  specific.setConstraints(facultyTF,1,0);
        		  specific.setConstraints(enterProf,0,1,2,1);
        		  specific.getChildren().addAll(facultyL,facultyTF, enterProf);
        	  }
        	  else {
        		  specific.getChildren().removeAll(specific.getChildren());
        		  specific.setConstraints(facultyL,0,0);
        		  specific.setConstraints(emailTF,1,0);
        		  specific.setConstraints(enterTA,0,1,2,1);
        		  specific.getChildren().addAll(emailL,emailTF,enterTA);
        	  }
          } 
		}; 
      	typesComboBox.setOnAction(event);
      	
		unameTF = new TextField();
		passTF = new TextField();
		fnameTF = new TextField();
		lnameTF = new TextField();
		
		emailTF = new TextField();
		facultyTF = new TextField();
		positionTF = new TextField();
		
		enterStudent = new Button("Create account");
		enterTA = new Button("Create account");
		enterProf = new Button("Create account");
		enterAdmin = new Button("Create account");
		message = new Text();
		
		enterStudent.setOnAction(e -> submitStudentAccountCreationForm());
		enterTA.setOnAction(e -> submitTAAccountCreationForm());
		enterProf.setOnAction(e -> submitProfAccountCreationForm());
		enterAdmin.setOnAction(e -> submitAdminAccountCreationForm());
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	public Scene displayAccountCreationForm() {
		initSceneComponents();
		GridPane pane = new GridPane();
		
		Label typeL = new Label("Choose account type:");
		Label unameL = new Label("Username:");
		Label passL = new Label("Password:");
		Label fnameL = new Label("First name:");
		Label lnameL = new Label("Last name:");
		
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);
		pane.setVgap(10);
		
		pane.setConstraints(typeL,0,0);
		pane.setConstraints(typesComboBox,1,0);
		pane.setConstraints(unameL,0,1);
		pane.setConstraints(unameTF,1,1);
		pane.setConstraints(passL,0,2);
		pane.setConstraints(passTF,1,2);
		pane.setConstraints(fnameL,0,3);
		pane.setConstraints(fnameTF,1,3);
		pane.setConstraints(lnameL,0,4);
		pane.setConstraints(lnameTF,1,4);
		
		pane.getChildren().addAll(typesComboBox,typeL,unameL,unameTF,passL,passTF,fnameL,fnameTF,lnameL,lnameTF);
		
		root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setConstraints(pane, 0, 0);
		root.getChildren().add(pane);

		specific = new GridPane();
		
		specific.setAlignment(Pos.CENTER);
		
		specific.setVgap(20);
		specific.setHgap(20);
	
		root.setVgap(10);
		root.setConstraints(specific,0,1);
		root.setConstraints(message, 0, 2, 1, 2);
		root.getChildren().add(specific);
		root.getChildren().add(message);
		
		Scene scene = new Scene(root, 400, 400);
		return scene;
	}
	
	public Account makeAccount() {
		Account ac = new Account();
		ac.username = unameTF.getText();
		ac.password = passTF.getText();
		ac.firstName = fnameTF.getText();
		ac.lastName = lnameTF.getText();
		return ac;
	}
	
	public void submitStudentAccountCreationForm() {
		Account ac = makeAccount();
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
		message.setText("Student account successfully created");
	}

	public void displayFailureMessage() {
		message.setText("Failure to make account");
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
	
	public void submitTAAccountCreationForm() {
		Account ac = makeAccount();
		ac.accountType = 3;
		String email = emailTF.getText();
		enterTAAccountInfo(ac, email);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayTAAccountCreationConfirmation() {
		message.setText("TA account successfully created");
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
	public void submitProfAccountCreationForm() {
		Account ac = makeAccount();
		String faculty = facultyTF.getText();
		ac.accountType = 4;
		enterProfAccountInfo(ac, faculty);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayProfAccountCreationConfirmation() {
		message.setText("Professor account successfully created");
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
	public void submitAdminAccountCreationForm() {
		Account ac = makeAccount();
		String position = positionTF.getText();
		ac.accountType = 2;
		enterAdminAccountInfo(ac, position);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayAdminAccountCreationConfirmation() {
		message.setText("Administrator account successfully created");
	}
}