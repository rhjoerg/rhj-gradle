package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ch.rhj.junit.mockito.WithMockito;

@WithMockito
public class PublicationExtensionTests {
	
	@Test
	public void title(@Mock PublishingExtension publishing) {
		
		PublicationExtension extension = new PublicationExtension("foo", publishing);
		
		when(publishing.getTitle()).thenReturn("test1");
		assertEquals("test1", extension.getTitle());
		
		extension.title("test2");
		assertEquals("test2", extension.getTitle());
	}

	@Test
	public void description(@Mock PublishingExtension publishing) {
		
		PublicationExtension extension = new PublicationExtension("foo", publishing);
		
		when(publishing.getDescription()).thenReturn("test1");
		assertEquals("test1", extension.getDescription());
		
		extension.description("test2");
		assertEquals("test2", extension.getDescription());
	}
}
