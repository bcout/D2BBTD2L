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

public class AdminMainMenu 
{
	private Scene scMain;
	private GridPane mainPane;
	private Label lblWelcome;
	private Image mainMenuLogo;
	private ImageView mainMenuLogoView;
	private Image mainMenuIcon;
	private ImageView mainMenuIconView;
	private Button btnQuit;
	private Button btnCreateLoginAccount;
	private Button btnAddCourseOfferingInfo;
	
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
		
		lblWelcome = new Label("Welcome Mr.Couturier");
		lblWelcome.setPrefSize(489, 50);
		lblWelcome.setStyle("-fx-background-color: WHITE");
		lblWelcome.setFont(Font.font ("Verdana", 20));
		lblWelcome.setAlignment(Pos.CENTER);
		
		
		btnAddCourseOfferingInfo = new Button("New Course");
		btnAddCourseOfferingInfo.setOnAction(this::processAddCourseButtonPress);
		btnAddCourseOfferingInfo.setPrefWidth(100);
		
		btnCreateLoginAccount = new Button("Create Account");
		btnCreateLoginAccount.setOnAction(this::processCreateAccountButtonPress);
		btnCreateLoginAccount.setPrefWidth(150);
		
		btnQuit = new Button("Quit");
		btnQuit.setOnAction(this::processExitButtonPress);
		btnQuit.setPrefWidth(50);
		
		mainPane = new GridPane();
		mainPane.setHgap(20);
		mainPane.setVgap(20);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setStyle("-fx-background-color: WHITE");
		mainPane.setGridLinesVisible(true);
	}
	
	private Scene initMainMenu()
	{
		initMainMenuComponents();
		
		mainPane.add(btnAddCourseOfferingInfo, 2, 3);
		mainPane.add(btnCreateLoginAccount, 1, 3);
		mainPane.add(btnQuit, 7, 3);
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
	
	public void processCreateAccountButtonPress(ActionEvent event)
	{
		//display create account form
	}
	
	public void processAddCourseButtonPress(ActionEvent event)
	{
		//display addCourseOfferingInfo
	}
	
	public void processExitButtonPress(ActionEvent event)
	{
		MainMenu.getStage().close();
	}
}
