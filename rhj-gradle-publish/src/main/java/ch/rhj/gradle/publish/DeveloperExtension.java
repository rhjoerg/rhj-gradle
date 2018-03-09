package ch.rhj.gradle.publish;

public class DeveloperExtension {

	public final String name;
	
	public String[] roles;
	
	public String fullName;
	
	public String email;
	
	public DeveloperExtension(String name) {
		
		this.name = name;
	}
}
