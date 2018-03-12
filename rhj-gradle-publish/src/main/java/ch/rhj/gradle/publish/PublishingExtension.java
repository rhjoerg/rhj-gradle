package ch.rhj.gradle.publish;

import org.gradle.api.Project;

import com.google.common.base.Strings;

public class PublishingExtension {
	
	private final Project project;

	private String title;
	private String description;
	
	public PublishingExtension(Project project) {
		
		this.project = project;
	}
	
	public String getTitle() {
		
		if (!Strings.isNullOrEmpty(title))
			return title;
		
		if (project.hasProperty("title"))
			return project.property("title").toString();
		
		return "";
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
		
		if (project.hasProperty("description"))
			return project.property("description").toString();
		
		return "";
	}

	public void setDescription(String description) {
		
		this.description = description;
	}

	public void description(String description) {
		
		setDescription(description);
	}
}
