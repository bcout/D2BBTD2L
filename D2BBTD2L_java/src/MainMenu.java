


import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu extends Application
{
	private static Stage stgMain;
	private static DataManager dm;

	private Scene scMain;
	private GridPane mainPane;
	private Button btnPostMessage;
	private Button btnQuit;
	private Label lblWelcome;

	public void start(Stage primaryStage)
	{
		stgMain = primaryStage;
		stgMain.setResizable(false);
		dm = new DataManager();
		displayMainMenu(stgMain);
	}

	public static void main(String[] args)
	{
		launch(args);
	}

	private void initMainMenuComponents()
	{		
		lblWelcome = new Label("Welcome to D2BBTD2L");
		lblWelcome.setPrefSize(300, 100);
		lblWelcome.setStyle("-fx-background-color: WHITE");
		lblWelcome.setFont(Font.font ("Verdana", 20));
		lblWelcome.setAlignment(Pos.CENTER);
		
		btnQuit = new Button("Quit");
		btnQuit.setPrefWidth(50);
		
		btnPostMessage = new Button("New Message");
		btnPostMessage.setOnAction(this::processPostMessageButtonPress);
		btnPostMessage.setPrefWidth(120);

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
		mainPane.add(btnPostMessage, 1, 1);

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
}
