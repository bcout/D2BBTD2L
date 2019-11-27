/**
* @author Stephen Downward 3636303
*/
public class PostNotificationControl {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private DataManager dm;
    
    public PostNotificationControl(DataManager d)
    {
        dm = d;
    }

	public void postNotification(Notification n, CourseOfferingInfo c)
    {
        dm.postNotification(n, c);
	}
}
