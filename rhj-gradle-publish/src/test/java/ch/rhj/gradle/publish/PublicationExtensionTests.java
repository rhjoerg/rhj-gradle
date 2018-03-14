package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.gradle.api.Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ch.rhj.junit.gradle.Gradle;

public class PublicationExtensionTests {
	
	@Mock
	ProjectInfo projectInfo;
	
	@Test
	public void group(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublicationExtension extension = new PublicationExtension("foo", context);
		
		when(projectInfo.getGroup()).thenReturn("group1");
		assertEquals("group1", extension.getGroup());
		
		extension.group("group2");
		assertEquals("group2", extension.getGroup());
	}
	
	@Test
	public void version(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublicationExtension extension = new PublicationExtension("foo", context);
		
		when(projectInfo.getVersion()).thenReturn("version1");
		assertEquals("version1", extension.getVersion());
		
		extension.version("version2");
		assertEquals("version2", extension.getVersion());
	}
	
	@Test
	public void title(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublicationExtension extension = new PublicationExtension("foo", context);
		
		when(projectInfo.getTitle()).thenReturn("test1");
		assertEquals("test1", extension.getTitle());
		
		extension.title("test2");
		assertEquals("test2", extension.getTitle());
	}

	@Test
	public void description(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublicationExtension extension = new PublicationExtension("foo", context);
		
		when(projectInfo.getDescription()).thenReturn("test1");
		assertEquals("test1", extension.getDescription());
		
		extension.description("test2");
		assertEquals("test2", extension.getDescription());
	}
}
