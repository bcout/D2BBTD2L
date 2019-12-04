import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.SQLException;
import java.util.Scanner;

import com.oracle.tools.packager.IOUtils;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ViewAssignmentUI {

	private Scene postScene;
	private FlowPane viewPane;
	private Button downBtn;
	private Button btnExit;
	private Stage primaryStage;
	private ViewAssignmentControl control;
	private ComboBox assignmentList;
	private Label succ;
	
	public ViewAssignmentUI() {
		control = new ViewAssignmentControl(MainMenu.getDataManager());
	}
	

	
	
	public void requestDownloadFile(String assignmentID) {
		control.downloadFile(assignmentID);
		
	}
	
	public void displayPostAssignmentForm(Stage stg) { 
		stg.setScene(initPostAssignment());
		stg.show();
		
	}
	
	public void loadPostAssignmentScene() {
		btnExit = new Button("Exit");
		downBtn = new Button("Download");
		succ = new Label("All files will go directly to your Downloads file.");

		ArrayList<String> assignments = control.getAssignmentNames();
		assignmentList = new ComboBox();
		assignmentList.getItems().addAll(assignments.toArray());

		viewPane= new FlowPane(Orientation.VERTICAL);

		
		btnExit.setOnAction(this::processExitButtonPress);
		downBtn.setOnAction(this::processDownButtonPress);
	}
	
	
	public void processExitButtonPress(ActionEvent Event) {
		if (MainMenu.getUserAccount().getAccountType() == 1)
		{
			StudentMainMenu smm = new StudentMainMenu();
			smm.resetToMainMenu();
		}
		else if (MainMenu.getUserAccount().getAccountType() == 3)
		{
			TAMainMenu tmm = new TAMainMenu();
			tmm.resetToMainMenu();
		}
		else if (MainMenu.getUserAccount().getAccountType() == 4)
		{
			ProfMainMenu pmm = new ProfMainMenu();
			pmm.resetToMainMenu();
		}
	}
	
	public void processDownButtonPress(ActionEvent Event) {
		String assignName = (String) assignmentList.getValue();
		
		control.downloadFile(assignName);
		
		succ.setText("Success!");
		
		
	}
	
	
	public Scene initPostAssignment() {
		loadPostAssignmentScene();
		
		viewPane.getChildren().add(btnExit);
		viewPane.getChildren().add(assignmentList);
		viewPane.getChildren().add(succ);
		
		viewPane.getChildren().add(downBtn);
		
		viewPane.setVgap(10);
		viewPane.setAlignment(Pos.CENTER);
		viewPane.setColumnHalignment(HPos.CENTER); 
        	viewPane.setRowValignment(VPos.CENTER); 
        	viewPane.setStyle("-fx-background-color: yellow;");
        
        
        
		return postScene = new Scene(viewPane, 900, 600);
		
	}



}
