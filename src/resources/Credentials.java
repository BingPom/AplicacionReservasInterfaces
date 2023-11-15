package resources;

import java.util.HashMap;

import model.Language;
import model.Profile;
import model.User;

public class Credentials {
	
//	User data and password (Key: User, Value: Password)
	public static HashMap<String, User> users = new HashMap<String, User>() {
		private static final long serialVersionUID = 1L;

	{
		put("11111111H", new User("11111111H", "11111111H", Profile.STANDARD, Language.ESPAÑOL));
		put("22222222J", new User("22222222J", "22222222J", Profile.ADMIN, Language.ENGLISH));
	}};
}
