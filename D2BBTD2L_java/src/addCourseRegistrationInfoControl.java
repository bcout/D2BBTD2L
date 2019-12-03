import java.util.ArrayList;
import java.util.LinkedHashSet;

public class addCourseRegistrationInfoControl {
	
	private DataManager dataManager;

	public addCourseRegistrationInfoControl(DataManager dm) {
		dataManager = dm;
	}

	public int submitCourseRegistrationInfo(ArrayList<CourseRegistration> cr) {
		if (cr.size() == 0) {
			return 2;
		}
		LinkedHashSet<CourseRegistration> hs = new LinkedHashSet<>(cr);
		ArrayList<CourseRegistration> noDups = new ArrayList<>(hs);
		
		return dataManager.addCourseRegistrationInfo(noDups);
	}
}
