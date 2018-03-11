package ch.rhj.gradle.common;

import java.util.Set;

import org.gradle.api.NamedDomainObjectSet;
import org.gradle.api.specs.Spec;

import groovy.lang.Closure;

public abstract class ForwardingNamedDomainObjectSet<T>
		extends ForwardingNamedDomainObjectCollection<T>
		implements NamedDomainObjectSet<T> {

	protected abstract NamedDomainObjectSet<T> delegate();
	
	public <S extends T> NamedDomainObjectSet<S> withType(Class<S> type) {
		
		return delegate().withType(type);
	}
	
	public NamedDomainObjectSet<T> matching(Spec<? super T> spec) {
		
		return delegate().matching(spec);
	}
	
	public NamedDomainObjectSet<T> matching(@SuppressWarnings("rawtypes") Closure spec) {
		
		return delegate().matching(spec);
	}
	
	public Set<T> findAll(@SuppressWarnings("rawtypes") Closure spec) {
		
		return delegate().findAll(spec);
	}
}
