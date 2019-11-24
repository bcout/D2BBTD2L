import java.util.ArrayList;


public class addCourseRegistrationInfoControl {

	private DataManager dataManager;

	
	public addCourseRegistrationInfoControl(DataManager dm) {
		dataManager = dm;
	}
	public void submitCourseRegistrationInfoArrayListCourseRegistrationObject() {
		// begin-user-code
		// TODO Auto-generated method stub
	}
		// end-user-code
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean submitCourseRegistrationInfo(ArrayList<CourseRegistration> cr) {
		if (cr.size() == 0) {
			return false;
		}
		return dataManager.addCourseRegistrationInfo(cr);
	}
}
