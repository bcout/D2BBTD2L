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

import java.util.Date;

/**
 * 
 */

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author sdownwar
 */
public class ViewMarksUI
{
	private Scene assSum; //Assignment summary
	private ListView<AssignmentSubmission> lv;
	private ViewMarksControl ctrl;
	private Stage stg;

	public ViewMarksUI(DataManager dm)
	{
		ctrl = new ViewMarksControl(dm);
	}

	private Scene initScene()
	{
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);

		//Listview
		lv = new ListView<AssignmentSubmission>();
		for(AssignmentSubmission a : ctrl.getAssSubs())
		{
			lv.getItems().add(a);
		}
		lv.setOnMouseClicked(this::assSubClicked);
		pane.add(lv, 0, 6);
		
		//Back btn
		Button btnExit = new Button("Back");
		btnExit.setOnAction(this::backToMenu);
		btnExit.setPrefWidth(50);
		pane.add(btnExit, 5, 0);

		Label ttl = new Label("Assignment Marks list");
		pane.add(ttl, 0, 0);
		
		assSum = new Scene(pane, 900, 600);
		return assSum;
	}

	public void display(Stage s)
	{
		stg = s;
		stg.setScene(initScene());
		stg.show();
	}

	private void assSubClicked(MouseEvent event)
	{
		AssignmentSubmission assSub = lv.getSelectionModel().getSelectedItem();
		if(assSub == null) return;
		//Redirect to assignment details
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		Button exit = new Button("Back");
		exit.setOnAction(this::assList);
		exit.setPrefWidth(50);
		pane.add(exit, 5, 1);

		Label lid = new Label("ID: " + assSub.id);
		pane.add(lid, 0, 1);

		Label lnm = new Label(assSub.assignment.assignmentName);
		pane.add(lnm, 2, 5);

		Label lgd = new Label(assSub.grade + "%");
		pane.add(lgd, 3, 5);

		Scene assDeets = new Scene(pane, 900, 600);
		stg.setScene(assDeets);
		stg.show();
	}

	private void assList(ActionEvent e)
	{
		stg.setScene(assSum);
		stg.show();
	}

	private void backToMenu(ActionEvent event)
	{	
		MainMenu.displayMainMenu();
	}
}
