package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.gradle.api.Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ch.rhj.junit.gradle.Gradle;

public class PublishingExtensionTests {
	
	@Mock
	ProjectInfo projectInfo;
	
	@Test
	public void group(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublishingExtension extension = context.newObject(PublishingExtension.class, context);
		
		when(projectInfo.getGroup()).thenReturn("group1");
		assertEquals("group1", extension.getGroup());
		
		extension.group("group2");
		assertEquals("group2", extension.getGroup());
	}
	
	@Test
	public void name(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublishingExtension extension = context.newObject(PublishingExtension.class, context);
		
		when(projectInfo.getName()).thenReturn("name1");
		assertEquals("name1", extension.getName());
		
		extension.name("name2");
		assertEquals("name2", extension.getName());
	}

	@Test
	public void version(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublishingExtension extension = context.newObject(PublishingExtension.class, context);
		
		when(projectInfo.getVersion()).thenReturn("version1");
		assertEquals("version1", extension.getVersion());
		
		extension.version("version2");
		assertEquals("version2", extension.getVersion());
	}

	@Test
	public void title(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublishingExtension extension = context.newObject(PublishingExtension.class, context);
		
		when(projectInfo.getTitle()).thenReturn("title1");
		assertEquals("title1", extension.getTitle());
		
		extension.title("title2");
		assertEquals("title2", extension.getTitle());
	}
	
	@Test
	public void description(@Gradle Project project) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublishingExtension extension = context.newObject(PublishingExtension.class, context);
		
		when(projectInfo.getDescription()).thenReturn("description1");
		assertEquals("description1", extension.getDescription());
				
		extension.description("description2");
		assertEquals("description2", extension.getDescription());
	}
	
	@Test
	public void publications(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublishingExtension extension = context.newObject(PublishingExtension.class, context);
						
		extension.publications(pubs -> { pubs.create("test"); });
		assertNotNull(extension.getPublications().getByName("test"));
	}
	
	@Test
	public void repositories(@Gradle Project project, @Mock ProjectInfo parent) {
		
		PublishingContext context = new PublishingContext(project, projectInfo);
		PublishingExtension extension = context.newObject(PublishingExtension.class, context);
						
		extension.repositories(reps -> { reps.create("test"); });
		assertNotNull(extension.getRepositories().getByName("test"));
	}
}
