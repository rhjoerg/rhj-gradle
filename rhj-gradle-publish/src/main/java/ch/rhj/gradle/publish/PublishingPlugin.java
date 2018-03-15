package ch.rhj.gradle.publish;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;

import ch.rhj.gradle.common.ProjectProperties;

public class PublishingPlugin implements Plugin<Project> {
	
	private PublishingContext context;
	
	@Override
	public void apply(Project project) {
		
		ProjectInfo projectInfo = new DefaultProjectInfo(project);

		context = new PublishingContext(project, projectInfo);
		
		configureProperties();
		configureExtensions();
		
		project.afterEvaluate(this::generateTasks);
	}
	
	private void configureProperties() {
		
		ProjectProperties.setIfAbsent(context.project, "title", "");
		ProjectProperties.setIfAbsent(context.project, "description", "");
	}
	
	private void configureExtensions() {
		
		ExtensionContainer extensions = context.project.getExtensions();
		
		extensions.create("publishing", PublishingExtension.class, context);
		extensions.add("publications", context.newContainer(PublicationExtension.class, context));
	}
	
	private void generateTasks(Project project) {
		
	}
}
