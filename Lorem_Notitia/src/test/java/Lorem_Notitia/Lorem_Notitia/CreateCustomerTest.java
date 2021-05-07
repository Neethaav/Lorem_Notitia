package Lorem_Notitia.Lorem_Notitia;

import org.testng.annotations.Test;

public class CreateCustomerTest {
@Test
public void createCustomerTest()
{
	String USERNAME = System.getProperty("username");
	String PASSWORD = System.getProperty("password");
	String BROWSER = System.getProperty("browser");
	System.out.println("execute Test1");
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
	System.out.println(BROWSER);
	
}

}
