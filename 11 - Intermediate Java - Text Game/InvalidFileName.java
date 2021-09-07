package exceptions;

import java.io.FileNotFoundException;
	
public class InvalidFileName extends FileNotFoundException {


		public InvalidFileName()
	    {
	        super();
	    }

	    public InvalidFileName(String msg)
	    {
	        super(msg);
	    }
	




}
