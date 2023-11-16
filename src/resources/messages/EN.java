package resources.messages;

import java.util.HashMap;

public class EN {

	final static HashMap<String, String> messages = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;

	{
		put("Turista", "Turist");
		put("22222222J", "");
	}};
	
	public static HashMap<String, String> getMessages() {
		return messages;
	}
}
