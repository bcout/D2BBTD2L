import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class displays a main menu for the student user
 * @author Brennan Couturier, 3638808
 *
 */
public class StudentMainMenu 
{
	private Scene scMain;
	private GridPane mainPane;
	private Label lblWelcome;
	private Image mainMenuLogo;
	private ImageView mainMenuLogoView;
	private Image mainMenuIcon;
	private ImageView mainMenuIconView;
	
	//Buttons
	//-------------------------------------------
	private Button btnViewMessages;
	private Button btnQuit;
	private Button btnMarks;
	private Button btnNotifications;
	private Button btnAssignments;
	private Button btnUploadAssignment;
	private Button btnLogout;
	//-------------------------------------------
	
	private void initMainMenuComponents()
	{
		mainMenuLogoView = MainMenu.getD2BBTD2LLogo();
		mainMenuLogoView.setFitHeight(160);
		mainMenuLogoView.setFitWidth(489);
		
		mainMenuIconView = MainMenu.getCompanyLogo();
		mainMenuIconView.setFitHeight(100);
		mainMenuIconView.setFitWidth(100);
		
		lblWelcome = new Label("Welcome " + MainMenu.getUserAccount().getFullNameInformal());
		lblWelcome.setPrefSize(489, 50);
		lblWelcome.setStyle("-fx-background-color: WHITE");
		lblWelcome.setFont(Font.font ("Verdana", 20));
		lblWelcome.setAlignment(Pos.CENTER);
		
		btnAssignments = new Button("Assignments");
		btnAssignments.setOnAction(this::processAssignmentsButtonPress);
		btnAssignments.setPrefWidth(120);
		
		btnLogout = new Button("Logout");
		btnLogout.setOnAction(this::processLogoutButtonPress);
		btnLogout.setPrefWidth(70);
		
		btnUploadAssignment = new Button("Upload Assignment");
		btnUploadAssignment.setOnAction(this::processUploadAssignmentsButtonPress);
		btnUploadAssignment.setPrefWidth(150);
		btnUploadAssignment.setTooltip(new Tooltip("Upload an assignment"));
		
		btnNotifications = new Button("Notifications");
		btnNotifications.setOnAction(this::processNotificationsButtonPress);
		btnNotifications.setPrefWidth(120);
		
		btnMarks = new Button("Marks");
		btnMarks.setOnAction(this::processMarksButtonPress);
		btnMarks.setPrefWidth(100);
		
		btnQuit = new Button("Quit");
		btnQuit.setOnAction(this::processExitButtonPress);
		btnQuit.setPrefWidth(70);
		
		btnViewMessages = new Button("Messages");
		btnViewMessages.setOnAction(this::processViewMessageButtonPress);
		btnViewMessages.setPrefWidth(100);

		mainPane = new GridPane();
		mainPane.setHgap(20);
		mainPane.setVgap(20);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setStyle("-fx-background-color: WHITE");
		//mainPane.setGridLinesVisible(true);
	}

	private Scene initMainMenu()
	{
		initMainMenuComponents();

		//Col, row
		mainPane.add(btnLogout, 6, 0);
		mainPane.add(btnQuit, 6, 3);
		mainPane.add(btnMarks, 2, 3);
		mainPane.add(btnNotifications, 3, 3);
		mainPane.add(btnAssignments, 4, 3);
		mainPane.add(btnUploadAssignment, 5, 3);
		mainPane.add(lblWelcome, 2, 1, 5, 1);
		mainPane.add(mainMenuIconView, 1, 0);
		mainPane.add(mainMenuLogoView, 2, 7, 5, 5);
		mainPane.add(btnViewMessages, 1, 3);

		scMain = new Scene(mainPane, 900, 600);
		return scMain;
	}

	public void displayStudentMainMenu(Stage stg)
	{
		stg.setScene(initMainMenu());
		stg.show();
	}
	
	public void resetToMainMenu()
	{
		displayStudentMainMenu(MainMenu.getStage());
	}
	
	private void processViewMessageButtonPress(ActionEvent event)
	{
		viewMessagesUI vmu = new viewMessagesUI();
		vmu.displayViewMessages(MainMenu.getStage());
	}
	
	private void processExitButtonPress(ActionEvent event)
	{
		MainMenu.getStage().close();
	}
	
	private void processMarksButtonPress(ActionEvent event)
	{
		ViewMarksUI vmu = new ViewMarksUI(MainMenu.getDataManager());
		vmu.display(MainMenu.getStage());
	}
	
	
	
	private void processNotificationsButtonPress(ActionEvent event)
	{
        ViewNotificationsUI v = new ViewNotificationsUI(MainMenu.getDataManager());
        v.display(MainMenu.getStage());
	}
	
	private void processUploadAssignmentsButtonPress(ActionEvent event)
	{
		uploadAssignmentUI ui = new uploadAssignmentUI();
		ui.displayAssignmentUploadForm(MainMenu.getStage());
	}
	
	private void processAssignmentsButtonPress(ActionEvent event)
	{
		ViewAssignmentUI vau = new ViewAssignmentUI();
		vau.displayPostAssignmentForm(MainMenu.getStage());
	}
	
	private void processLogoutButtonPress(ActionEvent event)
	{
		MainMenu.processLogout();
	}
}
