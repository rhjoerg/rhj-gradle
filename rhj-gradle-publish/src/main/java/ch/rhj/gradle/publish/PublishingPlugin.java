package ch.rhj.gradle.publish;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;

import ch.rhj.gradle.common.ProjectProperties;

public class PublishingPlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {
		
		configureProperties(project);
		configureExtensions(project);
	}
	
	private void configureProperties(Project project) {
		
		ProjectProperties.setIfAbsent(project, "title", "");
		ProjectProperties.setIfAbsent(project, "description", "");
	}
	
	private void configureExtensions(Project project) {
		
		ExtensionContainer extensions = project.getExtensions();
		DefaultInfo defaultInfo = new DefaultInfo(project);
		
		extensions.create("publishing", PublishingExtension.class, project, defaultInfo);
		
		extensions.add("publications", project.container(PublicationExtension.class,
				name -> new PublicationExtension(name, defaultInfo)));
	}
}
