package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		assertEquals("", project.property("description"));
		
		assertNotNull(project.getExtensions().getByName("publishing"));
		assertNotNull(project.getExtensions().getByName("publications"));
		
		@SuppressWarnings("unchecked")
		NamedDomainObjectContainer<PublicationExtension> publications
			= (NamedDomainObjectContainer<PublicationExtension>) project.getExtensions().getByName("publications");
		
		PublicationExtension test = publications.create("test");
		
		assertEquals("test", test.name);
	}
	
	@Test
	public void build(@Gradle GradleRunner runner) throws Exception {
		
		runner.withArguments("model").forwardOutput().withDebug(true).withPluginClasspath().build();
	}
}
