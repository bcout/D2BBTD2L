import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author sdownwar
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ViewMarksUI
{
	private Scene assSum; //Assignment summary
	private ViewMarksControl ctrl;

	public ViewMarksUI()
	{
		ctrl = new ViewMarksControl();
	}

	private Scene initScene()
	{
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);

		//Listview
		ListView<Assignment> lv = new ListView<Assignment>();
		for(Assignment a : ctrl.getAssignments())
		{
			lv.getItems().add(a);
		}
		pane.add(lv, 5, 1);
		
		//Back btn
		Button btnExit = new Button("Back");
		btnExit.setOnAction(this::backToMenu);
		btnExit.setPrefWidth(50);
		pane.add(btnExit, 5, 1);
		
		assSum = new Scene(pane, 900, 600);
		return assSum;
	}

	public void display(Stage stg)
	{
		stg.setScene(initScene());
		stg.show();
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clickcourseassignments() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displaySummarizedAssignments()
	{
		
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clicksanassignment() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayAssignment() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	private void backToMenu(ActionEvent event)
	{
		MainMenu mm = new MainMenu();
		mm.resetToMainMenu();
	}
}
