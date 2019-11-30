import java.sql.Timestamp;
import java.util.ArrayList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class addCourseRegistrationInfoUI {
	
	private addCourseRegistrationInfoControl control;

	private Label accountL;
	private Label courseOffL;
	private Label listL;
	
	private Button addListB;
	private Button clearListB;
	private Button enterListB;
	private Button backB;
	
	private TextField accountTF;
	private TextField courseOffTF;
	
	private GridPane root;
	
	private Text message;
	
	private TableView<CourseRegistration> list;
	
	public addCourseRegistrationInfoUI() {
		
	}
	
	public addCourseRegistrationInfoUI(addCourseRegistrationInfoControl control) {
		this.control = control;
	}
	/**
	 * Initializes the javafx components 
	 */
	private void initComponents() {
		accountL = new Label("Account ID");
		courseOffL = new Label("Course Offering ID");
		listL = new Label("Current List");
		
		accountTF = new TextField();
		courseOffTF = new TextField();
		
		message = new Text();
		
		addListB = new Button("Add");
		clearListB = new Button("Clear List");
		enterListB = new Button("Submit List");
		backB = new Button("Back");
		
		addListB.setOnAction(e -> addList());
		clearListB.setOnAction(e -> list.getItems().clear());
		list = new TableView<>();
		TableColumn<CourseRegistration, Integer> column1 = new TableColumn<>("Account ID");
		column1.setCellValueFactory(new PropertyValueFactory<>("accountIdstudent"));
		
		TableColumn<CourseRegistration, Integer> column2 = new TableColumn<>("Course Offering ID");
		column2.setCellValueFactory(new PropertyValueFactory<>("courseOfferingId"));
		column2.setMinWidth(200);
		
		list.getColumns().add(column1);
        list.getColumns().add(column2);
        root = new GridPane();
	}
	
	/**
	 * Initializes the scene for the addCourseRegistrationInfo use case
	 */
	private Scene initScene() {
		initComponents();
		
		root.add(listL,2,0,2,1);
		root.add(backB,4,0);
		root.add(accountL, 0, 1);
		root.add(accountTF, 1, 1);
		root.add(courseOffL, 0, 2);
		root.add(courseOffTF, 1, 2);
		root.add(addListB, 1, 3);
		root.add(list, 2, 1, 2, 4);
		root.add(enterListB, 2, 5);
		root.add(clearListB, 3, 5);
		root.add(message, 2, 6,2,1);
		
		//root.setGridLinesVisible(true);
		
		root.setHgap(40);
		root.setVgap(10);
		
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root,900,600);
		return scene;
		
	}
	
	public void displayAddCourseRegistrationInfo(Stage stg) {
		stg.setScene(initScene());
		stg.show();
	}
	
	public void addList() {
		int sId = 0;
		int cId = 0;
		try {
			sId = Integer.parseInt(accountTF.getText());
			cId = Integer.parseInt(courseOffTF.getText());
		} catch (NullPointerException e) {
			message.setText("Please fill out all fields");
		} catch (NumberFormatException e) {
			message.setText("Please enter integer values");
		}
		list.getItems().add(new CourseRegistration(sId,cId));
	}
//	public void displayCourseRegistrationForm() {
//
//		ArrayList<CourseRegistration> cr = new ArrayList<CourseRegistration>();
//		System.out.println("'0' to stop");
//		while (true) {
//			System.out.println("Enter stdntID:");
//
//			System.out.println("Enter courseOffereingID:");
//			if (stdtID == 0 || offID == 0) {
//				break;
//			}
//			cr.add(new CourseRegistration(stdtID,offID));
//		}
//
//		if (enterCourseRegistrationInfo(cr)) {
//			displayConfirmationMessage();
//		} else {
//			displayFailureMessage();
//		}
//	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean enterCourseRegistrationInfo(ArrayList<CourseRegistration> cr) {
		return control.submitCourseRegistrationInfo(cr);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayConfirmationMessage() {
		System.out.println("Succes");
	}
	
	public void displayFailureMessage() {
		System.out.println("Failure");
	}
}
