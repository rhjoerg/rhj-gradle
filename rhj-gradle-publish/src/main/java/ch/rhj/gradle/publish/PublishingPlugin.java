package ch.rhj.gradle.publish;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.ExtraPropertiesExtension;

public class PublishingPlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {
		
		setProperty(project, "title", "");
		setProperty(project, "description", "");
		
		ExtensionContainer extensions = project.getExtensions();
		
		extensions.create("publishing", PublishingExtension.class, project);
	}
	
	private void setProperty(Project project, String name, String value) {
		
		if (project.hasProperty(name)) {
			
			project.setProperty(name, value);
			return;
		}
		
		ExtraPropertiesExtension properties = project.getExtensions().getByType(ExtraPropertiesExtension.class);
		
		properties.set(name, value);
	}
}
