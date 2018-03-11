package ch.rhj.gradle.publish;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

import ch.rhj.gradle.common.ForwardingNamedDomainObjectContainer;
import groovy.lang.Closure;

public class LicenseContainer extends ForwardingNamedDomainObjectContainer<LicenseExtension> {
	
	private final NamedDomainObjectContainer<LicenseExtension> delegate;
	
	public LicenseContainer(Project project) {
		
		this.delegate = project.container(LicenseExtension.class);
	}

	@Override
	protected NamedDomainObjectContainer<LicenseExtension> delegate() {

		return delegate;
	}

	public void withEclipse() {
		
		System.out.println("withEclipe");
	}

	@Override
	public NamedDomainObjectContainer<LicenseExtension> configure(@SuppressWarnings("rawtypes") Closure configureClosure) {
		
		configureClosure.setResolveStrategy(Closure.DELEGATE_FIRST);
		configureClosure.setDelegate(this);
		configureClosure.call();
		
		return this;
	}
}
