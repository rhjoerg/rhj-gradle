package ch.rhj.gradle.publish;

import static com.google.common.base.Strings.emptyToNull;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.util.Optional;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

public class PublishingExtension implements ProjectInfo {
	
	private final ProjectInfo parentProjectInfo;

	private Optional<String> group = empty();
	private Optional<String> name = empty();
	private Optional<String> version = empty();
	private Optional<String> title = empty();
	private Optional<String> description = empty();
	
	private final NamedDomainObjectContainer<PublicationExtension> publications;
	private final RepositoriesExtension repositories;
	
	public PublishingExtension(Project project, ProjectInfo parentProjectInfo) {
		
		this.parentProjectInfo = parentProjectInfo;
		
		
		publications = project.container(PublicationExtension.class, this::createPublication);
		repositories = project.getObjects().newInstance(RepositoriesExtension.class);
	}
	
	private PublicationExtension createPublication(String name) {
		
		return new PublicationExtension(name, this);
	}
	
	@Override
	public String getGroup() {
		
		return group.orElseGet(parentProjectInfo::getGroup);
	}

	public void setGroup(String group) {
		
		this.group = ofNullable(emptyToNull(group));
	}
	
	public void group(String group) {
		
		setGroup(group);
	}

	@Override
	public String getName() {
		
		return name.orElseGet(parentProjectInfo::getName);
	}

	public void setName(String name) {
		
		this.name = ofNullable(emptyToNull(name));
	}
	
	public void name(String name) {
		
		setName(name);
	}

	@Override
	public String getVersion() {
		
		return version.orElseGet(parentProjectInfo::getVersion);
	}

	public void setVersion(String version) {
		
		this.version = ofNullable(emptyToNull(version));
	}
	
	public void version(String version) {
		
		setVersion(version);
	}

	@Override
	public String getTitle() {
		
		return title.orElseGet(parentProjectInfo::getTitle);
	}
	
	public void setTitle(String title) {
		
		this.title = ofNullable(emptyToNull(title));
	}

	public void title(String title) {
		
		setTitle(title);
	}
	
	@Override
	public String getDescription() {
		
		return description.orElseGet(parentProjectInfo::getDescription);
	}

	public void setDescription(String description) {
		
		this.description = ofNullable(emptyToNull(description));
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
	
	public RepositoriesExtension getRepositories() {
		
		return repositories;
	}
	
	public void repositories(Action<? super RepositoriesExtension> configurer) {
		
		configurer.execute(repositories);
	}
}
