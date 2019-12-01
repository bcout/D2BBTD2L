import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import java.util.ArrayList;

 /* @author justend29 */

public class enterMarkUI {

  // javafx control
  private Stage stage;
  private TableView table;
  private Label gradeInputLbl;
  private TextField gradeInput;
  private Label studentInputLbl;
  private ComboBox<String> studentInput;
  private Button submitButton;
  private Button backButton;
  private Label confirmationLabel;
  private ArrayList<RadioButton> selectAssBtn;

  // javafx layout/grouping
  private VBox pane;
  private ToggleGroup toggleGroup;


  // non-javafx
	private enterMarkControl control;
  private final double hGap = 10;
  private final double vGap = 10;
  
  public enterMarkUI() {
    control = new enterMarkControl();  
  }

  public enterMarkUI(DataManager dm) {
    control = new enterMarkControl();
  }

	public void displayEnterMarkPage() {
	}

  private void initSceneComponents() throws Exception {
    // Layout
    pane = new VBox(vGap);
    pane.setAlignment(Pos.CENTER);
    HBox tempHbox;

    // student selection input
    studentInputLbl = new Label("Select Student");
    studentInput = new ComboBox<String>();
    studentInput.setOnAction(this::processStudentSelect);
    studentInput.getItems().addAll(control.getAvailableStudents());
    tempHbox = new HBox(hGap);
    tempHbox.setAlignment(Pos.CENTER);
    tempHbox.getChildren().addAll(studentInputLbl, studentInput);
    pane.getChildren().add(tempHbox);

    // table of assignments
    table = new TableView();
    table.setEditable(true);

    // table columns
    TableColumn<RadioButton, AssGradeRow> radioCol =
      new TableColumn<>("Select");
    radioCol.setCellValueFactory(new PropertyValueFactory<>("radioButton"));

    TableColumn<String, AssGradeRow> assNameCol = 
      new TableColumn<>("Assignment");
    assNameCol.setCellValueFactory(new PropertyValueFactory<>("assName"));

    TableColumn<Boolean, AssGradeRow> submittedCol =
      new TableColumn<>("Submitted");
    submittedCol.setCellValueFactory(new PropertyValueFactory<>("submitted"));

    TableColumn<String, AssGradeRow> gradeCol =
      new TableColumn<>("Grade");
    gradeCol.setCellValueFactory(new PropertyValueFactory<>("assGrade"));

    table.getColumns().addAll(radioCol, assNameCol, submittedCol, gradeCol);
    pane.getChildren().add(table);

    // grade input
    tempHbox = new HBox(hGap);
    gradeInputLbl = new Label("Assignment Grade: ");
    gradeInput = new TextField();
    tempHbox.setAlignment(Pos.CENTER);
    tempHbox.getChildren().addAll(gradeInputLbl, gradeInput);
    pane.getChildren().add(tempHbox);

    // extra buttons
    submitButton = new Button("Submit Mark");
    submitButton.setOnAction(this::processSubmitButton);
    backButton = new Button("Main Menu");
    backButton.setOnAction(this::processBackButton);
    tempHbox = new HBox(hGap);
    tempHbox.setAlignment(Pos.CENTER);
    tempHbox.getChildren().addAll(submitButton, backButton);
    pane.getChildren().add(tempHbox);

    // confirmation label
    confirmationLabel = new Label("Select a Student to View Assignments");
    pane.getChildren().add(confirmationLabel);
  }

  private void processSubmitButton(ActionEvent event) {
    confirmationLabel.setText("submit button pressed");
  }

  private void processBackButton(ActionEvent event) {
    confirmationLabel.setText("back button pressed");
  }

  private void processStudentSelect(ActionEvent event) {
    selectAssBtn = new ArrayList<>();
    toggleGroup = new ToggleGroup();
    AssGradeRow[] assGradeRows = control.getAssignmentGradeRows();
    table.getItems().clear();
    for(AssGradeRow assGradeRow : assGradeRows) {
      table.getItems().add(assGradeRow); 
      RadioButton currentBtn = assGradeRow.getRadioButton();
      currentBtn.setToggleGroup(toggleGroup);
      selectAssBtn.add(currentBtn);
    }
    confirmationLabel.setText("student selected");
  }

  private Scene initScene() {
    try{
      initSceneComponents();
    } catch (Exception e) {
      confirmationLabel.setText(e.getMessage());
    }
    return new Scene(pane);
  }

  public void displayEnterMarkForm(Stage stage) {
    this.stage = stage;
    stage.setScene(initScene());
    stage.show();
  }

	public void enterMarkDetails() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayEnterMarkConfirmation() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clicksentermark() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}
