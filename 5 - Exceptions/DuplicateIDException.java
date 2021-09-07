package exceptions;

import java.io.IOException;

public class DuplicateIDException extends RuntimeException
{
    public DuplicateIDException()
    {
        super();
    }

    public DuplicateIDException(String msg)
    {
        super(msg);
    }
}



