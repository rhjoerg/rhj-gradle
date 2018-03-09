package ch.rhj.gradle.publish;

import java.io.File;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.DefaultModelWriter;
import org.apache.maven.model.io.ModelWriter;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtraPropertiesExtension;
import org.gradle.api.tasks.TaskAction;

public class CreatePomTask extends DefaultTask {
	
	public CreatePomTask() {
		
		this.setGroup("publishing");
	}

	@TaskAction
	public void createPom() throws IOException {
		
		Project project = getProject();
		
		File buildDir = project.getBuildDir();
		File publishingDir = new File(buildDir, "publishing");
		String pomName = project.getName() + "-" + project.getVersion() + ".pom";
		File pomFile = new File(publishingDir, pomName);
		
		Model model = new Model();
		ModelWriter writer = new DefaultModelWriter();
		ExtraPropertiesExtension properties = project.getExtensions().findByType(ExtraPropertiesExtension.class);

		
		model.setModelVersion("4.0.0");
		model.setGroupId(project.getGroup().toString());
		model.setArtifactId(project.getName());
		model.setVersion(project.getVersion().toString());
		model.setName(properties.get("title").toString());
		model.setDescription(properties.get("description").toString());
		
		writer.write(pomFile, null, model);
	}
}
