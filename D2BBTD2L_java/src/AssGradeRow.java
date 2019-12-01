import javafx.scene.control.RadioButton;

// DataModel for table in enterMarkUI
public class AssGradeRow {
  private String assName;
  private Double assGrade;
  private Boolean submitted;
  private RadioButton radioButton;

  public AssGradeRow(String assName, double assGrade,
                            boolean submitted) {
    this.assName = assName;
    this.assGrade = assGrade;
    this.submitted = submitted;
    this.radioButton = new RadioButton();
  }

  public AssGradeRow(String assName, Double assGrad,
                            Boolean submitted) {
    this.assName = assName;
    this.assGrade = assGrade;
    this.submitted = submitted;
    this.radioButton = new RadioButton();
  }

  public String getAssName() {
    return assName;
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
    this.assGrade = grade;
  }

  public void setAssGrade(Double grade) {
    this.assGrade = grade;
  }

  public RadioButton getRadioButton() {
    return this.radioButton;
  }
}
