/**Class: Customer
* @author Jeremy Cooley
* @version 1.0
* Course : ITEC 2150 Summer 2018
* Written: July 24, 2018
*
*
* This class describes a Customer
*
* Purpose: This class describes a Customer
*/
public class Customer implements Comparable<Customer>
{
      private String firstName;
      private String lastName;
      
      
      
      // Constructors
      
      public Customer() 
      {
    	  super();
      }
      
      public Customer(String firstName, String lastName) 
      {
    	  this.setFirstName(firstName);
    	  this.setLastName(lastName);
      }

      
      
      
      // Getters and Setters
      
	/** @return the firstName
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/** @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	/** @return the lastName
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/** @param lastName the lastName to set
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
      


	/** Method: toString 
	 * 
	 * @return String - the first name and last name of the customer concatenated together
	 * 
	 * Add a toString() method to Customer that ensures when printing a Customer that the 
	 * output is readable and meaningful
	 */
	public String toString()
	{
		return firstName + " " + lastName;
	}
	
	

	
	/**Method: compareTo()
	 * 
	 * @param otherCustomer - the other Customer to compare types with. 
	 *
	 * @return int - Returns a negative int if the lastName of otherCustomer comes before the one 
	 * this method is called on, 0 if it's the same, and a positive int if the lastName of 
	 * otherCustomer comes after.
	 * 
	 * implements the Comparable interface that will allow a sort on last name in ascending order
	 */
	public int compareTo(Customer otherCustomer) 
	{
		return lastName.compareTo(otherCustomer.getLastName());
	}
	
	
	
       
      
      
}
