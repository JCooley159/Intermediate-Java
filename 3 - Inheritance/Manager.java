/**Class: Manager
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: May 28, 2018
 */
public class Manager extends Employee {

	
	private double annualSalary;
	
	private String department;
	
	
	public Manager(String firstName, String lastName) {
		super(firstName, lastName);		
	}

	public Manager(String firstName, String lastName, double annualSalary, String department) {
		super(firstName, lastName);
		setAnnualSalary(annualSalary);
		setDepartment(department);
	}
		
	
	
	public Manager() {
		
	}

	/**Method: getAnnualSalary()
	 * 
	 * @return annualSalary - the double salary that the Manager makes per year
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}
	/**Method: setAnnualSalary()
	 * 
	 * @param annualSalary - the double salary that the Manager makes per year
	 * @throws InvalidEmployeeException - thrown if there's an error in setting the salary
	 */
	public void setAnnualSalary(double annualSalary) throws InvalidEmployeeException {
		if (annualSalary >= 0 && annualSalary <= 250000) {
			this.annualSalary = annualSalary;   
		} else if (annualSalary < 0) {
			throw new InvalidEmployeeException("You must enter a salary that is not negative.");
		} else if (annualSalary > 250000) {
			throw new InvalidEmployeeException("You must enter a salary below $250,000. Come on, who has that kind of money?!.");
		}
	}
	/**Method: getDepartment()
	 * 
	 * @return department - the String department that the Manager belongs to
	 */
	public String getDepartment() {
		return department;
	}
	/**Method: setDepartment()
	 * 
	 * @param department - the String department that the Manager belongs to; Defaults to Sales, Dev, or Product
	 */
	public void setDepartment(String department) {
		if (department.equalsIgnoreCase("Sales") || department.equalsIgnoreCase("Dev") || department.equalsIgnoreCase("Product")) {
			this.department = department;
		} else {
			this.department = "Sales";
		}
	}

	public String toString() {
		return getClass().getName() + ":        " + super.toString() + ", $" + getAnnualSalary();
	}

	public double calculatePaycheck() {
		double paycheck = getAnnualSalary() / 52;
		return paycheck;
	}

}
