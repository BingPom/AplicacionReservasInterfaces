package resources.messages;

import java.util.HashMap;

public class EN {

	final static HashMap<String, String> messages = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;

	{
		put("11111111H", "");
		put("22222222J", "");
	}};
	
	public static HashMap<String, String> getMessages() {
		return messages;
	}
}
