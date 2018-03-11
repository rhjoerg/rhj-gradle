package ch.rhj.gradle.common;

import org.gradle.api.Action;
import org.gradle.api.InvalidUserDataException;
import org.gradle.api.NamedDomainObjectContainer;

import groovy.lang.Closure;

public abstract class ForwardingNamedDomainObjectContainer<T>
		extends ForwardingNamedDomainObjectSet<T>
		implements NamedDomainObjectContainer<T> {

	protected abstract NamedDomainObjectContainer<T> delegate();

	public T create(String name) throws InvalidUserDataException {
		
		return delegate().create(name);
	}
	
	public T maybeCreate(String name) {
		
		return delegate().maybeCreate(name);
	}
	
	public T create(String name, @SuppressWarnings("rawtypes") Closure configureClosure) throws InvalidUserDataException {
		
		return delegate().create(name, configureClosure);
	}
	
	public T create(String name, Action<? super T> configureAction) throws InvalidUserDataException {
		
		return delegate().create(name, configureAction);
	}
	
	public NamedDomainObjectContainer<T> configure(@SuppressWarnings("rawtypes") Closure configureClosure) {
		
		return delegate().configure(configureClosure);
	}
}
