package ch.rhj.gradle.publish;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

import com.google.common.base.Strings;

public class PublishingExtension implements ProjectInfo {
	
	private final ProjectInfo parent;

	private String group;
	private String name;
	private String version;
	private String title;
	private String description;
	
	private final NamedDomainObjectContainer<PublicationExtension> publications;
	
	public PublishingExtension(Project project, ProjectInfo parent) {
		
		this.parent = parent;
		
		publications = project.container(PublicationExtension.class, this::createPublication);
	}
	
	private PublicationExtension createPublication(String name) {
		
		return new PublicationExtension(name, this);
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
		
		return Strings.isNullOrEmpty(name) ? parent.getName() : name;
	}

	public void setName(String name) {
		
		this.name = name;
	}
	
	public void name(String name) {
		
		setName(name);
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

	@Override
	public String getTitle() {
		
		return Strings.isNullOrEmpty(title) ? parent.getTitle() : title;
	}
	
	public void setTitle(String title) {
		
		this.title = title;
	}

	public void title(String title) {
		
		setTitle(title);
	}
	
	@Override
	public String getDescription() {
		
		return Strings.isNullOrEmpty(description) ? parent.getDescription() : description;
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
