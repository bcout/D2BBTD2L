

import javafx.application.*;
import javafx.stage.Stage;

public class PostMessageGUITest extends Application
{	
	private Stage stgMain;
	
	public void start(Stage primaryStage)
	{
		stgMain = primaryStage;
		postMessageUI pmu = new postMessageUI();
		pmu.displayCreateMessageForm(stgMain);
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public Stage getStage()
	{
		return stgMain;
	}
}
