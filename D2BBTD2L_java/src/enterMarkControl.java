
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author justend29
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */

import java.sql.*;


public class enterMarkControl {
	private DataManager dataManager;

  public enterMarkControl() {
    dataManager = MainMenu.getDataManager(); 
  }

  public enterMarkControl(DataManager dm) {
    dataManager = dm;
  }

  
  public String[] getAvailableStudents() throws SQLException { // returns names and ids
	System.out.println("In control get students");
    String[] names = dataManager.getAvailableStudentNames(); 
    Integer[] ids = dataManager.getAvailableStudentIds();
    
    String[] results = new String[names.length];
    for(int i=0; i<results.length; ++i) {
      results[i] = names[i] + " ID: " + ids[i].toString();
    }
    return results;
  }
  
  public String[] getAccessibleCourseOfferingNames() throws SQLException {
	// gets available courses for the currently logged in user
	System.out.println("in get accessible course names");  
	CourseOfferingInfoObject[] accessibleCourseOfferings = dataManager.getAccessibleCourseOfferings();
	String[] result = new String[accessibleCourseOfferings.length];
	for(int i=0; i<result.length; ++i) {
		result[i] = accessibleCourseOfferings[i].toString();
		System.out.println("Course Offering name: " + result[i]);
	}
	return result;
  }
  
  public CourseOfferingInfoObject[] getAccessibleCourseOfferings() throws SQLException {
	return dataManager.getAccessibleCourseOfferings();
  }

  public AssGradeRow[] getAssignmentGradeRows(int studentId, int courseOfferingId) throws SQLException {
    return dataManager.getAccessibleAssignments(studentId, courseOfferingId);
    //return new AssGradeRow[]{new AssGradeRow("assignment 5",80,true,6),
    //                         new AssGradeRow("assignment 2",null,false,7),
    //                         new AssGradeRow("lab assignment",null,true,8)};
  }

  public void insertAssignmentSubmissionGrade(AssGradeRow row) throws Exception {
	  dataManager.insertAssignmentSubmissionGrade(row);
  }
}
