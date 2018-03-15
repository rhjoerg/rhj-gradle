package ch.rhj.gradle.publish;

import static com.google.common.base.Strings.emptyToNull;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.io.File;
import java.util.Optional;

import javax.inject.Inject;

import ch.rhj.gradle.common.AbstractNamedExtension;

public class PublicationExtension extends AbstractNamedExtension<PublishingContext> implements ProjectInfo {
	
	private Optional<String> group = empty();
	private Optional<String> version = empty();
	private Optional<String> title = empty();
	private Optional<String> description = empty();
	
	@Inject
	public PublicationExtension(String name, PublishingContext context) {
		
		super(name, context);
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
	public String getVersion() {
		
		return version.orElseGet(context.projectInfo::getVersion);
	}

	public void setVersion(String version) {
		
		this.version = ofNullable(emptyToNull(version));
	}
	
	public void version(String version) {
		
		setVersion(version);
	}

	public String getTitle() {
		
		return title.orElseGet(context.projectInfo::getTitle);
	}

	public void setTitle(String title) {
		
		this.title = ofNullable(emptyToNull(title));
	}
	
	public void title(String title) {
		
		setTitle(title);
	}

	public String getDescription() {
		
		return description.orElseGet(context.projectInfo::getDescription);
	}

	public void setDescription(String description) {
		
		this.description = ofNullable(emptyToNull(description));
	}

	public void description(String description) {
		
		setDescription(description);
	}
	
	public File getOutputDirectory() {
		
		return context.project.getBuildDir().toPath().resolve("publishing").resolve(getName()).toFile();
	}
}
