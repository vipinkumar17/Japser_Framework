package Demo;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
public class ReadDataFromJSONUSingHashMap {
	@Test
	/**
	 *  this method reads the data from JSON file
	 * @throws Throwable
	 */
	public void getDataFromJson() throws Throwable 
	{
		//  read the data from JSON file
		FileReader file = new FileReader("./Data/CommonData.json");
		
		// Convert the JSON file into Java Object
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(file);
		
		// typecast java object to hashmap
		HashMap map =  (HashMap)obj;
		String un = map.get("username").toString();
		System.out.println(un);
		String pwd = map.get("password").toString();
		System.out.println(pwd);
		String url = map.get("url").toString();
		System.out.println(url);
		String browser = map.get("browser").toString();
		System.out.println(browser);
}
}