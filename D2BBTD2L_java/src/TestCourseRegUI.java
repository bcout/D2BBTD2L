import javafx.application.Application;
import javafx.stage.Stage;

public class TestCourseRegUI extends Application{
	public void start(Stage stg) {
		addCourseRegistrationInfoControl control = new addCourseRegistrationInfoControl(new DataManager());
		addCourseRegistrationInfoUI ui = new addCourseRegistrationInfoUI(control);
		ui.displayAddCourseRegistrationInfo(stg);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
