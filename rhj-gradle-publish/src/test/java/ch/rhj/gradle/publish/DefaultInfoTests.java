package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.gradle.api.Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class DefaultInfoTests {

	@Test
	public void test(@Mock Project project) {
		
		DefaultInfo info = new DefaultInfo(project);
		
		when(project.getGroup()).thenReturn("group");
		assertEquals("group", info.getGroup());
		
		when(project.getName()).thenReturn("name");
		assertEquals("name", info.getName());
		
		when(project.getVersion()).thenReturn("version");
		assertEquals("version", info.getVersion());
		
		when(project.hasProperty("title")).thenReturn(false);
		assertEquals("name", info.getTitle());
		
		when(project.hasProperty("title")).thenReturn(true);
		when(project.property("title")).thenReturn("title");
		assertEquals("title", info.getTitle());
		
		when(project.hasProperty("description")).thenReturn(false);
		assertEquals("title", info.getDescription());
		
		when(project.hasProperty("description")).thenReturn(true);
		when(project.property("description")).thenReturn("description");
		assertEquals("description", info.getDescription());
	}
}
