package ch.rhj.gradle.publish;

import java.io.File;
import java.io.IOException;

import org.apache.maven.model.License;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.DefaultModelWriter;
import org.apache.maven.model.io.ModelWriter;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class CreateMavenPomTask extends DefaultTask {
	
	protected PublishingExtension publishing;
	
	public CreateMavenPomTask() {
		
		this.setGroup("publishing");
	}
	
	@TaskAction
	public void createMavenPom() throws IOException {
		
		Model model = new Model();
		
		setProjectProperties(model);
		setLicences(model);
		
		write(model);
	}
	
	private void setProjectProperties(Model model) {
		
		model.setModelVersion("4.0.0");
		model.setGroupId(publishing.getGroup());
		model.setArtifactId(publishing.getName());
		model.setVersion(publishing.getVersion());
		model.setPackaging(publishing.getPackaging());
		
		model.setName(publishing.getTitle());
		model.setDescription(publishing.getDescription());
		model.setUrl(publishing.getSite());
		model.setInceptionYear(publishing.getYear());
	}
	
	private void setLicences(Model model) {
		
		publishing.getLicenses().all(lic -> {
			
			License license = new License();
			
			license.setName(lic.title);
			license.setUrl(lic.url);
			license.setDistribution(lic.distribution);
			
			model.addLicense(license);
		});
	}
	
	private void write(Model model) throws IOException {
		
		ModelWriter writer = new DefaultModelWriter();
		File file = PublishingSupport.getPublishingFile(getProject(), publishing, null, ".pom");
		
		writer.write(file, null, model);
	}
}
