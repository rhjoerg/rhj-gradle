package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class PublicationExtensionTests {
	
	@Test
	public void group(@Mock ProjectInfo parent) {
		
		PublicationExtension extension = new PublicationExtension("foo", parent);
		
		when(parent.getGroup()).thenReturn("group1");
		assertEquals("group1", extension.getGroup());
		
		extension.group("group2");
		assertEquals("group2", extension.getGroup());
	}
	
	@Test
	public void version(@Mock ProjectInfo parent) {
		
		PublicationExtension extension = new PublicationExtension("foo", parent);
		
		when(parent.getVersion()).thenReturn("version1");
		assertEquals("version1", extension.getVersion());
		
		extension.version("version2");
		assertEquals("version2", extension.getVersion());
	}
	
	@Test
	public void title(@Mock ProjectInfo parent) {
		
		PublicationExtension extension = new PublicationExtension("foo", parent);
		
		when(parent.getTitle()).thenReturn("test1");
		assertEquals("test1", extension.getTitle());
		
		extension.title("test2");
		assertEquals("test2", extension.getTitle());
	}

	@Test
	public void description(@Mock ProjectInfo parent) {
		
		PublicationExtension extension = new PublicationExtension("foo", parent);
		
		when(parent.getDescription()).thenReturn("test1");
		assertEquals("test1", extension.getDescription());
		
		extension.description("test2");
		assertEquals("test2", extension.getDescription());
	}
}
