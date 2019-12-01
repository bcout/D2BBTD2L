import java.sql.*;

public class DbTest {
	public static void main(String[] args) {
		int courseId = 1;
		String roomNum = "h200";
		double courseLength = 50;
		int term = 1;
		int year = 2019;
		int profId = 31;
		int TA_id = 32;
		boolean[] dow = new boolean[] {false,true,false,false,true};
		String time = "12:30";
		
		CourseOfferingInfoObject offering = new CourseOfferingInfoObject(courseId, roomNum,
                  courseLength, term, year, profId, TA_id, dow, time);
		
		DataManager dm = new DataManager();
		
		try {
		dm.addCourseOfferingInfo(offering);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
