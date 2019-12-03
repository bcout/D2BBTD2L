import java.io.File;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class uploadAssignmentUI {
	
	private Scene scene;
	private Button back;
	private Button upload;
	private File file;
	private FileChooser choose;
	private Stage primaryStage;
	private Label confirmation;
	private FlowPane postPane;
	private Label assiID;
	private TextField filePath;
	private Label click;
	private ComboBox combo;
	private ArrayList<Assignment> choices;
	
	private uploadAssignmentControl control;

	public uploadAssignmentUI() {
		control = new uploadAssignmentControl(MainMenu.getDataManager());
	}
	
	
	public void displayAssignmentUploadForm(Stage stg) {
		stg.setScene(initUploadAssignment());
		stg.show();
	}

	
	public void selectAssignmentsubmitFile() {
		
	}
	
	public void loadUploadAssignmentScene() {
		confirmation = new Label("");
		
		back = new Button("Back to Main Menu");
		combo = new ComboBox();
		choices = control.getActiveAssignments();
		for (Assignment i : choices) {
			combo.getItems().add(i);
		}
		assiID = new Label("What assignment are you submitting?");
		confirmation = new Label("Waiting...");
		upload = new Button("Upload now");
		filePath = new TextField();
		click = new Label("Click to choose a file");
		choose = new FileChooser();
		
		postPane= new FlowPane(Orientation.VERTICAL);
		
		
		
		back.setOnAction(this::processBackButtonPress);
		upload.setOnAction(this::processUploadButtonPress);
	}

	public Scene initUploadAssignment() {
		loadUploadAssignmentScene();
		
		postPane.getChildren().add(back);
		postPane.getChildren().add(assiID);
		postPane.getChildren().add(combo);
		postPane.getChildren().add(click);
		postPane.getChildren().add(filePath);
		postPane.getChildren().add(upload);
		postPane.getChildren().add(confirmation);
		postPane.setVgap(10);
		postPane.setAlignment(Pos.CENTER);
		postPane.setColumnHalignment(HPos.CENTER); 
        postPane.setRowValignment(VPos.CENTER); 
        postPane.setStyle("-fx-background-color: pink;");
        
        filePath.setOnMouseClicked(e -> {
            file = choose.showOpenDialog(primaryStage);
            filePath.setText(file.getPath());
        });
        
        scene = new Scene(postPane, 900, 600);
		return scene;
	}
	
	public void uploadAssignment(Assignment choice, File inputFile) {
		if (control.checkDueDateassignmentSpecifications(choice, inputFile)){
			String suc = control.processAssingmentUpload(choice.getAssignmentId(), inputFile);
			//if (suc == true) {
			//	confirmation.setText("Upload was successful");
			//}
			//else {
			//	confirmation.setText("Could not upload file");
			//}
			confirmation.setText(suc);
		}
		else {
			confirmation.setText("Submission past due date");
		}
		
	}
	
	public void processBackButtonPress(ActionEvent Event) {
		StudentMainMenu menu = new StudentMainMenu();
		menu.resetToMainMenu();
	}
	
	
	public void processUploadButtonPress(ActionEvent Event) {
		
		Assignment choice = (Assignment) combo.getValue();
		
		uploadAssignment(choice, file);
	}
}








