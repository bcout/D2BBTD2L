import javafx.application.Application;
import javafx.stage.Stage;

public class enterMarkUITest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    DataManager dm = new DataManager();
    enterMarkUI ui = new enterMarkUI(dm);
    ui.displayEnterMarkForm(stage);
  }
}
