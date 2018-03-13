package ch.rhj.gradle.common;

import org.gradle.api.Project;

public class ProjectProperties {

	public static Object get(Project project, String name, Object defaultValue) {
		
		return project.hasProperty(name) ? project.property(name) : defaultValue;
	}
	
	public static void set(Project project, String name, Object value) {
		
		if (project.hasProperty(name)) {
			
			project.setProperty(name, value);
			return;
		}
		
		project.getExtensions().getExtraProperties().set(name, value);
	}
	
	public static void setIfAbsent(Project project, String name, Object value) {
		
		if (project.hasProperty(name)) {
			
			if (project.property(name) == null)
				project.setProperty(name, value);
			
			return;
		}
		
		project.getExtensions().getExtraProperties().set(name, value);
	}
}
