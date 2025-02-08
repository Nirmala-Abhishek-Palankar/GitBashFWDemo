package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	public String getKeyAndValuePair(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDatas.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
	

}
