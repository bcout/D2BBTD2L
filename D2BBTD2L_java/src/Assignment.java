import java.sql.Blob;
import java.util.Date;
import java.util.Set;

/**
	Assignment class
	@StephenCole19
**/
public class Assignment {

	public int assignmentId;

	public String assingnmentName;

	public Blob assignmentFile;

	public Date dueDate;

	//public Set<AssignmentSubmission> assignmentSubmission;

	public int courseOfferingId;

	//public Account account;

	    public Assignment() {}
	
	public Assignment(String name, int id, Date due)
	{
		this.name = name;
		this.id = id;
		dueDate = due;
	}

	public String toString()
	{
		return "ID: " + id + " | " + name;
	}
}
