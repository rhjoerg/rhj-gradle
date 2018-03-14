package ch.rhj.gradle.publish;

import javax.inject.Inject;

import ch.rhj.gradle.common.AbstractNamedExtension;

public class RepositoryExtension extends AbstractNamedExtension<PublishingContext> {

	@Inject
	public RepositoryExtension(String name, PublishingContext context) {
		
		super(name, context);

	}
}
