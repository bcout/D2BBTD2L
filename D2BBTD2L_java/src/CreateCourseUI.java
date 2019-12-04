import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CreateCourseUI 
{
	private CreateCourseControl ccc;
	private String courseNumber;
	private String courseDescription;
	
	private Scene scCreateCourse;
	private GridPane createCoursePane;
	private Label lblError;
	private Label lblWelcome;
	private Label lblCourseNum;
	private Label lblCourseDesc;
	private TextField txtCourseNum;
	private TextField txtCourseDesc;
	private Button btnCreateCourse;
	private Button btnExit;
	
	public CreateCourseUI()
	{
		ccc = new CreateCourseControl();
	}
	
	public void displayCreateCourse(Stage stg)
	{
		stg.setScene(initCreateCourse());
		stg.show();
	}
	
	private void initCreateCourseComponents()
	{
		lblError = new Label("");
		lblError.setPrefSize(400, 50);
		
		lblWelcome = new Label("Create a new course");
		lblWelcome.setPrefSize(300, 100);
		lblWelcome.setFont(Font.font ("Verdana", 14));
		
		lblCourseNum = new Label("Course Number:");
		lblCourseNum.setAlignment(Pos.CENTER_RIGHT);
		lblCourseNum.setPrefWidth(150);
		
		lblCourseDesc = new Label("Course Description:");
		lblCourseDesc.setAlignment(Pos.CENTER_RIGHT);
		lblCourseDesc.setPrefWidth(150);
		
		txtCourseNum = new TextField();
		txtCourseNum.setPrefWidth(200);
		
		txtCourseDesc = new TextField();
		txtCourseDesc.setPrefWidth(200);
		
		btnCreateCourse = new Button("Create Course");
		btnCreateCourse.setOnAction(this::processCreateCourseButtonPress);
		btnCreateCourse.setPrefWidth(150);
		
		btnExit = new Button("Exit");
		btnExit.setOnAction(this::processExitButtonPress);
		btnExit.setPrefWidth(80);
		
		createCoursePane = new GridPane();
		createCoursePane.setHgap(20);
		createCoursePane.setVgap(20);
		createCoursePane.setAlignment(Pos.CENTER);
		//createCoursePane.setGridLinesVisible(true);
		
	}
	
	private Scene initCreateCourse()
	{
		initCreateCourseComponents();
		
		createCoursePane.add(lblWelcome, 1, 0, 2, 1);
		createCoursePane.add(lblCourseNum, 1, 3);
		createCoursePane.add(lblCourseDesc, 1, 4);
		createCoursePane.add(txtCourseNum, 2, 3);
		createCoursePane.add(txtCourseDesc, 2, 4);
		createCoursePane.add(btnCreateCourse, 2, 5);
		createCoursePane.add(lblError, 1, 6, 2, 1);
		createCoursePane.add(btnExit, 3, 0);
		
		scCreateCourse = new Scene(createCoursePane, 900, 600);
		return scCreateCourse;
	}
	
	private void getDetails()
	{
		courseNumber = txtCourseNum.getText().trim();
		courseDescription = txtCourseDesc.getText().trim();
		
		if(courseNumber.isEmpty() && courseDescription.isEmpty())
		{
			displayErrorMessage("Course number and course description are required fields");
		}
		else if(courseNumber.isEmpty())
		{
			displayErrorMessage("Course number is a required field");
		}
		else if(courseDescription.isEmpty())
		{
			displayErrorMessage("Course description is a required field");
		}		
		else
		{
			handleCreateCourse(courseNumber, courseDescription);
		}
		
		
	}
	
	private void handleCreateCourse(String courseNumber, String courseDescription)
	{
		boolean success = ccc.handleCreateCourse(courseNumber, courseDescription);
		
		if(success)
		{
			displayConfirmationMessage("Course successfuly created");
		}
		else
		{
			displayErrorMessage("Error creating course");
		}
		
	}
	
	private void processExitButtonPress(ActionEvent event)
	{
		AdminMainMenu amm = new AdminMainMenu();
		amm.resetToMainMenu();
	}

	private void processCreateCourseButtonPress(ActionEvent event)
	{
		getDetails();
	}

	private void displayConfirmationMessage(String message) 
	{
		lblError.setText(" " + message);
		
		lblError.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		lblError.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, null)));
	}

	private void displayErrorMessage(String message) 
	{
		lblError.setText(" " + message);
		
		lblError.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		lblError.setBackground(new Background(new BackgroundFill(Color.MISTYROSE, CornerRadii.EMPTY, null)));
	}
}
