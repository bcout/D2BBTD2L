import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author bcouturi
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class addCourseRegistrationInfoUI {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private addCourseRegistrationInfoControl control;

	public addCourseRegistrationInfoUI(addCourseRegistrationInfoControl control) {
		this.control = control;
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayCourseRegistrationForm() {
		Scanner sc = new Scanner(System.in);
		ArrayList<CourseRegistration> cr = new ArrayList<CourseRegistration>();
		System.out.println("'0' to stop");
		while (true) {
			System.out.println("Enter stdntID:");
			int stdtID = sc.nextInt();
			System.out.println("Enter courseOffereingID:");
			int offID = sc.nextInt();
			if (stdtID == 0 || offID == 0) {
				break;
			}
			cr.add(new CourseRegistration(stdtID,offID));
		}

		if (enterCourseRegistrationInfo(cr)) {
			displayConfirmationMessage();
		} else {
			displayFailureMessage();
		}
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
		
	public boolean enterCourseRegistrationInfo(ArrayList<CourseRegistration> cr) {
		return control.submitCourseRegistrationInfo(cr);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void displayConfirmationMessage() {
		System.out.println("Success");
	}
	
	public void displayFailureMessage() {
		System.out.println("Failure");
	}
}
