package ch.rhj.gradle.publish;

import org.gradle.api.Project;

import ch.rhj.gradle.common.ProjectProperties;

public class DefaultProjectInfo implements ProjectInfo {

	private final Project project;

	public DefaultProjectInfo(Project project) {
		
		this.project = project;
	}

	@Override
	public String getGroup() {

		return project.getGroup().toString();
	}

	@Override
	public String getName() {
		
		return project.getName();
	}

	@Override
	public String getVersion() {

		return project.getVersion().toString();
	}

	@Override
	public String getTitle() {
		
		return ProjectProperties.get(project, "title", getName()).toString();
	}

	@Override
	public String getDescription() {
		
		return ProjectProperties.get(project, "description", getTitle()).toString();
	}
}
