import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class displays the main menu for the TA user
 * @author Brennan Couturier, 3638808
 *
 */
public class TAMainMenu 
{
	private Scene scMain;
	private GridPane mainPane;
	private Label lblWelcome;
	private Image mainMenuLogo;
	private ImageView mainMenuLogoView;
	private Image mainMenuIcon;
	private ImageView mainMenuIconView;
	
	private Button btnPostMarks;
	private Button btnLogout;
	private Button btnQuit;
	private Button btnViewMessages;
	private Button btnAssignments;
	private Button btnNotifications;
	
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
		
		btnQuit = new Button("Quit");
		btnQuit.setOnAction(this::processQuitButtonPress);
		btnQuit.setPrefWidth(70);
		
		btnLogout = new Button("Logout");
		btnLogout.setOnAction(this::processLogoutButtonPress);
		btnLogout.setPrefWidth(70);
		
		btnPostMarks = new Button("Post Marks");
		btnPostMarks.setOnAction(this::processPostMarksButtonPress);
		btnPostMarks.setPrefWidth(100);
		
		btnViewMessages = new Button("Messages");
		btnViewMessages.setOnAction(this::processViewMessageButtonPress);
		btnViewMessages.setPrefWidth(100);
		
		btnAssignments = new Button("Assignments");
		btnAssignments.setOnAction(this::processAssignmentsButtonPress);
		btnAssignments.setPrefWidth(120);
		
		btnNotifications = new Button("Notifications");
		btnNotifications.setOnAction(this::processNotificationsButtonPress);
		btnNotifications.setPrefWidth(120);

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
		mainPane.add(btnLogout, 7, 0);
		mainPane.add(btnQuit, 7, 3);
		mainPane.add(btnViewMessages, 2, 3);
		mainPane.add(btnPostMarks, 3, 3);
		mainPane.add(btnNotifications, 4, 3);
		mainPane.add(btnAssignments, 5, 3);
		mainPane.add(lblWelcome, 2, 1, 5, 1);
		mainPane.add(mainMenuIconView, 1, 0);
		mainPane.add(mainMenuLogoView, 2, 7, 5, 5);

		scMain = new Scene(mainPane, 900, 600);
		return scMain;
	}
	
	public void displayTAMainMenu(Stage stg)
	{
		stg.setScene(initMainMenu());
		stg.show();
	}
	
	public void resetToMainMenu()
	{
		displayTAMainMenu(MainMenu.getStage());
	}
	
	private void processPostMarksButtonPress(ActionEvent event)
	{
		enterMarkUI ui = new enterMarkUI();
    ui.displayEnterMarkForm(MainMenu.getStage());
	}
	
	private void processQuitButtonPress(ActionEvent event)
	{
		MainMenu.getStage().close();
	}
	
	private void processViewMessageButtonPress(ActionEvent event)
	{
		viewMessagesUI vmu = new viewMessagesUI();
		vmu.displayViewMessages(MainMenu.getStage());
	}
	
	private void processNotificationsButtonPress(ActionEvent event)
	{
		ViewNotificationsUI vnu = new ViewNotificationsUI(MainMenu.getDataManager());
		vnu.display(MainMenu.getStage());
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
