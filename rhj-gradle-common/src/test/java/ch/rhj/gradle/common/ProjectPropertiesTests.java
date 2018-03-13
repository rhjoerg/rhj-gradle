package ch.rhj.gradle.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.ExtraPropertiesExtension;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

import ch.rhj.junit.mockito.WithMockito;

@WithMockito
public class ProjectPropertiesTests {

	@Test
	public void get(@Mock Project project) {
		
		String defaultValue = "foo";
		
		assertTrue(defaultValue == ProjectProperties.get(project, "foo", defaultValue));
		
		when(project.hasProperty("foo")).thenReturn(true);
		when(project.property("foo")).thenReturn("bar");
		
		assertEquals("bar", ProjectProperties.get(project, "foo", defaultValue));
	}
	
	@Test
	public void set(@Mock Project project, @Mock ExtensionContainer extensions, @Mock ExtraPropertiesExtension ext) {
		
		when(project.hasProperty("foo")).thenReturn(true);
		
		ProjectProperties.set(project, "foo", "bar");
		verify(project).setProperty("foo", "bar");
		
		reset(project);
		when(project.hasProperty("foo")).thenReturn(false);
		when(project.getExtensions()).thenReturn(extensions);
		when(extensions.getExtraProperties()).thenReturn(ext);
		
		ProjectProperties.set(project, "foo", "bar");
		verify(ext).set("foo", "bar");
	}
	
	@Test
	public void setIfAbsent(@Mock Project project, @Mock ExtensionContainer extensions, @Mock ExtraPropertiesExtension ext) {
		
		when(project.hasProperty("foo")).thenReturn(true);
		
		ProjectProperties.setIfAbsent(project, "foo", "bar");
		verify(project).setProperty("foo", "bar");
		
		reset(project);
		when(project.hasProperty("foo")).thenReturn(true);
		when(project.property("foo")).thenReturn("bar");
		
		ProjectProperties.setIfAbsent(project, "foo", "bar");
		verify(project, never()).setProperty(ArgumentMatchers.anyString(), ArgumentMatchers.any());
		
		reset(project);
		when(project.hasProperty("foo")).thenReturn(false);
		when(project.getExtensions()).thenReturn(extensions);
		when(extensions.getExtraProperties()).thenReturn(ext);
		
		ProjectProperties.setIfAbsent(project, "foo", "bar");
		verify(ext).set("foo", "bar");
	}
}
