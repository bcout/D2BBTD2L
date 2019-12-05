import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import java.util.*;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*; 
import javafx.stage.Stage; 
import javafx.scene.text.Text.*; 
import javafx.scene.paint.*; 
import javafx.scene.text.*; 

/** 
 * @author sdownwar
 */
public class ViewNotificationsUI
{
    private ViewNotificationsControl ctrl;
    private Scene ass;
    private ListView<Notification> lv;
    private Label m;

    public ViewNotificationsUI(DataManager dm)
    {
        ctrl = new ViewNotificationsControl(dm);
    }

    public Scene initScene()
    {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);

        //Back btn
        Button b = new Button("Back");
        b.setOnAction(this::backToMenu);
        b.setPrefWidth(50);
        pane.add(b, 10, 0);

        m = new Label("");
        m.setWrapText(true);
        m.setMinWidth(200);
        m.setPrefWidth(200);
        pane.add(m, 3, 1);

        lv = new ListView<Notification>();
        for(Notification n : ctrl.getNotifications())
            {
                lv.getItems().add(n);
            }
        lv.setOnMouseClicked(this::lvClicked);
        pane.add(lv, 2, 1);

        ass = new Scene(pane, 900, 600);
        return ass;
    }

    public void display(Stage s)
    {
        s.setScene(initScene());
        s.show();
    }

    private void lvClicked(MouseEvent e)
    {
        Notification n = lv.getSelectionModel().getSelectedItem();
        if(n == null) return;
        m.setText(n.body);
    }

    private void backToMenu(ActionEvent event)
	{	
		MainMenu.displayMainMenu();
	}
}
