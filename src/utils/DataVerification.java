package utils;

import model.Profile;
import resources.Credentials;

public class DataVerification {

	public static boolean verifyUser(String user, String password) {
		if (Credentials.users.containsKey(user)) {
			return Credentials.users.get(user).getPassword().equals(password);
		}
		return false;
	}
	
	public static boolean isAdmin(String user) {
		return Credentials.users.get(user).getProfile().equals(Profile.ADMIN);
	}
	
}
