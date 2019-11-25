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
	private Label message;
	private Image logo;
	
	//Normal javafx variables
	//-------------------------------------------
	private static Stage stgMain;
	private static Scene scMain;
	private static GridPane mainPane;
	private static Button btnViewMessages;
	private static Button btnQuit;
	private static Label lblWelcome;

	public void start(Stage primaryStage)
	{	
		stgMain = primaryStage;
		stgMain.setResizable(false);
		stgMain.centerOnScreen();
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
				displayMainMenu(stgMain);
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
		message = new Label("D2BBTD2L");
		message.setPrefWidth(100);
		
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
		lblWelcome = new Label("Welcome to D2BBTD2L");
		lblWelcome.setPrefSize(300, 100);
		lblWelcome.setStyle("-fx-background-color: WHITE");
		lblWelcome.setFont(Font.font ("Verdana", 20));
		lblWelcome.setAlignment(Pos.CENTER);
		
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
	}

	private Scene initMainMenu()
	{
		initMainMenuComponents();

		mainPane.add(btnQuit, 10, 1);
		mainPane.add(lblWelcome, 5, 5);
		mainPane.add(btnViewMessages, 1, 1);

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
	
	public static void setUserId(int userIdIn)
	{
		userId = userIdIn;
	}
}
