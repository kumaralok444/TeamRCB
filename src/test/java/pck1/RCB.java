package pck1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class RCB {
	public static String resourceLocation = System.getProperty("user.dir").toString().replace("\\", "\\\\")
			+ "\\src\\test\\resources\\";
	Object obj;
	JSONObject jo;
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException, ParseException {
		obj = new JSONParser().parse(new FileReader(resourceLocation+"\\TeamRCB.json"));
		jo = (JSONObject) obj;

	}
@Test(description="TO vaidate there is only 4 foreign players")
public void tc1() {
	int count=0;
	JSONArray ja = (JSONArray) jo.get("player");
	for(Object ob:ja) {
		String st=(String)(((JSONObject) ob).get("country"));
		if(!st.equalsIgnoreCase("India")) {
			count++;
		}
	}
	Assert.assertEquals(count, 4);
	//System.out.println("Test Here");
}
@Test(description="To validate there is atleast one wicket-keeper")
public void tc2() {
	boolean flag=false;
	JSONArray ja = (JSONArray) jo.get("player");
	for(Object ob:ja) {
		String st=(String)(((JSONObject) ob).get("role"));
		if(st.equalsIgnoreCase("Wicket-keeper")) {
			flag=true;
		}
	}
	Assert.assertTrue(flag);
	//System.out.println("Test Here");
}
}
