 /* @author justend29
 */
public class CourseOfferingInfoObject {
  private int offeringId;
  private int courseId;
  private String courseNum;
  private String roomNumber;
  private double courseLength; // in minutes
  private int term; // 1 - 4
  private int year;
  private int professorId;
  private int TA_id;
  private boolean[] daysOfWeek = new boolean[]{false,false,false,false,false};
  private String time;

  public CourseOfferingInfoObject(int courseId, String roomNum,
                                  double courseLength, int term, int year,
                                  int profId, int TA_id,
                                  boolean[] dow, String time) {
    this.courseId = courseId;
    this.roomNumber = roomNum;
    this.courseLength = courseLength;
    this.term = term;
    this.year = year;
    this.professorId = profId;
    this.TA_id = TA_id;
    this.daysOfWeek = dow;
    this.time = time;
    this.courseNum = null;
  }
  
  public CourseOfferingInfoObject(int courseId, String courseNum, int term, int year) {
	  this.courseId = courseId;
	  this.roomNumber = null;
	  this.courseLength = 0;
	  this.term = term;
	  this.year = year;
	  this.professorId = 0;
	  this.TA_id = 0;
	  this.daysOfWeek = null;
	  this.time = null;
	  this.courseNum = courseNum;
  }
  
  
  public String toString() {
	  String termName = "N/A";
	  if(term == 0) {
		  termName = "Fall";
	  } else if (term == 1) {
		  termName = "Winter";
	  } else if (term == 2) {
		  termName = "SummerA";
	  } else if (term == 3) {
		  termName = "SummerB";
	  }
	  return courseNum + " Term: " + termName + " " + year + " ID:" + courseId;
  }

  public int getCourseId() {
    return courseId;
  }
  public String getRoomNumber() {
    return roomNumber;
  }
  public double getCourseLength() {
    return courseLength;
  }
  public int getTerm() {
    return term;
  }
  public int getYear() {
    return year;
  }
  public int getProfessorId() {
    return professorId;
  }
  public int getTaId() {
    return TA_id;
  }
  public boolean[] getDOW() {
    return daysOfWeek;
  }
  public String getTime() {
    return time; 
  }
  public String getCourseNum() {
	  return courseNum;
  }
  public int getOfferingId() {
	  return offeringId;
  }

}
