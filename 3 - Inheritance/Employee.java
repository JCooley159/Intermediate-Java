/**Class: Employee
 * @author Jeremy Cooley
 * @version 1.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: May 26, 2018
 */
public abstract class Employee implements Comparable<Employee> {

	protected String firstName;
	protected String lastName;
	protected double paycheck;
	
	
	public Employee() {}
	
	public Employee(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Employee(String firstName, String lastName, double paycheck) {
		setFirstName(firstName);
		setLastName(lastName);
		setPaycheck(paycheck);
	}
	
	
	
	/**Method: getFirstName()
	 * 
	 * @return firstName - the String first name of the employee object.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**Method: setFirstName()
	 * 
	 * @param firstName - the String first name of the object to be set. 
	 * @throws an InvalidEmployeeException error if the name is not between 1 and 16 chars.
	 */
	public void setFirstName(String firstName) throws InvalidEmployeeException {
		if (firstName.length() >= 1 && firstName.length() <= 16) {
			this.firstName = firstName;   
		} else if (firstName.isEmpty()) {
			throw new InvalidEmployeeException("You must enter a first name.");
		} else if (firstName.length() > 16) {
			throw new InvalidEmployeeException("" + firstName + " is not a valid first name.");
		}		
	}
	
	
	/**Method: getLastName()
	 * 
	 * @return lastName - the String last name of the employee object.
	 */
	public String getLastName() {
		return lastName;
	}
	/**Method: setLastName()
	 * 
	 * @param lastName - the String last name of the object to be set. 
	 * @throws an InvalidEmployeeException if the name is not between 1 and 21 chars.
	 */
	public void setLastName(String lastName) throws InvalidEmployeeException {
		if (lastName.length() >= 1 && lastName.length() <= 21) {
			this.lastName = lastName;   
		} else if (lastName.isEmpty()) {
			throw new InvalidEmployeeException("You must enter a last name.");
		} else if (lastName.length() > 21) {
			throw new InvalidEmployeeException("" + lastName + " is not a valid last name.");
		}		
	}
	
	
	/**Method: getPaycheck()
	 * 
	 * @return paycheck - the double value of the employee's paycheck.
	 */
	public double getPaycheck() {
		return paycheck;		
	}
	/**Method: setPaycheck()
	 * 
	 * @param paycheck - the double value of the employee's paycheck to be set.
	 * @throws InvalidEmployeeException - thrown if the value is negative or greater than 12,500
	 */
	public void setPaycheck(Double paycheck) throws IllegalArgumentException {
		if (paycheck >= 0 && paycheck <= 12500) {
			this.paycheck = paycheck;   
		} else if (paycheck < 0) {
			throw new InvalidEmployeeException("You must enter a paycheck that is not negative.");
		} else if (paycheck > 12500) {
			throw new InvalidEmployeeException("You must enter a paycheck below $12,500.");
		}
		
	}
	
	@Override
	public String toString() {
		String nameAndStub = "" + getFirstName() + " " + getLastName() + ", paycheck: ";
		String roundedPaycheck = String.format("%.2f", getPaycheck());
		return nameAndStub + "" + roundedPaycheck;
	}

	
	public  int compareTo(Employee emp) {
		return firstName.compareTo(emp.getFirstName());
	}
	
	
	public abstract double calculatePaycheck();
	
}
