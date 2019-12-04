import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	
	private ComboBox students;
	private ComboBox courses;
	
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
		enterListB.setOnAction(e -> submitCourseRegistrationForm());
		list = new TableView<>();
		TableColumn<CourseRegistration, String> column1 = new TableColumn<>("Username");
		column1.setCellValueFactory(new PropertyValueFactory<>("username"));
		
		TableColumn<CourseRegistration, String> column2 = new TableColumn<>("Course Number");
		column2.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
		column2.setMinWidth(200);
		
		TableColumn<CourseRegistration, String> column3 = new TableColumn<>("Term");
		column3.setCellValueFactory(new PropertyValueFactory<>("term"));
		
		students = new ComboBox();
		students.getItems().addAll(control.getAllStudentAccounts());
		
		courses = new ComboBox();
		courses.getItems().addAll(control.getAllOfferedCourses());
		
		list.getColumns().add(column1);
        list.getColumns().add(column2);
        list.getColumns().add(column3);
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
			list.getItems().add(new CourseRegistration(sId,cId));
		} catch (NullPointerException e) {
			message.setText("Please fill out all fields");
		} catch (NumberFormatException e) {
			message.setText("Please enter integer values");
		}	
	}
	public void submitCourseRegistrationForm() {

		ArrayList<CourseRegistration> cr =  new ArrayList<CourseRegistration>(list.getItems());

		int errorID = enterCourseRegistrationInfo(cr);
		
		//empty list
		if (errorID == 2) {
			message.setText("Please insert registration info");
		} 
		//successfully added
		else if (errorID == 1) {
			displayConfirmationMessage();
		} 
		//non-student account being added
		else if (errorID == 0) {
			message.setText("Please ensure that only students are being registered");
		} 
		//sql error
		else {
			displayFailureMessage();
		}
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
		
	public int enterCourseRegistrationInfo(ArrayList<CourseRegistration> cr) {
		return control.submitCourseRegistrationInfo(cr);
	}

	public void displayConfirmationMessage() {
		message.setText("Successfully added registration info");
	}
	
	public void displayFailureMessage() {
		message.setText("Failed to add registration info");
	}
}
