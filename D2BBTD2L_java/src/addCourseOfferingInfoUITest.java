import javafx.application.Application;
import javafx.stage.Stage;

public class addCourseOfferingInfoUITest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    DataManager dm = new DataManager();
    addCourseOfferingInfoUI ui = new addCourseOfferingInfoUI(dm);
    ui.displayAddCourseOfferingInfoForm(stage);
  }
}
