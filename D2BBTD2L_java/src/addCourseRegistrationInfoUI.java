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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * UI class for the AddCourseRegistrationInfo use case
 * @author Ben Donkin
 *
 */
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
	
	/**
	 * Constructors for UIClass
	 */
	public addCourseRegistrationInfoUI() {
		control = new addCourseRegistrationInfoControl();
	}
	
	/**
	 * Initializes the javafx components 
	 */
	private void initComponents() {
		accountL = new Label("Full Name");
		courseOffL = new Label("Course Number");
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
		backB.setOnAction(this::processBackButtonPress);
		
		list = new TableView<>();
		TableColumn<CourseRegistration, String> column1 = new TableColumn<>("Username");
		column1.setCellValueFactory(new PropertyValueFactory<>("username"));
		column1.setMinWidth(100);
		
		TableColumn<CourseRegistration, String> column2 = new TableColumn<>("Course");
		column2.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
		
		TableColumn<CourseRegistration, Integer> column3 = new TableColumn<>("Term");
		column3.setCellValueFactory(new PropertyValueFactory<>("term"));
		
		TableColumn<CourseRegistration, Integer> column4 = new TableColumn<>("Year");
		column4.setCellValueFactory(new PropertyValueFactory<>("year"));
		
		students = new ComboBox();
		students.getItems().addAll(control.getAllStudentAccounts());
		
		courses = new ComboBox();
		courses.getItems().addAll(control.getAllOfferedCourses());
		
		list.getColumns().add(column1);
        list.getColumns().add(column2);
        list.getColumns().add(column3);
        list.getColumns().add(column4);
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
		root.add(students, 1, 1);
		root.add(courseOffL, 0, 2);
		root.add(courses, 1, 2);
		root.add(addListB, 1, 3);
		root.add(list, 2, 1, 2, 4);
		root.add(enterListB, 2, 5);
		root.add(clearListB, 3, 5);
		root.add(message, 2, 6,2,1);
		
		//root.setGridLinesVisible(true);
		
		root.setHgap(10);
		root.setVgap(10);
		
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root,900,600);
		return scene;
		
	}
	
	public void displayAddCourseRegistrationInfo(Stage stg) {
		stg.setScene(initScene());
		stg.show();
	}
	
	private void processBackButtonPress(ActionEvent event) {
		AdminMainMenu menu = new AdminMainMenu();
		menu.resetToMainMenu();
	}
	
	public void addList() {
		Account ac = (Account)students.getValue();
		CourseOfferingInfoObject course = (CourseOfferingInfoObject)courses.getValue();
		try {
			int sId = ac.getAccountId();
			int cId = course.getCourseId();
			String un = ac.getUsername();
			String cNum = course.getCourseNum();
			int term = course.getTerm();
			int year = course.getYear();
			list.getItems().add(new CourseRegistration(sId,cId,un,cNum,term,year));
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
		//sql error
		else {
			displayFailureMessage();
		}
	}
		
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
