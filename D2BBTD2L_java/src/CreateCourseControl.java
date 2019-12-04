import java.sql.SQLException;

public class CreateCourseControl 
{
	private DataManager dm;
	
	public CreateCourseControl()
	{
		dm = MainMenu.getDataManager();
	}
	
	public boolean handleCreateCourse(String courseNumber, String courseDescription)
	{
		boolean success = false;
		
		try
		{
			success = dm.createCourse(courseNumber, courseDescription);
		}
		catch (SQLException e)
		{
			
		}
		
		return success;
	}
}
