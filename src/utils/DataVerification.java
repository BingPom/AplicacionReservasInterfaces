package utils;

import resources.Credentials;

public class DataVerification {

	public static boolean verifyUser(String user, String password) {
		if (Credentials.users.containsKey(user)) {
			return Credentials.users.get(user).equals(password);
		}
		return false;
	}
	
}
