package Lorem_Notitia.Lorem_Notitia;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;


public class CreateUserTest {
	@Test
	public void createUserTest(XmlTest xml){
		System.out.println("======Start Execution======");
		String BROWSER = xml.getParameter("browser");
		System.out.println(BROWSER);
		
	}

}
