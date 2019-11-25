import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.*;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMenu extends Application
{
	//Non-javafx variables
	//-------------------------------------------
	private static DataManager dm;
	private static int userId;
	
	//Splash screen variables
	//-------------------------------------------
	private Scene splashScene;
	private GridPane splashPane;
	private Image logo;
	
	//javafx variables
	//-------------------------------------------
	private static Stage stgMain;
	private static Scene scMain;
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
	//-------------------------------------------

	public void start(Stage primaryStage)
	{	
		stgMain = primaryStage;
		stgMain.setResizable(false);
		dm = new DataManager();
		
		Stage temp = new Stage();
		temp.initStyle(StageStyle.UNDECORATED);
		displaySplashScreen(temp);
		
		Task<Void> sleeper = new Task<Void>()
		{
			protected Void call() throws Exception
			{
				try
				{
					Thread.sleep(2500);
				}
				catch(InterruptedException e)
				{
					
				}
				return null;
			}
		};
		
		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
		{
			public void handle(WorkerStateEvent event)
			{
				temp.close();
				//If logged in user is student
				displayMainMenu(stgMain);
				//If logged in user is admin
				//displayAdminMenu(stgMain);
				//If logged in user is professor
				//displayProfMenu(stgMain);
				//If logged in user is TA
				//displayTAMenu(stgMain);
			}
		});
		new Thread(sleeper).start();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
	
	private Scene initSplashScreen()
	{
		
		try 
		{
			logo = new Image(new FileInputStream("images/logo.png"));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println(e.getMessage());
		}
		ImageView logoView = new ImageView(logo);
		
		splashPane = new GridPane();
		splashPane = new GridPane();
		splashPane.setHgap(20);
		splashPane.setVgap(20);
		splashPane.setAlignment(Pos.CENTER);
		splashPane.setStyle("-fx-background-color: WHITE");
		
		splashPane.add(logoView, 1, 1);
		splashScene = new Scene(splashPane, 400, 300);
		return splashScene;
	}
	
	private void displaySplashScreen(Stage stg)
	{
		stg.setScene(initSplashScreen());
		stg.show();
	}
	
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
		
		lblWelcome = new Label("Welcome Brennan");
		lblWelcome.setPrefSize(489, 50);
		lblWelcome.setStyle("-fx-background-color: WHITE");
		lblWelcome.setFont(Font.font ("Verdana", 20));
		lblWelcome.setAlignment(Pos.CENTER);
		
		btnAssignments = new Button("Assignments");
		btnAssignments.setOnAction(this::processAssignmentsButtonPress);
		btnAssignments.setPrefWidth(120);
		
		btnUploadAssignment = new Button("Upload Assignment");
		btnUploadAssignment.setOnAction(this::processUploadAssignmentsButtonPress);
		btnUploadAssignment.setPrefWidth(150);
		
		btnNotifications = new Button("Notifications");
		btnNotifications.setOnAction(this::processNotificationsButtonPress);
		btnNotifications.setPrefWidth(100);
		
		btnMarks = new Button("Marks");
		btnMarks.setOnAction(this::processMarksButtonPress);
		btnMarks.setPrefWidth(100);
		
		btnQuit = new Button("Quit");
		btnQuit.setOnAction(this::processExitButtonPress);
		btnQuit.setPrefWidth(50);
		
		btnViewMessages = new Button("Messages");
		btnViewMessages.setOnAction(this::processPostMessageButtonPress);
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
		mainPane.add(btnQuit, 7, 3);
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

	private void displayMainMenu(Stage stg)
	{
		stg.setScene(initMainMenu());
		stg.show();
	}

	public static Stage getStage()
	{
		return stgMain;
	}
	
	public static int getUserId()
	{
		return userId;
	}


	public static DataManager getDataManager()
	{
		return dm;
	}


	public void resetToMainMenu()
	{
		displayMainMenu(getStage());
	}

	public void processPostMessageButtonPress(ActionEvent event)
	{
		viewMessagesUI vmu = new viewMessagesUI();
		vmu.displayViewMessages(stgMain);
	}
	
	public void processExitButtonPress(ActionEvent event)
	{
		stgMain.close();
	}
	
	public void processMarksButtonPress(ActionEvent event)
	{
		//display viewMarks
	}
	
	public void processNotificationsButtonPress(ActionEvent event)
	{
		//display viewNotifications
	}
	
	public void processUploadAssignmentsButtonPress(ActionEvent event)
	{
		//display upload assignment form
	}
	
	public void processAssignmentsButtonPress(ActionEvent event)
	{
		//display assignments
	}
	
	public static void setUserId(int userIdIn)
	{
		userId = userIdIn;
	}
}
