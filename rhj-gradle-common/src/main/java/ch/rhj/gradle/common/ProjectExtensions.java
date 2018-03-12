package ch.rhj.gradle.common;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

public class ProjectExtensions {

	public static <T> T getExtension(Project project, String name, Class<T> type) {
		
		return type.cast(project.getExtensions().getByName(name));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> NamedDomainObjectContainer<T> getContainer(Project project, String name, Class<T> type) {
		
		return (NamedDomainObjectContainer<T>) project.getExtensions().getByName(name);
	}
}
