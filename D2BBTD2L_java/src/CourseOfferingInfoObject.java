 /* @author justend29
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CourseOfferingInfoObject {
  private String courseNumber;
  private String roomNumber;
  private double courseLength; // in minutes
  private int term; // 1 - 4
  private int year;
  private String professorName;
  private String TA_Name;
  private boolean[] daysOfWeek = new boolean[]{false,false,false,false,false};
  private String time;

  public CourseOfferingInfoObject(String courseNum, String roomNum,
                                  double courseLength, int term, int year,
                                  String profName, String TA_Name,
                                  boolean[] dow, String time) {
    this.courseNumber = courseNum;
    this.roomNumber = roomNum;
    this.courseLength = courseLength;
    this.term = term;
    this.year = year;
    this.professorName = profName;
    this.TA_Name = TA_Name;
    this.daysOfWeek = dow;
  }

  public String getCourseNumber() {
    return courseNumber;
  }
  public String getRoomNumber() {
    return roomNumber;
  }
  public double getCourseLenght() {
    return courseLength;
  }
  public int getTerm() {
    return term;
  }
  public String getProfessorName() {
    return professorName;
  }
  public String getTaName() {
    return TA_Name;
  }
  public boolean[] getDOW() {
    return daysOfWeek;
  }
}
