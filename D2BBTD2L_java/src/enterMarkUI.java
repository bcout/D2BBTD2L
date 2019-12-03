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
  private Label courseInputLbl;
  private ComboBox<String> courseInput;
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
  private AssGradeRow[] assGradeRows;
  
  public enterMarkUI() {
    control = new enterMarkControl();  
  }

  public enterMarkUI(DataManager dm) {
    control = new enterMarkControl();
  }


  private void initSceneComponents() throws Exception {
    // Layout
    pane = new VBox(vGap);
    pane.setAlignment(Pos.CENTER);
    HBox tempHbox;

    // student selection input
    studentInputLbl = new Label("Select Student");
    studentInput = new ComboBox<String>();
    studentInput.setOnAction(this::processSelect);
    studentInput.getItems().addAll(control.getAvailableStudents());
    tempHbox = new HBox(hGap);
    tempHbox.setAlignment(Pos.CENTER);
    tempHbox.getChildren().addAll(studentInputLbl, studentInput);
    pane.getChildren().add(tempHbox);
    
    // course selection input 
    courseInputLbl = new Label("Select Course");
    courseInput = new ComboBox<String>();
    courseInput.setOnAction(this::processSelect);
    courseInput.getItems().addAll(control.getAccessibleCourseOfferingNames());
    tempHbox = new HBox(hGap);
    tempHbox.setAlignment(Pos.CENTER);
    tempHbox.getChildren().addAll(courseInputLbl, courseInput);
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
    gradeInputLbl = new Label("Assignment Grade (%): ");
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
	try {
		AssGradeRow row = (AssGradeRow)parseRadioButtons().clone();
		int assGrade = (int)parseGradeInput().doubleValue();
		row.setAssGrade(assGrade);
		control.insertAssignmentSubmissionGrade(row);
		confirmationLabel.setText("Grade has been SET");

	} catch (Exception e) {
		confirmationLabel.setText(e.getMessage());
	}
    
  }

  private void processBackButton(ActionEvent event) {
	  Account account = MainMenu.getUserAccount();
	  if(account.getAccountType() == 4) {// prof
	  	ProfMainMenu pmm = new ProfMainMenu();
      pmm.resetToMainMenu();
	  } else if(account.getAccountType() == 3) { //TA
		TAMainMenu tmm = new TAMainMenu();
		tmm.resetToMainMenu();
	  }
  }

  private void processSelect(ActionEvent event) {
	  try {
	    selectAssBtn = new ArrayList<>();
	    toggleGroup = new ToggleGroup();
	    
	    int selectedStudentId;
	    int selectedCourseOfferingId;
	    
	    if(studentInput.getValue() != null && courseInput.getValue() != null) {
		    selectedStudentId = Integer.parseInt(studentInput.getValue().split("ID: ")[1]);
		    System.out.println("Selected student id: " + selectedStudentId);
		    selectedCourseOfferingId = Integer.parseInt(courseInput.getValue().split("ID:")[1]);
		    System.out.println("Selected course id: " + selectedCourseOfferingId);
		    
		    assGradeRows = control.getAssignmentGradeRows(selectedStudentId, selectedCourseOfferingId);
		    table.getItems().clear();
		    for(AssGradeRow assGradeRow : assGradeRows) {
		      table.getItems().add(assGradeRow); 
		      RadioButton currentBtn = assGradeRow.getRadioButton();
		      currentBtn.setToggleGroup(toggleGroup);
		      selectAssBtn.add(currentBtn);
		    }
		    if(assGradeRows.length>0) confirmationLabel.setText("Selected");
		    else confirmationLabel.setText("No Assignments Available");
	    }
	  } catch (Exception e) {
		confirmationLabel.setText("No Assignments Available " + e.getMessage());
	}
  }
  
  private AssGradeRow parseRadioButtons() throws Exception { // returns assignment submission id
	  for(int i=0; i<assGradeRows.length; ++i) {
		  if(selectAssBtn.get(i).isSelected()) {
			  return assGradeRows[i];
		  }
	  }
	  throw new Exception("No Assignment Selected");
  }
  
  private Double parseGradeInput() throws Exception {
	  if(gradeInput.getText()==null) throw new Exception("Must supply a grade");
	  Double grade = Double.parseDouble(gradeInput.getText());
	  if(grade < 0 || grade > 100) 
		  throw new Exception("grade must be within 0 and 100");
	  return grade;
  }

  private Scene initScene() {
    try{
      initSceneComponents();
    } catch (Exception e) {
      confirmationLabel.setText(e.getMessage());
    }
    return new Scene(pane, 900, 600);
  }

  public void displayEnterMarkForm(Stage stage) {
    this.stage = stage;
    stage.setScene(initScene());
    stage.show();
  }

}
