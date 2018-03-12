package ch.rhj.gradle.publish;

import org.gradle.api.NamedDomainObjectContainer;
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
		
		PublishingExtension publishing = extensions.create("publishing", PublishingExtension.class, project);
		
		NamedDomainObjectContainer<PublicationExtension> publications = project
				.container(PublicationExtension.class, name -> new PublicationExtension(name, publishing));
		
		extensions.add("publications", publications);
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
