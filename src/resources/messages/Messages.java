package resources.messages;

import model.Language;

public class Messages {

	public static String getMessage(Language lang, String message) {
		switch (lang) {
		case ENGLISH:
			return EN.getMessages().get(message);
		case ESPAÑOL:
			return ES.getMessages().get(message);
		default:
			break;
		}
		return "";
	}
	
}
