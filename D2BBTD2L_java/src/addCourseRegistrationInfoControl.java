import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Control class for AddCourseRegistrationInfoControl
 * @author Ben Donkin
 *
 */
public class addCourseRegistrationInfoControl {
	
	private DataManager dataManager;

	public addCourseRegistrationInfoControl() {
		dataManager = MainMenu.getDataManager();
	}
	
	public int submitCourseRegistrationInfo(ArrayList<CourseRegistration> cr) {
		if (cr.size() == 0) {
			return 2;
		}
		LinkedHashSet<CourseRegistration> hs = new LinkedHashSet<>(cr);
		ArrayList<CourseRegistration> noDups = new ArrayList<>(hs);
		
		return dataManager.addCourseRegistrationInfo(noDups);
	}

	
	public ArrayList<Account> getAllStudentAccounts() {
		return dataManager.getAllStudentAccounts();
	}
	
	public ArrayList<CourseOfferingInfoObject> getAllOfferedCourses() {
		return dataManager.getAllOfferedCourses();
	}
}
