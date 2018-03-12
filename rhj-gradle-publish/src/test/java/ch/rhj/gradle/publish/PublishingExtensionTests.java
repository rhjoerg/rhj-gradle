package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.gradle.api.Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ch.rhj.junit.mockito.WithMockito;

@WithMockito
public class PublishingExtensionTests {

	@Test
	public void title(@Mock Project project) {
		
		PublishingExtension extension = new PublishingExtension(project);
		
		extension.title("test");
		assertEquals("test", extension.getTitle());
		extension.title(null);
		
		Mockito.when(project.hasProperty("title")).thenReturn(false);
		assertEquals("", extension.getTitle());
		
		Mockito.when(project.hasProperty("title")).thenReturn(true);
		Mockito.when(project.property("title")).thenReturn("test");
		assertEquals("test", extension.getTitle());
	}
	
	@Test
	public void description(@Mock Project project) {
		
		PublishingExtension extension = new PublishingExtension(project);
		
		extension.description("test");
		assertEquals("test", extension.getDescription());
		extension.description(null);
		
		Mockito.when(project.hasProperty("description")).thenReturn(false);
		assertEquals("", extension.getDescription());
		
		Mockito.when(project.hasProperty("description")).thenReturn(true);
		Mockito.when(project.property("description")).thenReturn("test");
		assertEquals("test", extension.getDescription());
	}
}
