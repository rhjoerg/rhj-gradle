package ch.rhj.gradle.publish;

import java.io.File;

import org.gradle.api.Project;

import com.google.common.base.Strings;

public class PublishingSupport {

	public static File getPublishingDirectory(Project project) {
		
		return project.getBuildDir().toPath().resolve("publishing").toFile().getAbsoluteFile();
	}
	
	public static File getPublishingFile(Project project, PublishingExtension publishing, String artifact, String extension) {
		
		StringBuilder fileName = new StringBuilder();
		
		fileName.append(publishing.getName());
		
		if (!Strings.isNullOrEmpty(artifact))
			fileName.append('-').append(artifact);
		
		fileName.append('-').append(publishing.getVersion());
		
		if (!extension.startsWith("."))
			fileName.append('.');
		
		fileName.append(extension);
		
		return new File(getPublishingDirectory(project), fileName.toString());
	}
}
