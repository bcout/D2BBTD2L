import java.util.ArrayList;
import java.util.LinkedHashSet;



public class addCourseRegistrationInfoControl {
	
	private DataManager dataManager;

	
	public addCourseRegistrationInfoControl(DataManager dm) {
		dataManager = dm;
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/

	public int submitCourseRegistrationInfo(ArrayList<CourseRegistration> cr) {
		if (cr.size() == 0) {
			return 2;
		}
		LinkedHashSet<CourseRegistration> hs = new LinkedHashSet<>(cr);
		ArrayList<CourseRegistration> noDups = new ArrayList<>(hs);
		
		return dataManager.addCourseRegistrationInfo(noDups);
	}
}
