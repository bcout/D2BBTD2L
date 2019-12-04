 /* @author justend29
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CourseOfferingInfoObject {
  private int courseId;
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
}
