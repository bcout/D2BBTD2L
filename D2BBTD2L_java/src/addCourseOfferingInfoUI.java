import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
/**
 * 
 */

//import static CourseOfferingInfoObject.*;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author justend29
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class addCourseOfferingInfoUI {
  
  
  public addCourseOfferingInfoUI() {
    control = new addCourseOfferingInfoControl();
  }

  public addCourseOfferingInfoUI(DataManager dm) {
    control = new addCourseOfferingInfoControl(dm);
  }

  /** 
   * <!-- begin-UML-doc -->
   * <!-- end-UML-doc -->
   * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
   */
  private addCourseOfferingInfoControl control;
  private CourseOfferingInfoObject courseOffering;

  // UI Elements
  // course number
  private Label courseNumberLbl;
  private TextField courseNumber;
  // room number
  private Label roomNumberLbl;
  private TextField roomNumber;
  // course length input
  private Label courseLengthLbl;
  private TextField courseLength;
  // term input
  private Label termInputLbl;
  private ComboBox<String> termInput;
  // year input
  private Label yearInputLbl;
  private ComboBox<Integer> yearInput;
  // professor input
  private Label professorInputLbl;
  private ComboBox<String> professorInput;
  // TA input
  private Label TA_InputLbl;
  private ComboBox<String> TA_Input;
  // days of the week
  private CheckBox[] daysOfWeekBoxes;
  private String[] daysOfWeekNames = 
    new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
  // Time of the class
  private Label timeLabel;
  private ComboBox<String> timeInput;

  // extra
  private Button backButton;
  private Button addCourseButton;
  private Button submitButton;
  private Label confirmationLabel;

  // Layout
  GridPane pane = null;
  final double vGap = 10;
  final double labelWidth = 200;
  Stage stage = null;

  // creates all the necessary scene components
  private void initSceneComponents() {
    
    //Layout
    pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setVgap(vGap);

    // course number input
    courseNumberLbl = new Label("Course Number");
    courseNumberLbl.setPrefWidth(labelWidth);
    courseNumber = new TextField();
    pane.add(courseNumberLbl,0,0);
    pane.add(courseNumber,1,0);
    // room number input
    roomNumberLbl = new Label("Room Number");
    roomNumberLbl.setPrefWidth(labelWidth);
    roomNumber = new TextField();
    pane.add(roomNumberLbl, 0, 1);
    pane.add(roomNumber,1,1);
    // course length input
    courseLengthLbl = new Label("Course Length (min)");
    courseLengthLbl.setPrefWidth(labelWidth);
    courseLength = new TextField("50");
    pane.add(courseLengthLbl,0,2);
    pane.add(courseLength,1,2);
    // term input
    termInputLbl = new Label("Available Term");
    termInputLbl.setPrefWidth(labelWidth);
    String[] availableTerms = control.getAvailableTerms();
    termInput = new
      ComboBox<String>(FXCollections.observableArrayList(availableTerms));
    pane.add(termInputLbl,0,3);
    pane.add(termInput,1,3);
    // year input
    yearInputLbl = new Label("Available Year");
    yearInputLbl.setPrefWidth(labelWidth);
    Integer[] availableYears = control.getAvailableYears();
    yearInput = new
      ComboBox<Integer>(FXCollections.observableArrayList(availableYears));
    pane.add(yearInputLbl,0,4);
    pane.add(yearInput,1,4);
    // professor input
    String[] availableProfessors =
    control.getHardCodedProfessors();
    professorInputLbl = new Label("Professor");
    professorInputLbl.setPrefWidth(labelWidth);
    professorInput = new
      ComboBox<String>(FXCollections.observableArrayList(availableProfessors));
    pane.add(professorInputLbl,0,5);
    pane.add(professorInput,1,5);
    // TA input
    String[] availableTAs = control.getHardCodedTAs();
    TA_InputLbl = new Label("TA");
    TA_InputLbl.setPrefWidth(labelWidth);
    TA_Input = new
      ComboBox<String>(FXCollections.observableArrayList(availableTAs));
    pane.add(TA_InputLbl,0,6);
    pane.add(TA_Input,1,6);
    // Time input
    timeLabel = new Label("Class Time");
    String[] availableTimes = control.getAvailableTimes();
    timeInput = new ComboBox(FXCollections.observableArrayList(availableTimes));
    pane.add(timeLabel, 0, 7);
    pane.add(timeInput, 1, 7);
    // Days of the week
    HBox dowHbox = new HBox(4);
    daysOfWeekBoxes = new CheckBox[5];
    for(int i=0; i<5; ++i) {
      daysOfWeekBoxes[i] = new CheckBox(daysOfWeekNames[i]);
      daysOfWeekBoxes[i].setIndeterminate(false);
      dowHbox.getChildren().add(daysOfWeekBoxes[i]);
    }
    pane.add(dowHbox,0,8,2,1);
    // extra
    backButton = new Button("Main Menu");
    backButton.setOnAction(this::processBackButton);
    addCourseButton = new Button("Create New Course");
    addCourseButton.setOnAction(this::processAddCourseButton);
    submitButton = new Button("Submit");
    submitButton.setOnAction(this::processSubmitButton);
    confirmationLabel = new Label("Enter details");
    confirmationLabel.setPrefWidth(500);
    pane.add(addCourseButton, 0, 9);
    pane.add(backButton, 1, 9);
    pane.add(submitButton, 0, 10, 2, 1);
    pane.add(confirmationLabel, 0, 11, 2, 1);
  }

  private String parseCourseNumber() {
   String courseNum = courseNumber.getText();

   if(courseNum == null || courseNum.compareTo("")==0) {
     confirmationLabel.setText("A year must be provided");
     return null;
   }
   return courseNum;
  }

  private String parseRoomNumber() {
    String roomNum = roomNumber.getText();

    if(roomNum == null || roomNum.compareTo("")==0) {
      confirmationLabel.setText("A room number must be provided");  
      return null;
    }
    return roomNum; 
  }

  private double parseLength() {
    double courseLen = 0;
    try {
      courseLen = Double.parseDouble(courseLength.getText());
    } catch (Exception e) {
      confirmationLabel.setText("The course length could not be read"); 
      return 0;
    }

    if(courseLen <= 0) {
      confirmationLabel.setText("A positive course length must be"
      + "provided"); 
      return 0;
    }
    return courseLen;
  }

  private int parseTerm() {
    String termName = (String)(termInput.getValue());
    int termNum = 1;
    String[] availableTerms = control.getAvailableTerms().clone();

    for(String term : availableTerms) {
      if(termName.equals(term)) {
        termNum++; 
      } else {
        return termNum;
      }
    }

    confirmationLabel.setText("The requested term is not available"); 
    return 0;
  }

  private int parseYear() {
    Integer yearIn = 0;
    try {
      yearIn = yearInput.getValue(); 
      // getAvailableYears returns Integer[]
      Integer[] availableYears = control.getAvailableYears();
      for(Integer year : availableYears) {
          return year.intValue(); 
        }
      confirmationLabel.setText("The requested year is not available");
    } catch (NumberFormatException e) {
      confirmationLabel.setText("The requested year could not be read");
    }
    return 0;
  }

  private String parseProfessor() {
    String profIn = (String)(professorInput.getValue());
    System.out.println("Professor inputted: " + profIn);

    // or getAvailableTAs
    String[] availableProfessors = control.getHardCodedProfessors().clone(); 
    
    for(String professor : availableProfessors) {
      System.out.println(professor);
      if(profIn.equals(professor)) {
        return professor; 
      }
    }
    confirmationLabel.setText("The requested professor is not available");
    return null; 
  }

  private String parseTA() {
    String taIn = (String)(TA_Input.getValue());
    System.out.println("TA inputted: " + taIn);

    String[] availableTAs = control.getHardCodedTAs().clone();

    for(String TA : availableTAs) {
      System.out.println(TA);
      if(taIn.equals(TA)) {
        return TA;
      }
    }
    confirmationLabel.setText("The requested TA is not available");
    return null;
  }

  private boolean[] parseDow() {
    boolean[] dow = new boolean[]{false,false,false,false,false};
    for(int i=0; i<5; ++i) {
      dow[i] = daysOfWeekBoxes[i].isSelected();
    }
    return dow;
  }

  private String parseTime() {
    String inputTime = timeInput.getValue();
    if(inputTime != null && !inputTime.equals("")) {
     return inputTime; 
    }
    return null;
  }

  private void processSubmitButton(ActionEvent event) {
    String courseNum = parseCourseNumber();
    String roomNum = parseRoomNumber();
    double courseLength = parseLength();
    int term = parseTerm();
    int year = parseYear();
    String professor = parseProfessor();
    String TA = parseTA();
    boolean[] dow = parseDow();
    String time = parseTime();

    System.out.println(courseNum + roomNum + term);
    if(courseNum != null && roomNum != null &&
       courseLength != 0 && term != 0 && year != 0 &&
       professor != null && TA != null && time != null ) {
       confirmationLabel.setText("button has been pressed - everything parsed");
    } else {
      confirmationLabel.setText("fail");
      // parse methods will update confirmation label upon failure
    }
  }

  private void processBackButton(ActionEvent event) {
    confirmationLabel.setText("this should go to the main scene");
  }

  private void processAddCourseButton(ActionEvent event) {
    confirmationLabel.setText("This should go to the add course scene");
  }

  private Scene initScene() {
    initSceneComponents();
    return new Scene(pane); 
  }

  public void displayAddCourseOfferingInfoForm(Stage stage) {
    this.stage = stage;
    stage.setScene(initScene());
    stage.show();
  }
}
