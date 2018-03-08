package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.jupiter.api.Test;

import ch.rhj.junit.gradle.Gradle;
import ch.rhj.junit.gradle.WithGradle;

@WithGradle
public class PublishPluginTests {

	@Test
	public void publish(@Gradle GradleRunner runner) {
		
		BuildResult result = runner
				.withPluginClasspath()
				.withArguments("tasks")
				.forwardOutput()
				.build();
		
		assertEquals(TaskOutcome.SUCCESS, result.task(":tasks").getOutcome());
	}
}
