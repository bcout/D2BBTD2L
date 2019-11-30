import javafx.application.Application;
import javafx.stage.Stage;

public class TestCourseRegUI extends Application{
	public void start(Stage stg) {
		addCourseRegistrationInfoUI ui = new addCourseRegistrationInfoUI();
		ui.displayAddCourseRegistrationInfo(stg);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
