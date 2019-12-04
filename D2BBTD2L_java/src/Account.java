public class Account 
{

	private int accountId;

	private String username;

	private String password;

	private int accountType;

	private String firstName;

	private String lastName;

	/**
	 * This constructor is not used to make a new user, it is to make an object out of an existing user. It is used by the DataManager's getAllAccounts method
	 * @param accountId The id number of the account
	 * @param username The username associated of the account
	 * @param password The password associated with the account
	 * @param accountType The integer representation of the account type
	 * @param firstName The first name of the user
	 * @param lastName The last name of the user
	 */
	public Account(int accountId, String username, String password, int accountType, String firstName, String lastName)
	{
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public Account(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 *
	 * @param type
	 */
	public void setAccountType(int type) {
		accountType = type;
	}

	/**
	 *
	 * @return
	 */
	public int getAccountId()
	{
		return accountId;
	}

	/**
	 *
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 *
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 *
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 *
	 * @return
	 */
	public int getAccountType() {
		return accountType;
	}

	/**
	 *
	 * @return
	 */
	public String getFullName()
	{
		return lastName + ", " + firstName;
	}

	/**
	 *
	 * @return
	 */
	public String getFullNameInformal()
	{
		return firstName + " " + lastName;
	}

	/**
	 *
	 */
	public String toString()
	{
		return lastName + ", " + firstName;
	}

	/**
	 *
	 * @return
	 */
	public String getFullDetails()
	{
		return accountId + ", " + username + ", " + password + ", " + accountType + ", " + firstName + ", " + lastName;
	}
}
