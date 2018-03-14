package ch.rhj.gradle.publish;

import org.gradle.api.Project;

import ch.rhj.gradle.common.ExtensionContext;

public class PublishingContext extends ExtensionContext {
	
	public final ProjectInfo projectInfo;

	public PublishingContext(Project project, ProjectInfo projectInfo) {
		
		super(project);
		
		this.projectInfo = projectInfo;
	}
	
	public PublishingContext(PublishingContext parent, ProjectInfo projectInfo) {
		
		super(parent);
		
		this.projectInfo = projectInfo;
	}
}
