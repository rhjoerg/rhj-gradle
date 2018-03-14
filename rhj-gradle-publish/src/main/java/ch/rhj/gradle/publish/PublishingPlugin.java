package ch.rhj.gradle.publish;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.model.ObjectFactory;
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
		ObjectFactory objects = project.getObjects();
		
		ProjectInfo projectInfo = new DefaultProjectInfo(project);
		PublishingContext context = new PublishingContext(project, projectInfo);
		
		extensions.create("publishing", PublishingExtension.class, context);
		
		extensions.add("publications", project.container(PublicationExtension.class,
				name -> objects.newInstance(PublicationExtension.class, name, context)));
	}
}
