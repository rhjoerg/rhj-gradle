package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.gradle.api.Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ch.rhj.junit.gradle.Gradle;

public class PublishingExtensionTests {
	
	@Test
	public void group(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.group("group1");
		assertEquals("group1", extension.getGroup());
		extension.group(null);
		
		when(parent.getGroup()).thenReturn("group2");
		assertEquals("group2", extension.getGroup());
	}
	
	@Test
	public void name(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.name("name1");
		assertEquals("name1", extension.getName());
		extension.name(null);
		
		when(parent.getName()).thenReturn("name2");
		assertEquals("name2", extension.getName());
	}

	@Test
	public void version(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.version("version1");
		assertEquals("version1", extension.getVersion());
		extension.version(null);
		
		when(parent.getVersion()).thenReturn("version2");
		assertEquals("version2", extension.getVersion());
	}

	@Test
	public void title(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.title("title1");
		assertEquals("title1", extension.getTitle());
		extension.title(null);
		
		when(parent.getTitle()).thenReturn("title2");
		assertEquals("title2", extension.getTitle());
	}
	
	@Test
	public void description(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.description("description1");
		assertEquals("description1", extension.getDescription());
		extension.description(null);
		
		when(parent.getDescription()).thenReturn("description2");
		assertEquals("description2", extension.getDescription());
	}
	
	@Test
	public void publications(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.publications(pubs -> { pubs.create("test"); });
		
		assertTrue(extension.getPublications().getNames().contains("test"));
	}
	
	@Test
	public void repositories(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		assertTrue(extension.getRepositories() == extension.getRepositories());
		extension.repositories(reps -> {});
	}
}
