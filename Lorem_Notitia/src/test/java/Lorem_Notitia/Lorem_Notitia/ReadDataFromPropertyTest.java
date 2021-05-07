package Lorem_Notitia.Lorem_Notitia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyTest {
@Test
public void ReadData() throws IOException
{
	 FileInputStream fis = new FileInputStream("./Data/commonData.properties");
	    
	  //step-2 : create an Object of the Properties class & load the all keys:value pair
	    Properties pObj = new Properties();
	    pObj.load(fis);
	    
	    
	  //step-3 : read the value using getPropert("Key")
	     String URL = pObj.getProperty("URL");
	     String BROWSER = pObj.getProperty("browser");
	     String USERNAME = pObj.getProperty("username");
	     String TIMEOUT = pObj.getProperty("timeout");
	     
	     System.out.println(URL);
	     System.out.println(BROWSER);
	     System.out.println(USERNAME);
	     System.out.println(TIMEOUT);
}
}
