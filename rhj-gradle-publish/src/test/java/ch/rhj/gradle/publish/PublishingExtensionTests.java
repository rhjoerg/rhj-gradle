package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.NamedDomainObjectFactory;
import org.gradle.api.Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.google.common.collect.ImmutableSortedSet;

public class PublishingExtensionTests {
	
	@Test
	public void group(@Mock Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.group("group1");
		assertEquals("group1", extension.getGroup());
		extension.group(null);
		
		when(parent.getGroup()).thenReturn("group2");
		assertEquals("group2", extension.getGroup());
	}
	
	@Test
	public void name(@Mock Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.name("name1");
		assertEquals("name1", extension.getName());
		extension.name(null);
		
		when(parent.getName()).thenReturn("name2");
		assertEquals("name2", extension.getName());
	}

	@Test
	public void version(@Mock Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.version("version1");
		assertEquals("version1", extension.getVersion());
		extension.version(null);
		
		when(parent.getVersion()).thenReturn("version2");
		assertEquals("version2", extension.getVersion());
	}

	@Test
	public void title(@Mock Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.title("title1");
		assertEquals("title1", extension.getTitle());
		extension.title(null);
		
		when(parent.getTitle()).thenReturn("title2");
		assertEquals("title2", extension.getTitle());
	}
	
	@Test
	public void description(@Mock Project project, @Mock ProjectInfo parent) {
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.description("description1");
		assertEquals("description1", extension.getDescription());
		extension.description(null);
		
		when(parent.getDescription()).thenReturn("description2");
		assertEquals("description2", extension.getDescription());
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void publications(@Mock Project project, @Mock ProjectInfo parent,
			@Mock NamedDomainObjectContainer<PublicationExtension> publications) {
		
		when(project.container(eq(PublicationExtension.class), isA(NamedDomainObjectFactory.class))).thenReturn(publications);
		
		PublishingExtension extension = new PublishingExtension(project, parent);
		
		extension.publications(pubs -> { pubs.create("test"); });
		
		when(publications.getNames()).thenReturn(ImmutableSortedSet.of("test"));
		assertTrue(extension.getPublications().getNames().contains("test"));
	}
}
