package ch.rhj.gradle.publish;

public class PublicationExtension implements ProjectInfo {
	
	private final String name;
	private final ProjectInfo parentProjectInfo;
	
	private String group;
	private String version;
	private String title;
	private String description;
	
	public PublicationExtension(String name, ProjectInfo parentProjectInfo) {
		
		this.name = name;
		this.parentProjectInfo = parentProjectInfo;
	}
	
	@Override
	public ProjectInfo getParentProjectInfo() {

		return parentProjectInfo;
	}

	@Override
	public String getGroup() {
		
		return getGroup(group);
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
		
		return getVersion(version);
	}

	public void setVersion(String version) {
		
		this.version = version;
	}
	
	public void version(String version) {
		
		setVersion(version);
	}

	public String getTitle() {
		
		return getTitle(title);
	}

	public void setTitle(String title) {
		
		this.title = title;
	}
	
	public void title(String title) {
		
		setTitle(title);
	}

	public String getDescription() {
		
		return getDescription(description);
	}

	public void setDescription(String description) {
		
		this.description = description;
	}

	public void description(String description) {
		
		setDescription(description);
	}
}
