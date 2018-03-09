package ch.rhj.gradle.publish;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.ExtraPropertiesExtension;
import org.gradle.api.tasks.TaskContainer;

public class PublishPlugin implements Plugin<Project> {
	
	private NamedDomainObjectContainer<DeveloperExtension> developers;

	@Override
	public void apply(Project project) {
		
		ExtraPropertiesExtension properties = project.getExtensions().findByType(ExtraPropertiesExtension.class);
		
		properties.set("title", project.getName());
		properties.set("description", project.getName());
		
		ExtensionContainer extensions = project.getExtensions();
		
		developers = project.container(DeveloperExtension.class);
		extensions.add("developers", developers);
		
		TaskContainer tasks = project.getTasks();

		tasks.create("reportDevelopers", ReportDevelopersTask.class, this::configureReportDevelopers);
		tasks.create("createPom", CreatePomTask.class, this::configureCreatePom);
	}
	
	private void configureReportDevelopers(ReportDevelopersTask reportDevelopers) {
		
		reportDevelopers.developers = developers;
	}
	
	private void configureCreatePom(CreatePomTask createPom) {
		
	}
}
