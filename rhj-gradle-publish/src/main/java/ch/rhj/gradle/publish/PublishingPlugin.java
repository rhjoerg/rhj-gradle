package ch.rhj.gradle.publish;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;

import ch.rhj.gradle.common.ProjectProperties;

public class PublishingPlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {
		
		ProjectProperties.setIfAbsent(project, "title", "");
		ProjectProperties.setIfAbsent(project, "description", "");
		
		ExtensionContainer extensions = project.getExtensions();
		
		ProjectInfo projectInfo = new ProjectProjectInfo(project);

		extensions.create("publishing", PublishingExtension.class, project, projectInfo);
		
		extensions.add("publications", project.container(PublicationExtension.class,
				name -> new PublicationExtension(name, projectInfo)));
	}
}
