package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.gradle.api.Project;
import org.junit.jupiter.api.Test;

import ch.rhj.junit.gradle.Gradle;
import ch.rhj.junit.gradle.WithGradle;

@WithGradle
public class PublishingPluginTests {

	@Test
	public void apply(@Gradle Project project) {
		
		project.getPlugins().apply(PublishingPlugin.class);
				
		assertEquals("", project.property("title"));
		assertEquals("", project.property("description"));
		
		PublishingExtension publishing = (PublishingExtension) project.getExtensions().getByName("publishing");
		
		assertEquals("", publishing.getTitle());
		assertEquals("", publishing.getDescription());
	}
}
