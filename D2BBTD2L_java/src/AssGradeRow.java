import javafx.scene.control.RadioButton;

// DataModel for table in enterMarkUI
public class AssGradeRow implements Cloneable {
  private String assName;
  private Integer assGrade = 0;
  private Boolean submitted;
  private Integer assSubId;
  private RadioButton radioButton;



  public AssGradeRow(String assName, Integer assGrade,
                            Boolean submitted, Integer assId) {
    this.assName = assName;
    this.assGrade = assGrade;
    this.submitted = submitted;
    this.assSubId = assId;
    this.radioButton = new RadioButton();
  }

  public String getAssName() {
    return assName;
  }
  
  public Object clone() throws
  CloneNotSupportedException 
  { 
	  return super.clone(); 
  } 

  public String getAssGrade() {
    if(assGrade == null || assGrade < 0) {
      return "0";
    }
    return Double.toString(assGrade);
  }
  
  public int getAssGradeInt() {
	    if(assGrade == null || assGrade < 0) {
	      return 0;
	    }
	    return assGrade;
	  }

  public String getAssGrade() {
    if(assGrade == null || assGrade < 0) {
      return "N/A";
    }
    return Double.toString(assGrade);
  }

  public Boolean getSubmitted() {
    return submitted;
  }

  public void setAssGrade(double grade) {
    this.assGrade = (int)grade;
  }

  public RadioButton getRadioButton() {
    return this.radioButton;
  }
  
  public int getAssSubId() {
    return this.assSubId;
  }
}
