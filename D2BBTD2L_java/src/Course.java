
// @author justend29


public class Course {
	private int courseId;
	private String courseNum;
	private String courseDescription;
	
	public Course(int id, String courseNum, String courseDesc) {
		this.courseId = id;
		this.courseNum = courseNum;
		this.courseDescription = courseDesc;
	}
	
	public int getCourseId() {
	  return this.courseId;
	}
	
	public String getCourseNum() {
		return this.courseNum;
	}
	
	public String getCourseDescription() {
		return this.courseDescription;
	}
	
	public String toString() {
	  return this.getCourseNum();
	}
}