
/**
 * 
 */

//import static CourseOfferingInfoObject.*;

public class addCourseOfferingInfoControl {
  private DataManager dataManager;

  public addCourseOfferingInfoControl() {
    this.dataManager = MainMenu.getDataManager();
  }

  public addCourseOfferingInfoControl(DataManager dm) {
    this.dataManager = dm; 
  }

  public String[] getAvailableTerms() {
    return new String[]{"Fall","Winter","SummerA","SummerB"};
  }

  public String[] getAvailableTAs() {
    return new String[]{"This","is","hardcoded"};
  }

  public String[] getAvailableProfessors() {
    return new String[]{"This","is","hardcoded"};
  }

  public Integer[] getAvailableYears() {
    return new Integer[]{2019,2020,2021,2022};
  }

  public Boolean addCourseOfferingInfo(CourseOfferingInfoObject offeringInfo) {
    return true;
  }
}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private DataManager dataManager;


}
