package Practice;

import org.testng.annotations.Test;

public class Person {
@Test
public void der()
{
	System.out.println("execute 2");
	String un = System.getProperty("username"); // read the data from CMD
	System.out.println(un);
}
}
