import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
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
  
  String debug = new String();
  
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
  private ComboBox termInput;
  // year input
  private Label yearInputLbl;
  private ComboBox yearInput;
  // professor input
  private Label professorInputLbl;
  private ComboBox professorInput;
  // TA input
  private Label TA_InputLbl;
  private ComboBox TA_Input;
  // extra
  private Button backButton;
  private Button addCourseButton;
  private Button submitButton;
  private Label confirmationLabel;

  // Layout
  VBox vLayout;
  double hSpacing = 5;
  Stage stage = null;

  // creates all the necessary scene components
  private void initSceneComponents() {
    // Layout
    vLayout = new VBox(10);

    // course number input
    courseNumberLbl = new Label("Course Number");
    courseNumber = new TextField();
    vLayout.getChildren().add(new HBox(hSpacing,courseNumberLbl,courseNumber));
    // room number input
    roomNumberLbl = new Label("Room Number");
    roomNumber = new TextField();
    vLayout.getChildren().add(new HBox(hSpacing,roomNumberLbl,roomNumber));
    // course length input
    courseLengthLbl = new Label("Course Length (min)");
    courseLength = new TextField("50");
    vLayout.getChildren().add(new HBox(hSpacing,courseLengthLbl,courseLength));
    // term input
    termInputLbl = new Label("Available Term");
    String[] availableTerms = control.getAvailableTerms();
    termInput = new
      ComboBox(FXCollections.observableArrayList(availableTerms));
    vLayout.getChildren().add(new HBox(hSpacing,termInputLbl,termInput));
    // year input
    yearInputLbl = new Label("Available Year");
    Integer[] availableYears = control.getAvailableYears();
    yearInput = new
      ComboBox(FXCollections.observableArrayList(availableYears));
    vLayout.getChildren().add(new HBox(hSpacing,yearInputLbl,yearInput));
    // professor input
    String[] availableProfessors =
    control.getAvailableProfessors();
    professorInputLbl = new Label("Professor");
    professorInput = new
      ComboBox(FXCollections.observableArrayList(availableProfessors));
    vLayout.getChildren().add(new HBox(hSpacing, professorInputLbl,
          professorInput));
    // TA input
    String[] availableTAs = control.getAvailableTAs();
    TA_InputLbl = new Label("TA");
    TA_Input = new
      ComboBox(FXCollections.observableArrayList(availableTAs));
    vLayout.getChildren().add(new HBox(hSpacing,TA_InputLbl,TA_Input));
    // extra
    backButton = new Button("Main Menu");
    backButton.setOnAction(this::processBackButton);
    addCourseButton = new Button("Create New Course");
    addCourseButton.setOnAction(this::processAddCourseButton);
    submitButton = new Button("Submit");
    submitButton.setOnAction(this::processSubmitButton);
    confirmationLabel = new Label("Enter details");
    vLayout.getChildren().add(new HBox(hSpacing,backButton, submitButton,
          addCourseButton));
    vLayout.getChildren().add(confirmationLabel);
  }

  private String parseCourseNumber() {
   String courseNum = courseNumber.getText();

   debug += courseNum + "  ";

   if(courseNum == null || courseNum.compareTo("")==0) {
     confirmationLabel.setText("A year must be provided");
     return null;
   }
   return courseNum;
  }

  private String parseRoomNumber() {
    String roomNum = roomNumber.getText();

    debug += roomNum + "  ";

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
      debug += courseLen + "   ";
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
    int termNum = 0;
    String[] availableTerms = control.getAvailableTerms().clone();

    for(String term : availableTerms) {
      if(termName.compareTo(term)!=0) {
        termNum++; 
      } else {
        return termNum;
      }
    }

    confirmationLabel.setText("The requested term is not available"); 
    return 0;
  }

  private int parseYear() {
    int yearIn = 0;

    try {
      yearIn = Integer.parseInt((String)(yearInput.getValue()));
      for(int year : control.getAvailableYears()) {
        if(yearIn == year) {
          return year; 
        }
      }
      confirmationLabel.setText("The requested year is not available");
    } catch (Exception e) {
      confirmationLabel.setText("The requested year could not be read");
    }
    return 0;
  }

  private String parseProfessor() {
    String profIn = (String)(professorInput.getValue());

    debug+= "professor: " + profIn + "   ";

    // or getAvailableTAs
    String[] availableProfessors = control.getHardCodedProfessors().clone(); 

    for(String professor : availableProfessors) {
      if(profIn.compareTo(professor)==0) {
        return professor; 
      }
    }
    confirmationLabel.setText("The requested professor is not available");
    return null; 
  }

  private String parseTA() {
    String taIn = (String)(TA_Input.getValue());

    debug += taIn + "  ";
    String[] availableTAs = control.getHardCodedTAs().clone();

    for(String TA : control.getAvailableTAs()) {
      if(taIn.compareTo(TA)==0) {
        return TA;
      }
    }
    confirmationLabel.setText("The requested TA is not available");
    return null;
  }

  private void processSubmitButton(ActionEvent event) {
  //  if(parseCourseNumber() != null && parseRoomNumber() != null &&
  //     parseLength() != 0 && parseTerm() != 0 && parseYear() != 0
  //     && parseProfessor() != null && parseTA() != null ) {
  //    confirmationLabel.setText("button has been pressed - everything parsed");
  //  }
  //  System.out.println(debug);
  //  confirmationLabel.setText("fail");
  //  // parse methods will update confirmation label upon failure
  }

  private void processBackButton(ActionEvent event) {
    confirmationLabel.setText("this should go to the main scene");
  }

  private void processAddCourseButton(ActionEvent event) {
    confirmationLabel.setText("This should go to the add course scene");
  }

  private Scene initScene() {
    //initSceneComponents();
    return new Scene(vLayout); 
  }

  public void displayAddCourseOfferingInfoForm(Stage stage) {
    this.stage = stage;
    stage.setScene(initScene());
    stage.show();
  }
}
