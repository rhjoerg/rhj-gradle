package ch.rhj.gradle.publish;

import static ch.rhj.gradle.common.ProjectExtensions.getContainer;
import static ch.rhj.gradle.common.ProjectExtensions.getExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.Test;

import ch.rhj.junit.gradle.Gradle;

public class PublishingPluginTests {

	@Test
	public void apply(@Gradle Project project) {
		
		project.getPlugins().apply(PublishingPlugin.class);
				
		assertEquals("", project.property("title"));
		assertEquals("", project.property("description"));
		
		PublishingExtension publishing = getExtension(project, "publishing", PublishingExtension.class);
		NamedDomainObjectContainer<PublicationExtension> globalPublications = getContainer(project, "publications", PublicationExtension.class);
		NamedDomainObjectContainer<PublicationExtension> localPublications = publishing.getPublications();
		
		assertNotNull(publishing);
		assertNotNull(globalPublications);
		assertNotNull(localPublications);
		
		PublicationExtension globalPublication = globalPublications.create("globalPublication");
		PublicationExtension localPublication = localPublications.create("localPublication");
		
		assertEquals("globalPublication", globalPublication.getName());
		assertEquals("localPublication", localPublication.getName());
	}
	
	@Test
	public void build(@Gradle GradleRunner runner) throws Exception {
		
		runner.withArguments("tasks").forwardOutput().withDebug(true).withPluginClasspath().build();
	}
}
