
public class ViewAssignmentMain {
	public static void main(String[] args) {
		dm = new DataManager();
		control = new ViewAssignmentControl(dm);
		ui = new ViewAssignmentUI(control);
		
		ui.displaySelectionForm();
	}
}
