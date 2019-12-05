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
* @author sdownward
*/
public class PostNotificationUI
{
    private PostNotificationControl ctrl;
    private TextArea t;
    private Scene ass;
    private Stage stg;
    private Text m;
    private ComboBox c;

    public PostNotificationUI()
    {
        ctrl = new PostNotificationControl(MainMenu.getDataManager());
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

        Label l = new Label("Post Notification");
        pane.add(l, 2, 1);

        ArrayList<CourseOfferingInfoObject> cs = ctrl.getCourseOfferings();

        c = new ComboBox(FXCollections.observableArrayList(cs)); 
        pane.add(c, 2, 2);

        t = new TextArea();
        pane.add(t, 2, 3, 2, 1);

        Button bb = new Button("Submit");
        bb.setOnAction(this::subNot);
        bb.setPrefWidth(100);
        pane.add(bb, 10, 10);

        m = new Text("");
        pane.add(m, 3, 2);
        //pane.setGridLinesVisible(true);

        ass = new Scene(pane, 900, 600);
        return ass;
    }

	public void display(Stage s)
    {
        stg = s;
        stg.setScene(initScene());
        stg.show();
    }

    private void subNot(ActionEvent event)
    {
        CourseOfferingInfoObject coio = (CourseOfferingInfoObject)c.getValue();
        if(coio == null)
            {
                m.setText("Please select a course offering!");
                return;
            }
        if(t.getText().isEmpty())
            {
                m.setText("Message is a required field!");
                return;
            }
        try
            {
                Notification n = new Notification(t.getText(), "");
                ctrl.postNotification(n, coio);
                m.setText("Notification created!");
            }
        catch(Exception e)
            {
                m.setText("oopsie woopsie");
            }
    }

    private void backToMenu(ActionEvent event)
	{	
		MainMenu.displayMainMenu();
	}
}
