
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author justend29
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class enterMarkControl {
	private DataManager dataManager;

  public enterMarkControl() {
    dataManager = MainMenu.getDataManager(); 
  }

  public String[] getAvailableStudents() {
    return new String[]{"these", "are", "hardcoded", "students"}; 
  }

  public AssGradeRow[] getAssignmentGradeRows() {
    return new AssGradeRow[]{new AssGradeRow("assignment 5",80,true),
                             new AssGradeRow("assignment 2",null,false),
                             new AssGradeRow("lab assignment",null,true)};
  }

	public void addMark() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}
