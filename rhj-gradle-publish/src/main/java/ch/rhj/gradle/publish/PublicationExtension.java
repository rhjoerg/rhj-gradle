package ch.rhj.gradle.publish;

import static com.google.common.base.Strings.emptyToNull;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.util.Optional;

public class PublicationExtension implements ProjectInfo {
	
	private final String name;
	private final ProjectInfo parentProjectInfo;
	
	private Optional<String> group = empty();
	private Optional<String> version = empty();
	private Optional<String> title = empty();
	private Optional<String> description = empty();
	
	public PublicationExtension(String name, ProjectInfo parentProjectInfo) {
		
		this.name = name;
		this.parentProjectInfo = parentProjectInfo;
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

		return name;
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

	public String getTitle() {
		
		return title.orElseGet(parentProjectInfo::getTitle);
	}

	public void setTitle(String title) {
		
		this.title = ofNullable(emptyToNull(title));
	}
	
	public void title(String title) {
		
		setTitle(title);
	}

	public String getDescription() {
		
		return description.orElseGet(parentProjectInfo::getDescription);
	}

	public void setDescription(String description) {
		
		this.description = ofNullable(emptyToNull(description));
	}

	public void description(String description) {
		
		setDescription(description);
	}
}
