package ch.rhj.gradle.publish;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.gradle.api.Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class DefaultInfoTests {

	@Test
	public void assertThrowing(@Mock Project project) {
		
		DefaultInfo defaultInfo = new DefaultInfo(project);
		
		assertThrows(IllegalStateException.class, () -> defaultInfo.getParentProjectInfo());
	}
}
