package ch.rhj.gradle.publish;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gradle.api.DefaultTask;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.tasks.TaskAction;

public class ReportDevelopers extends DefaultTask {
	
	private static final String FORMAT = "- %1$s (%2$s) <%3$s> %4$s";
	
	public NamedDomainObjectContainer<DeveloperExtension> developers;
	
	public ReportDevelopers() {
		
		this.setGroup("publishing");
	}

	@TaskAction
	public void reportDevelopers() {
	
		developers.forEach(dev -> {
			
			String roles = Stream.of(dev.roles).collect(Collectors.joining(", "));
			
			System.out.println(String.format(FORMAT, dev.name, roles, dev.fullName, dev.email));
		});
	}
}
