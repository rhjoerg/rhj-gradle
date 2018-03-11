package ch.rhj.gradle.publish;

public class LicenseExtension {

	public final String name;
	
	public String title;
	
	public String url;
	
	public String distribution = "repo";

	public LicenseExtension(String name) {
		
		this.name = name;
	}

	public LicenseExtension(String name, String title, String url, String distribution) {
		
		this(name);
		
		this.title = title;
		this.url = url;
		this.distribution = distribution;
	}

	public void title(String title) {
		
		this.title = title;
	}

	public void url(String url) {
		
		this.url = url;
	}

	public void distribution(String distribution) {
		
		this.distribution = distribution;
	}
}
