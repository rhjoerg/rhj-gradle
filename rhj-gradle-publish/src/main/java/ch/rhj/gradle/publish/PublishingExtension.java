package ch.rhj.gradle.publish;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

public class PublishingExtension implements ProjectInfo {
	
	private final ProjectInfo parentProjectInfo;

	private String group;
	private String name;
	private String version;
	private String title;
	private String description;
	
	private final NamedDomainObjectContainer<PublicationExtension> publications;
	
	public PublishingExtension(Project project, ProjectInfo parentProjectInfo) {
		
		this.parentProjectInfo = parentProjectInfo;
		
		publications = project.container(PublicationExtension.class, this::createPublication);
	}
	
	private PublicationExtension createPublication(String name) {
		
		return new PublicationExtension(name, this);
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
		
		return getName(name);
	}

	public void setName(String name) {
		
		this.name = name;
	}
	
	public void name(String name) {
		
		setName(name);
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

	@Override
	public String getTitle() {
		
		return getTitle(title);
	}
	
	public void setTitle(String title) {
		
		this.title = title;
	}

	public void title(String title) {
		
		setTitle(title);
	}
	
	@Override
	public String getDescription() {
		
		return getDescription(description);
	}

	public void setDescription(String description) {
		
		this.description = description;
	}

	public void description(String description) {
		
		setDescription(description);
	}
	
	public NamedDomainObjectContainer<PublicationExtension> getPublications() {
		
		return publications;
	}
	
	public void publications(Action<? super NamedDomainObjectContainer<PublicationExtension>> configurer) {
		
		configurer.execute(publications);
	}
}
