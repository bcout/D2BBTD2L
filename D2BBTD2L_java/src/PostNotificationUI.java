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
    private Scene ass;
    private Stage stg;

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
        pane.add(b, 5, 0);

        Label l = new Label("Post Notification");
        pane.add(l, 0, 0);

        ArrayList<CourseOfferingInfoObject> cs = ctrl.getCourseOfferings();

        ComboBox c = 
            new ComboBox(FXCollections 
                         .observableArrayList(cs)); 
        pane.add(c, 5, 5);

        ass = new Scene(pane, 900, 600);
        return ass;
    }

	public void display(Stage s)
    {
        stg = s;
        stg.setScene(initScene());
        stg.show();
    }

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param ok
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayConfirmation(boolean ok) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param Parameter
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void insertPostNotificationInfo(Object Parameter) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

    private void backToMenu(ActionEvent event)
	{	
		MainMenu.displayMainMenu();
	}
}
