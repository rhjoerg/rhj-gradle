package ch.rhj.gradle.publish;

import org.gradle.internal.impldep.com.google.api.client.util.Strings;

public class PublicationExtension implements ProjectInfo {
	
	private final String name;
	private final ProjectInfo parent;
	
	private String group;
	private String version;
	private String title;
	private String description;
	
	public PublicationExtension(String name, ProjectInfo parent) {
		
		this.name = name;
		this.parent = parent;
	}
	
	@Override
	public String getGroup() {
		
		return Strings.isNullOrEmpty(group) ? parent.getGroup() : group;
	}

	public void setGroup(String group) {
		
		this.group = group;
	}
	
	public void group(String group) {
		
		setGroup(group);
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public String getVersion() {
		
		return Strings.isNullOrEmpty(version) ? parent.getVersion() : version;
	}

	public void setVersion(String version) {
		
		this.version = version;
	}
	
	public void version(String version) {
		
		setVersion(version);
	}

	public String getTitle() {
		
		return Strings.isNullOrEmpty(title) ? parent.getTitle() : title;
	}

	public void setTitle(String title) {
		
		this.title = title;
	}
	
	public void title(String title) {
		
		setTitle(title);
	}

	public String getDescription() {
		
		return Strings.isNullOrEmpty(description) ? parent.getDescription() : description;
	}

	public void setDescription(String description) {
		
		this.description = description;
	}

	public void description(String description) {
		
		setDescription(description);
	}
}
