

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

/**
 * This class starts the application and loads the login screen. Displays whatever main menu corresponds to the logged in user.
 * @author Brennan Couturier, 3638808
 * 
 */
public class MainMenu extends Application
{
	//Non-javafx variables
	//-------------------------------------------
	private static DataManager dm;
	private static Account userAccount;
	private static Boolean darkModeEnabled;
	
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
		stgMain.setResizable(false);
		dm = new DataManager();
		darkModeEnabled = false;
		
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
				
				loginUI lu = new loginUI();
				lu.displayLoginForm(stgMain);
				
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
	
	private static void displayStudentMainMenu(Stage stg)
	{
		StudentMainMenu smm = new StudentMainMenu();
		smm.displayStudentMainMenu(stg);
	}
	
	private static void displayAdminMenu(Stage stg)
	{
		AdminMainMenu amm = new AdminMainMenu();
		amm.displayAdminMainMenu(stg);
	}
	
	private static void displayProfMainMenu(Stage stg)
	{
		ProfMainMenu pmm = new ProfMainMenu();
		pmm.displayProfMainMenu(stg);
	}
	
	private static void displayTAMainMenu(Stage stg)
	{
		TAMainMenu tmm = new TAMainMenu();
		tmm.displayTAMainMenu(stg);
	}
	
	public static void displayMainMenu()
	{
		if(userAccount.getAccountType() == 1)
		{
			displayStudentMainMenu(stgMain);
		}
		else if(userAccount.getAccountType() == 2)
		{
			displayAdminMenu(stgMain);
		}
		else if(userAccount.getAccountType() == 3)
		{
			displayTAMainMenu(stgMain);
		}
		else if(userAccount.getAccountType() == 4)
		{
			displayProfMainMenu(stgMain);
		}
	}

	public static Stage getStage()
	{
		return stgMain;
	}
	
	public static int getUserId()
	{
		return userAccount.getAccountId();
	}


	public static DataManager getDataManager()
	{
		return dm;
	}
	
	public static Account getUserAccount()
	{
		return userAccount;
	}
	
	public static void setUser(Account user)
	{
		userAccount = user;
	}
	
	public static void processLogout()
	{
		loginUI lu = new loginUI();
		lu.displayLoginForm(stgMain);
		userAccount = null;
	}
	
	public static Boolean getDarkModeEnabled()
	{
		return darkModeEnabled;
	}
	
	public static void setDarkModeEnabled(Boolean value)
	{
		darkModeEnabled = value;
	}
}
