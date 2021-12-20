package Demo;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;


public class ReadDataFromJsonFile {
	@Test
	/**
	 * 
	 * @throws Throwable
	 */
	public void getDataFromJson() throws Throwable 
	{
		FileReader reader = new FileReader("./Data/CommonData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject jsobj = (JSONObject)obj;
		String un = jsobj.get("username").toString();
		String url = jsobj.get("url").toString();
		String pwd = jsobj.get("password").toString();
		String browser = jsobj.get("browser").toString();

		System.out.println(un);
		System.out.println(url);
		System.out.println(browser);
		System.out.println(pwd);
	}
}
