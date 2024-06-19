package com.teklab.framework.utilities.dataManagers;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.jayway.jsonpath.JsonPath;




public class JsonManager {

	private String filePath = "";
//	 private String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/teklabRegression.json";

	// -----Constructor ---//
	public JsonManager(String fp) {
		filePath = fp;
	}

	public JsonManager() {  // if you create the filePath object with value
	}

	// -----Methods------//
	// step 1: open the json file and read its content
	// step 2: return the content as a string
	private String jsonToString() {
		String stringform = null;
		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader(filePath));
			JSONObject jsonObj = (JSONObject) object;
			stringform = (String) jsonObj.toJSONString();
			return stringform;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringform;
	}

	/**
	 * Enter your jason path query to extract the user related data
	 * 
	 * @param query
	 * @return string
	 */
	public String data(String query) { // public String executeQuery (String query)
		String jsonString = jsonToString();
		return JsonPath.read(jsonString, query);
	}













































}
