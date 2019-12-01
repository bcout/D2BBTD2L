
/**
 * 
 */

import java.util.ArrayList;

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
    return dataManager.getAvailableTAs();
  }

  public String[] getHardCodedTAs() {
    return new String[]{"This","is","hardcoded"};
  }

  public String[] getAvailableProfessors() {
    return dataManager.getAvailableProfessors();
  }

  public String[] getHardCodedProfessors() {
    return new String[]{"This","is","hardcoded"};
  }

  public Integer[] getAvailableYears() {
    return new Integer[]{2019,2020,2021,2022};
  }

  public String[] getAvailableTimes() {
    ArrayList<String> times = new ArrayList<String>();
    for(int hour=8; hour<21; ++hour) {
      for(int minutes=0; minutes<=30; minutes+=30) {
        times.add(Integer.toString(hour) + ":" +
        ((minutes==0)?"00":Integer.toString(minutes))); 
      }
    }
    return times.toArray(new String[times.size()]);
  }

  public Boolean addCourseOfferingInfo(CourseOfferingInfoObject offeringInfo) {
    return true;
  }
}
