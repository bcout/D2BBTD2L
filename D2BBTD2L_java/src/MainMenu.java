import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainMenu extends Application
{
	private static Stage stgMain;
	private int userId;
	private static DataManager dm;
	
	private Scene scMain;
	private GridPane mainPane;
	private Button btnPostMessage;
	
	
	public void start(Stage primaryStage)
	{
		stgMain = primaryStage;
		dm = new DataManager();
		loginUI lu = new loginUI();
		lu.displayLoginForm(stgMain);
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void displayNormalMainMenu(Stage stg)
	{
		stg.setScene(initNormalMainMenu());
		stg.show();
	}
	
	private Scene initNormalMainMenu()
	{
		loginUI lu = new loginUI();
		userId = lu.getUserId();
		
		initNormalMainMenuComponents();
		
		mainPane.add(btnPostMessage, 1, 1);
		
		scMain = new Scene(mainPane, 900, 600);
		return scMain;
	}
	
	private void initNormalMainMenuComponents()
	{		
		btnPostMessage = new Button("New Message");
		btnPostMessage.setOnAction(this::processPostMessageButtonPress);
		btnPostMessage.setPrefWidth(80);
		
		mainPane = new GridPane();
		mainPane.setHgap(20);
		mainPane.setVgap(20);
		mainPane.setAlignment(Pos.CENTER);
	}
	
	/*
	public void displayAdminMainMenu(Stage stg)
	{
		stg.setScene(initAdminMainMenu());
		stg.show();
	}
	
	
	private Scene initAdminMainMenu()
	{
		loginUI lu = new loginUI();
		userId = lu.getUserId();
		
		initAdminMainMenuComponents();
	}
	
	private void initAdminMainMenuComponents()
	{
		
	}
	*/
	
	private void processPostMessageButtonPress(ActionEvent event)
	{
		
	}
	
	public Stage getStage()
	{
		return stgMain;
	}
	
	
	public DataManager getDataManager()
	{
		return dm;
	}
	
	public int getUserId()
	{
		return userId;
	}

}
