package third.pac;

import java.io.*;

class UserNotFoundException extends Exception
{
	public UserNotFoundException()
	{
		System.out.println("User not found exception occurs");
	}

}