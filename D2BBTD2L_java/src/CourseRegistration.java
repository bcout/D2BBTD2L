import java.util.Set;


public class CourseRegistration {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/

	private int accountIdstudent;
	
	private int courseOfferingId; 
	
	public CourseRegistration(int stdntID, int offID) {
		accountIdstudent = stdntID;
		courseOfferingId = offID;
	}

	public int getAccountIdstudent() {
		return accountIdstudent;
	}
	
	public int getCourseOfferingId() {
		return courseOfferingId;
	}
	
	//////////////////////////////////////////
	//Following properties may not be needed//
	//////////////////////////////////////////
	
	private Set<CourseOfferingInfo> courseOfferingInfo;

	private CourseOfferingInfo course;

	private StudentAccount userAccount;

	private Set<Account> account;

	public void sqlinsert() {

	}
}
