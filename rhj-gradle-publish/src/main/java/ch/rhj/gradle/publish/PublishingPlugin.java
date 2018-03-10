package ch.rhj.gradle.publish;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.tasks.TaskContainer;

public class PublishingPlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {
		
		ExtensionContainer extensions = project.getExtensions();
		TaskContainer tasks = project.getTasks();
		
		PublishingExtension publishing = extensions.create("publishing", PublishingExtension.class, project);
		
		tasks.create("createMavenPom", CreateMavenPomTask.class, task -> task.publishing = publishing);
	}
}
