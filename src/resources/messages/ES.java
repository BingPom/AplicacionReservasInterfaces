package resources.messages;

import java.util.HashMap;

public class ES {

	final static HashMap<String, String> messages = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;

	{
		put("", "");
		put("", "");
	}};
	
	public static HashMap<String, String> getMessages() {
		return messages;
	}
}
