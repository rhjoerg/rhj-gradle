package ch.rhj.gradle.publish;

import java.io.File;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.DefaultModelWriter;
import org.apache.maven.model.io.ModelWriter;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import ch.rhj.gradle.common.NamingSupport;

public class GenerateMavenPomTask extends DefaultTask {
	
	@Input
	public PublicationExtension publication;
	
	@TaskAction
	public void generateMavenPom() throws IOException {
		
		Model model = new Model();
		
		write(model);
	}
	
	private void write(Model model) throws IOException {
		
		ModelWriter writer = new DefaultModelWriter();
		String fileName = NamingSupport.fileName(publication.getName(), null, publication.getVersion(), ".pom");
		File output = new File(publication.getOutputDirectory(), fileName);
		
		writer.write(output, null, model);
	}
}
