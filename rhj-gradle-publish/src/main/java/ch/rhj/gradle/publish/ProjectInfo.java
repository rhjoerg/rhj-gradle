package ch.rhj.gradle.publish;

import org.gradle.internal.impldep.com.google.api.client.util.Strings;

public interface ProjectInfo {
	
	ProjectInfo getParentProjectInfo();
	
	String getGroup();
	
	default String getGroup(String group) {
		
		return Strings.isNullOrEmpty(group) ? getParentProjectInfo().getGroup() : group;
	}

	String getName();
	
	default String getName(String name) {
		
		return Strings.isNullOrEmpty(name) ? getParentProjectInfo().getName() : name;
	}
	
	String getVersion();
	
	default String getVersion(String version) {
		
		return Strings.isNullOrEmpty(version) ? getParentProjectInfo().getVersion() : version;
	}
	
	String getTitle();
	
	default String getTitle(String title) {
		
		return Strings.isNullOrEmpty(title) ? getParentProjectInfo().getTitle() : title;
	}
	
	String getDescription();
	
	default String getDescription(String description) {
		
		return Strings.isNullOrEmpty(description) ? getParentProjectInfo().getDescription() : description;
	}
}
