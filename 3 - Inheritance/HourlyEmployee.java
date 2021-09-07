/**Class: HourlyEmployee
 * @author Jeremy Cooley
 * @version 2.0
 * Course: ITEC 2150 Summer 2018
 * Last Updated: May 28, 2018
 */
public class HourlyEmployee extends Employee {
	
	private double hours;
	private double hourlyRate;
	
	public HourlyEmployee(String firstName, String lastName) {
		super(firstName, lastName);		
	}

	public HourlyEmployee(String firstName, String lastName, double hours, double hourlyRate) {
		super(firstName, lastName);
		setHours(hours);
		setHourlyRate(hourlyRate);
	}
	
	

	/**Method: getHours()
	 * 
	 * @return hours - the double hours the Hourly Employee works.
	 */
	public double getHours() {
		return hours;
	}
	/**Method: setHours()
	 * 
	 * @param hours - the double hours the Hourly Employee works.
	 */
	public void setHours(double hours) {
		this.hours = hours;
	}
	/**Method: getHourlyRate()
	 * 
	 * @return hourlyRate - the dollars per hour the Hourly Employee works
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}
	/**Method: setHourlyRate()
	 * 
	 * @param hourlyRate - the dollars per hour the Hourly Employee works
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	
	
	
	public String toString() {
		return getClass().getName() + ": " + super.toString() + ", " + getHours() + " hours/week, $" + getHourlyRate() + "/hour";
	}

	public double calculatePaycheck() {
		paycheck = getHours() * getHourlyRate();
		return paycheck;
	}

	

	
	




}
