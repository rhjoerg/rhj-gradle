package ch.rhj.gradle.publish;

import org.gradle.internal.impldep.com.google.api.client.util.Strings;

public class PublicationExtension {
	
	public final String name;
	
	private final PublishingExtension publishing;
	
	private String title;
	private String description;
	
	public PublicationExtension(String name, PublishingExtension publishing) {
		
		this.name = name;
		this.publishing = publishing;
	}
	
	public String getTitle() {
		
		if (!Strings.isNullOrEmpty(title))
			return title;
		
		return publishing.getTitle();
	}

	public void setTitle(String title) {
		
		this.title = title;
	}
	
	public void title(String title) {
		
		setTitle(title);
	}

	public String getDescription() {
		
		if (!Strings.isNullOrEmpty(description))
			return description;
		
		return publishing.getDescription();
	}

	public void setDescription(String description) {
		
		this.description = description;
	}

	public void description(String description) {
		
		setDescription(description);
	}
}
