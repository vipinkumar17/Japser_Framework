package Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Contact {
@Test
public void org(XmlTest xml) // always run from testng.xml
{
	System.out.println("execute1");
	String url = xml.getParameter("url");
	String un = xml.getParameter("username");
	String broswer = xml.getParameter("browser");
	String pwd = xml.getParameter("password");
	System.out.println(url);
	System.out.println(un);
	System.out.println(broswer);
	System.out.println(pwd);
	
}
}
