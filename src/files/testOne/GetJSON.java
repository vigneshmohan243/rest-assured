package files.testOne;

public class GetJSON {

	public static String AddPlace() {
		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -40.40,\r\n" + "    \"lng\": 35.35\r\n" + "  },\r\n"
				+ "  \"accuracy\": 50,\r\n" + "  \"name\": \"Vignesh\",\r\n" + "  \"phone_number\": \"1234567890\",\r\n"
				+ "  \"address\": \"Chennai, India\",\r\n" + "  \"types\": [\r\n" + "    \"Flat\"\r\n" + "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"English-IN\"\r\n" + "}";
	}

	public static String UpdatePlace(String placeId) {
		return "{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"Coimbatore, India\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n" + "}";
	}

	public static String DeletePlace(String placeId) {
		return "{\r\n" + "    \"place_id\":\"" + placeId + "\"\r\n" + "}";
	}

}