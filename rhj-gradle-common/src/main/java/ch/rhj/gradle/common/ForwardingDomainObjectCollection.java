package ch.rhj.gradle.common;

import java.util.Collection;

import org.gradle.api.Action;
import org.gradle.api.DomainObjectCollection;
import org.gradle.api.specs.Spec;

import com.google.common.collect.ForwardingCollection;

import groovy.lang.Closure;

public abstract class ForwardingDomainObjectCollection<T>
		extends ForwardingCollection<T> 
		implements DomainObjectCollection<T> {

	protected abstract DomainObjectCollection<T> delegate();
	
	public <S extends T> DomainObjectCollection<S> withType(Class<S> type) {
		
		return delegate().withType(type);
	}
	
	public <S extends T> DomainObjectCollection<S> withType(Class<S> type, Action<? super S> configureAction) {
		
		return delegate().withType(type, configureAction);
	}
	
	public <S extends T> DomainObjectCollection<S> withType(Class<S> type, @SuppressWarnings("rawtypes") Closure configureClosure) {
		
		return delegate().withType(type, configureClosure);
	}
	
	public DomainObjectCollection<T> matching(Spec<? super T> spec) {
		
		return delegate().matching(spec);
	}
	
	public DomainObjectCollection<T> matching(@SuppressWarnings("rawtypes") Closure spec) {
		
		return delegate().matching(spec);
	}
	
	public Action<? super T> whenObjectAdded(Action<? super T> action) {
		
		return delegate().whenObjectAdded(action);
	}
	
	public void whenObjectAdded(@SuppressWarnings("rawtypes") Closure action) {
		
		delegate().whenObjectAdded(action);
	}
	
	public Action<? super T> whenObjectRemoved(Action<? super T> action) {
		
		return delegate().whenObjectRemoved(action);
	}
	
	public void whenObjectRemoved(@SuppressWarnings("rawtypes") Closure action) {
		
		delegate().whenObjectRemoved(action);
	}
	
	public void all(Action<? super T> action) {
		
		delegate().all(action);
	}
	
	public void all(@SuppressWarnings("rawtypes") Closure action) {
		
		delegate().all(action);
	}
	
	public Collection<T> findAll(@SuppressWarnings("rawtypes") Closure spec) {
		
		return delegate().findAll(spec);
	}
}
