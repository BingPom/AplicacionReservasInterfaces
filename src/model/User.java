package model;

public class User {

//	Attributes
	private String username;
	private String password;
	private Profile profile;
	private Language language;
	
	public User(String username, String password, Profile profile, Language language) {
		super();
		this.username = username;
		this.password = password;
		this.profile = profile;
		this.language = language;
	}
	
//	Getters
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Profile getProfile() {
		return profile;
	}
	public Language getLanguage() {
		return language;
	}
	
	
	
}
