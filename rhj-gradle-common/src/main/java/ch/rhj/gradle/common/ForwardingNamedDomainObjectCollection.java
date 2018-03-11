package ch.rhj.gradle.common;

import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectCollection;
import org.gradle.api.Namer;
import org.gradle.api.Rule;
import org.gradle.api.UnknownDomainObjectException;
import org.gradle.api.specs.Spec;

import groovy.lang.Closure;

public abstract class ForwardingNamedDomainObjectCollection<T>
		extends ForwardingDomainObjectCollection<T>
		implements NamedDomainObjectCollection<T> {

	protected abstract NamedDomainObjectCollection<T> delegate();
	
	public boolean add(T e) {
		
		return delegate().add(e);
	}
	
	public boolean addAll(Collection<? extends T> c) {
		
		return delegate().addAll(c);
	}
	
	public Namer<T> getNamer() {
		
		return delegate().getNamer();
	}
	
	public SortedMap<String, T> getAsMap() {
		
		return delegate().getAsMap();
	}
	
	public SortedSet<String> getNames() {
		
		return delegate().getNames();
	}
	
	public T findByName(String name) {
		
		return delegate().findByName(name);
	}
	
	public T getByName(String name) throws UnknownDomainObjectException {
		
		return delegate().getByName(name);
	}
	
	public T getByName(String name, @SuppressWarnings("rawtypes") Closure configureClosure) throws UnknownDomainObjectException {
		
		return delegate().getByName(name, configureClosure);
	}
	
	public T getByName(String name, Action<? super T> configureAction) throws UnknownDomainObjectException {
		
		return delegate().getByName(name, configureAction);
	}
	
	public T getAt(String name) throws UnknownDomainObjectException {
		
		return delegate().getAt(name);
	}
	
	public Rule addRule(Rule rule) {
		
		return delegate().addRule(rule);
	}
	
	public Rule addRule(String description, @SuppressWarnings("rawtypes") Closure ruleAction) {
		
		return delegate().addRule(description, ruleAction);
	}
	
	public Rule addRule(String description, Action<String> ruleAction) {
		
		return delegate().addRule(description, ruleAction);
	}
	
	public List<Rule> getRules() {
		
		return delegate().getRules();
	}
	
	public <S extends T> NamedDomainObjectCollection<S> withType(Class<S> type) {
		
		return delegate().withType(type);
	}
	
	public NamedDomainObjectCollection<T> matching(Spec<? super T> spec) {
		
		return delegate().matching(spec);
	}
	
	public NamedDomainObjectCollection<T> matching(@SuppressWarnings("rawtypes") Closure spec) {
		
		return delegate().matching(spec);
	}
}
