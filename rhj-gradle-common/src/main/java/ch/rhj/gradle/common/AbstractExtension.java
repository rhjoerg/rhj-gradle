package ch.rhj.gradle.common;

import org.gradle.api.NamedDomainObjectContainer;

public abstract class AbstractExtension<C extends ExtensionContext> {

	protected final C context;
	
	public AbstractExtension(C context) {
		
		this.context = context;
	}
	
	protected <T> T newObject(Class<T> type, Object... args) {
		
		return context.newObject(type, args);
	}
	
	protected <T> NamedDomainObjectContainer<T> newContainer(Class<T> type, Object... args) {
		
		return context.newContainer(type, args);
	}
}
