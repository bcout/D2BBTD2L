/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Stephen Downward 3636303
 */
public class Notification
{
	public String body;
	public String title;
    public String courseNum;

    public Notification(String b, String t)
    {
        body = b;
        title = t;
        courseNum = null;
    }

    public Notification(String b, String t, String c)
    {
        body = b;
        title = t;
        courseNum = c;
    }

    public String toString()
    {
        String s = courseNum + " | " + body;
        return s.length() >= 35 ? s.substring(0, 32) + "..." : s;
    }
}
