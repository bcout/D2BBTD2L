import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;

import javax.sql.rowset.serial.SerialBlob;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
public class uploadAssignmentControl {
	
	private DataManager dataManager;

	public uploadAssignmentControl(DataManager dm) {
		this.dataManager = dm;
	} 
	
	public String processAssingmentUpload(int assignmentId, File inputFile) {
		String out = "Your assignment was successfuly uploaded";
		Blob blobFile;
		try {
			byte[] pdfData = new byte[(int) inputFile.length()];
			DataInputStream dis = new DataInputStream(new FileInputStream(inputFile));
			dis.readFully(pdfData);
			dis.close();
			blobFile = new SerialBlob(pdfData);
			int studentId = MainMenu.getUserAccount().getAccountId();
			System.out.println(studentId);
			dataManager.uploadAssignmentSubmission(assignmentId, studentId, blobFile);
			
		} catch (FileNotFoundException e) {
			out = "Could not find file";
		} catch (IOException e) {
			out = "Error";
		} catch (SQLException e) {
			e.printStackTrace();
			out = "Your file was too large";
		}
	
		return out;
	}

	
	public boolean checkDueDateassignmentSpecifications(Assignment choice, File inputFile) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		boolean out = false;
		Date now = new Date();
		Date due = choice.getDate();
		 if(now.compareTo(due) > 0) {
	         out = false;
	      }
		 else if(now.compareTo(due) < 0) {
	         out = true;
	      } 
		 else if(now.compareTo(due) == 0) {
	         out = true;
	      }
		return out;
	}
	
	public ArrayList<Assignment> getActiveAssignments(){
		ArrayList<Assignment> assignments;
		try {
		 assignments = dataManager.getActiveAssignments();
		} catch (SQLException e) {
			assignments = new ArrayList<Assignment>();
		}
		return assignments;
	}
}