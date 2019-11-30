import java.util.Set;


public class CourseRegistration {

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
