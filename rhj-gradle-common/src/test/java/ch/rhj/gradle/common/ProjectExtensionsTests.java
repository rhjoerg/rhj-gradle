package ch.rhj.gradle.common;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ch.rhj.junit.mockito.WithMockito;

@WithMockito
public class ProjectExtensionsTests {
	
	public static class Foo {
		
		public final String name;

		public Foo(String name) {
			
			this.name = name;
		}
	}

	@Test
	public void getExtension(@Mock Project project, @Mock ExtensionContainer extensions) {
		
		Foo foo = new Foo("foo");
		
		when(project.getExtensions()).thenReturn(extensions);
		when(extensions.getByName("foo")).thenReturn(foo);
		
		assertTrue(foo == ProjectExtensions.getExtension(project, "foo", Foo.class));
	}
	
	@Test
	public void getContainer(@Mock Project project, @Mock ExtensionContainer extensions, @Mock NamedDomainObjectContainer<Foo> foos) {
		
		when(project.getExtensions()).thenReturn(extensions);
		when(extensions.getByName("foos")).thenReturn(foos);
		
		assertTrue(foos == ProjectExtensions.getContainer(project, "foos", Foo.class));
	}
}
