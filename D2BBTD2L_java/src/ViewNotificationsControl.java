/**
* @author Stephen Downward 3636303
*/

public class ViewNotificationsControl 
{
	private DataManager dm;

    public ViewNotificationsControl(DataManager dm)
    {
        this.dm = dm;
    }

	public Notification[] getNotifications()
    {
        return dm.getNotifications();
	}
}
