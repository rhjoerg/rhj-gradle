package ch.rhj.gradle.common;

import javax.inject.Inject;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;
import org.junit.jupiter.api.Test;

import ch.rhj.junit.gradle.Gradle;

public class ExtensionContextTests {

	@Test
	public void newContainer(@Gradle Project project) {
		
		ExtensionContext parent = new ExtensionContext(project);
		ExtensionContext context = new ExtensionContext(parent);
		NamedDomainObjectContainer<Entry> containers = context.newContainer(Entry.class);
		
		containers.create("test");
	}
	
	public static class Entry {
		
		public final String name;
		
		@Inject
		public Entry(String name) {
			
			this.name = name;
		}
	}
}
