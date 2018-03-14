package ch.rhj.gradle.publish;

import static com.google.common.base.Strings.emptyToNull;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.util.Optional;

import javax.inject.Inject;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;

import ch.rhj.gradle.common.AbstractExtension;

public class PublishingExtension extends AbstractExtension<PublishingContext> implements ProjectInfo {
	
	private Optional<String> group = empty();
	private Optional<String> name = empty();
	private Optional<String> version = empty();
	private Optional<String> title = empty();
	private Optional<String> description = empty();
	
	private final NamedDomainObjectContainer<PublicationExtension> publications;
	private final NamedDomainObjectContainer<RepositoryExtension> repositories;
	
	@Inject
	public PublishingExtension(PublishingContext context) {
		
		super(context);
		
		PublishingContext subcontext = new PublishingContext(context, this);
		
		this.publications = newContainer(PublicationExtension.class, subcontext);
		this.repositories = newContainer(RepositoryExtension.class, subcontext);
	}
	
	@Override
	public String getGroup() {
		
		return group.orElseGet(context.projectInfo::getGroup);
	}

	public void setGroup(String group) {
		
		this.group = ofNullable(emptyToNull(group));
	}
	
	public void group(String group) {
		
		setGroup(group);
	}

	@Override
	public String getName() {
		
		return name.orElseGet(context.projectInfo::getName);
	}

	public void setName(String name) {
		
		this.name = ofNullable(emptyToNull(name));
	}
	
	public void name(String name) {
		
		setName(name);
	}

	@Override
	public String getVersion() {
		
		return version.orElseGet(context.projectInfo::getVersion);
	}

	public void setVersion(String version) {
		
		this.version = ofNullable(emptyToNull(version));
	}
	
	public void version(String version) {
		
		setVersion(version);
	}

	@Override
	public String getTitle() {
		
		return title.orElseGet(context.projectInfo::getTitle);
	}
	
	public void setTitle(String title) {
		
		this.title = ofNullable(emptyToNull(title));
	}

	public void title(String title) {
		
		setTitle(title);
	}
	
	@Override
	public String getDescription() {
		
		return description.orElseGet(context.projectInfo::getDescription);
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
	
	public NamedDomainObjectContainer<RepositoryExtension> getRepositories() {
		
		return repositories;
	}
	
	public void repositories(Action<? super NamedDomainObjectContainer<RepositoryExtension>> configurer) {
		
		configurer.execute(repositories);
	}
}
