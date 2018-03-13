package ch.rhj.gradle.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TaskNamesTests {

	@Test
	public void create() {
		
		assertThrows(IllegalArgumentException.class, () -> TaskNames.create("foo", ""));
		
		assertEquals("fooRhjGradleCommon", TaskNames.create("foo", "rhj-gradle-common-"));
	}
}
