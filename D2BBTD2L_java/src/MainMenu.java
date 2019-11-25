import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.*;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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

	public void start(Stage primaryStage)
	{	
		stgMain = primaryStage;
		//stgMain.initStyle(StageStyle.UNDECORATED);
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
				//displayStudentMainMenu(stgMain);
				//If logged in user is admin
				displayAdminMenu(stgMain);
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
	
	public void displayStudentMainMenu(Stage stg)
	{
		StudentMainMenu smm = new StudentMainMenu();
		smm.displayStudentMainMenu(stg);
	}
	
	public void displayAdminMenu(Stage stg)
	{
		AdminMainMenu amm = new AdminMainMenu();
		amm.displayAdminMainMenu(stg);
	}
	
	public void displayProfMenu(Stage stg)
	{
		
	}
	
	public void displayTAMenu(Stage stg)
	{
		
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
	
	public static void setUserId(int userIdIn)
	{
		userId = userIdIn;
	}
}
