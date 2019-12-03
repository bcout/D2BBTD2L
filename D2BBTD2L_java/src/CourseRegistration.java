import java.util.Set;

public class CourseRegistration implements Comparable<CourseRegistration> {

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
	
	public int compareTo(CourseRegistration cr) {
		if (this.accountIdstudent == cr.getAccountIdstudent() &&
				this.courseOfferingId == cr.getCourseOfferingId()) {
			return 0;
		} else {
			return -1;
		}
		
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
