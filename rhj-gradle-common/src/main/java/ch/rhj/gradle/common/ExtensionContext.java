package ch.rhj.gradle.common;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

public class ExtensionContext {

	public final Project project;
	
	public ExtensionContext(Project project) {
		
		this.project = project;
	}
	
	public ExtensionContext(ExtensionContext parent) {
		
		this(parent.project);
	}
	
	public <T> T newObject(Class<T> type, Object... args) {
		
		return project.getObjects().newInstance(type, args);
	}
	
	public <T> NamedDomainObjectContainer<T> newContainer(Class<T> type, Object... args) {
		
		return project.container(type, name -> {
			
			Object[] nameAndArgs = new Object[args.length + 1];
			
			nameAndArgs[0] = name;
			System.arraycopy(args, 0, nameAndArgs, 1, args.length);
			
			return newObject(type, nameAndArgs);
		});
	}
}
