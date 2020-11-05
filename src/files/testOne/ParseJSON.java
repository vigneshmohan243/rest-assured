package files.testOne;

import io.restassured.path.json.JsonPath;

public class ParseJSON {

	public static String getValue(String response, String reponsePath) {
		JsonPath js = new JsonPath(response);
		return js.getString(reponsePath);
	}

}
