package Generic_Utilities;

import java.util.Random;

public class Java_Utility 
{

	/**
	 * This method is used to avoid duplicates
	 * @author Nirmala
	 * @return
	 */
	public int getRandomNum()
	{
		
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;
		
	}

}
