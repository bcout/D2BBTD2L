import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Scanner;
import java.util.ArrayList;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class JdbcConnection {

  private Connection connection = null;
  private Text errorText = null;

  public JdbcConnection (Text errorText) {
    final String url = "jdbc:mysql://info1103.cs.unb.ca:3306/jdi";
    final String user = "jdi";
    final String password = "OA7Nu6OW";
    this.errorText = errorText;

    try {
      connection = DriverManager.getConnection(url,user,password);
    } catch (Exception e) {
      errorText.setText("Couldn't open a connection: (%s)");
      errorText.setFill(Color.RED);
    }
  }

  public int handleAcceptStudent(String studentName, String studentEmail, double studentGpa) {
    try {
      String query = "{CALL AcceptStudent(?,?,?)}";
      CallableStatement statement = connection.prepareCall(query);
      statement.setString(1,studentName);
      statement.setString(2,studentEmail);
      statement.setDouble(3,studentGpa);
      statement.executeQuery();
      return statement.getUpdateCount();
    } catch (SQLException e) {
      errorText.setText("Calling procedure failed. ");
      errorText.setFill(Color.RED);
    }
    return 0;
  }

  public ArrayList<ResultsRow> handleStudentTranscript(int studentId) {
    ArrayList<ResultsRow> resultRows = new ArrayList<ResultsRow>();
    try {
      String query = "{CALL studentTranscript(?)}";
      CallableStatement statement = connection.prepareCall(query);
      statement.setInt(1,studentId);
      ResultSet results = null;
      results = statement.executeQuery();

      while(results.next()) {
        String grade = results.getString(8);
        String course = results.getString(11);
        if(grade != null && course != null) {
          ResultsRow row = new ResultsRow(grade,course);
          resultRows.add(row);
        }
      }
    } catch (SQLException e) {
      errorText.setText("Calling procedure failed.");
      errorText.setFill(Color.RED);
    }

    return resultRows;
  }


  public void closeConnection() {
    try {
      connection.close();
    } catch (Exception e) {
      System.err.printf("Couldn't close connection: (%s)", e.getMessage());
    }
  }
}
