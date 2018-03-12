package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.Test;

import ch.rhj.junit.gradle.Gradle;
import ch.rhj.junit.gradle.WithGradle;
import ch.rhj.junit.resource.WithResources;

@WithGradle
@WithResources
public class PublishingPluginTests {

	@Test
	public void apply(@Gradle Project project) {
		
		project.getPlugins().apply(PublishingPlugin.class);
				
		assertEquals("", project.property("title"));
		assertNull(project.property("description"));
		
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
	
	private <T> T getExtension(Project project, String name, Class<T> type) {
		
		return type.cast(project.getExtensions().getByName(name));
	}
	
	@SuppressWarnings("unchecked")
	private <T> NamedDomainObjectContainer<T> getContainer(Project project, String name, Class<T> type) {
		
		return (NamedDomainObjectContainer<T>) project.getExtensions().getByName(name);
	}
	
	@Test
	public void build(@Gradle GradleRunner runner) throws Exception {
		
		runner.withArguments("model").forwardOutput().withDebug(true).withPluginClasspath().build();
	}
}
