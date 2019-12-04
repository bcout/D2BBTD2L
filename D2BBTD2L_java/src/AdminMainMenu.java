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
 * This class displays a main menu for an admin user to use
 * @author Brennan Couturier, 3638808
 *
 */
public class AdminMainMenu 
{
	private Scene scMain;
	private GridPane mainPane;
	private Label lblWelcome;
	private Label onlyForFormatting;
	private Image mainMenuLogo;
	private ImageView mainMenuLogoView;
	private Image mainMenuIcon;
	private ImageView mainMenuIconView;
	private Button btnQuit;
	private Button btnCreateLoginAccount;
	private Button btnAddCourseOfferingInfo;
	private Button btnAddStudentCourseRegistrationInfo;
	private Button btnLogout;
	private Button btnCreateCourse;
	
	private void initMainMenuComponents()
	{
		try 
		{
			mainMenuLogo = new Image(new FileInputStream("images/D2BBTD2L_Logo.png"));
			mainMenuIcon = new Image(new FileInputStream("images/logo.png"));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println(e.getMessage());
		}
		mainMenuLogoView = new ImageView(mainMenuLogo);
		mainMenuLogoView.setFitHeight(160);
		mainMenuLogoView.setFitWidth(489);
		
		mainMenuIconView = new ImageView(mainMenuIcon);
		mainMenuIconView.setFitHeight(100);
		mainMenuIconView.setFitWidth(100);
		
		lblWelcome = new Label("Welcome " + MainMenu.getUserAccount().getFullNameInformal());
		lblWelcome.setPrefSize(489, 50);
		lblWelcome.setStyle("-fx-background-color: WHITE");
		lblWelcome.setFont(Font.font ("Verdana", 20));
		lblWelcome.setAlignment(Pos.CENTER);
		
		onlyForFormatting = new Label("");
		onlyForFormatting.setPrefWidth(80);
		
		btnAddStudentCourseRegistrationInfo = new Button("Add Student to Course");
		btnAddStudentCourseRegistrationInfo.setOnAction(this::processAddStudentButtonPress);
		btnAddStudentCourseRegistrationInfo.setPrefWidth(170);
		
		btnAddCourseOfferingInfo = new Button("New Class");
		btnAddCourseOfferingInfo.setOnAction(this::processAddCourseButtonPress);
		btnAddCourseOfferingInfo.setPrefWidth(120);
		
		btnCreateCourse = new Button("New Course");
		btnCreateCourse.setOnAction(this::processCreateCourseButtonPress);
		btnCreateCourse.setPrefWidth(100);
		
		btnLogout = new Button("Logout");
		btnLogout.setOnAction(this::processLogoutButtonPress);
		btnLogout.setPrefWidth(70);
		
		btnCreateLoginAccount = new Button("Create Account");
		btnCreateLoginAccount.setOnAction(this::processCreateAccountButtonPress);
		btnCreateLoginAccount.setPrefWidth(120);
		
		btnQuit = new Button("Quit");
		btnQuit.setOnAction(this::processExitButtonPress);
		btnQuit.setPrefWidth(70);
		
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

		mainPane.add(btnLogout, 6, 0);
		mainPane.add(btnAddCourseOfferingInfo, 2, 3);
		mainPane.add(btnCreateCourse, 1, 3);
		mainPane.add(btnAddStudentCourseRegistrationInfo, 3, 3);
		mainPane.add(btnCreateLoginAccount, 4, 3);
		mainPane.add(btnQuit, 6, 3);
		mainPane.add(lblWelcome, 2, 1, 5, 1);
		mainPane.add(mainMenuIconView, 1, 0);
		mainPane.add(mainMenuLogoView, 2, 7, 5, 5);
		
		scMain = new Scene(mainPane, 900, 600);
		return scMain;
	}
	
	public void displayAdminMainMenu(Stage stg)
	{
		stg.setScene(initMainMenu());
		stg.show();
	}
	
	private void processCreateAccountButtonPress(ActionEvent event)
	{
		createLoginAccountUI clau = new createLoginAccountUI();
		clau.displayCreateLoginAccount(MainMenu.getStage());
	}
	
	public void resetToMainMenu()
	{
		displayAdminMainMenu(MainMenu.getStage());
	}
	
	private void processAddCourseButtonPress(ActionEvent event)
	{
		addCourseOfferingInfoUI acoi = new addCourseOfferingInfoUI();
		acoi.displayAddCourseOfferingInfoForm(MainMenu.getStage());
	}
	
	private void processAddStudentButtonPress(ActionEvent event)
	{
		//display addStudentCourseRegistrationInfo
	}
	
	private void processCreateCourseButtonPress(ActionEvent event)
	{
		CreateCourseUI ccu = new CreateCourseUI();
		ccu.displayCreateCourse(MainMenu.getStage());
	}
	
	private void processLogoutButtonPress(ActionEvent event)
	{
		MainMenu.processLogout();
	}
	
	private void processExitButtonPress(ActionEvent event)
	{
		MainMenu.getStage().close();
	}
}
