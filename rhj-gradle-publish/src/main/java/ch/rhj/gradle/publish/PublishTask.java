package ch.rhj.gradle.publish;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class PublishTask extends DefaultTask {

	@TaskAction
	public void publish() {
		
		System.out.println("publishing");
	}
}
