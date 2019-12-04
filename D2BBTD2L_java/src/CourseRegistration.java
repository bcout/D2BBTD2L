import java.util.Set;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
public class CourseRegistration implements Comparable<CourseRegistration> {

	private int accountIdstudent;
	
	private int courseOfferingId; 
	
	private String username;
	
	private String courseNumber;
	
	private int term;
	
	private int year;
	
	public CourseRegistration(int stdntID, int offID, String username, String courseNumber, int term, int year) {
		accountIdstudent = stdntID;
		courseOfferingId = offID;
		this.username = username;
		this.courseNumber = courseNumber;
		this.term = term;
		this.year = year;
	}

	public int getAccountIdstudent() {
		return accountIdstudent;
	}
	
	public int getCourseOfferingId() {
		return courseOfferingId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	
	public int getTerm() {
		return term;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getTerm() {
		return term;
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
