package ch.rhj.gradle.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NamingSupportTests {

	@Test
	public void taskName() {
		
		assertThrows(IllegalArgumentException.class, () -> NamingSupport.taskName("a", ""));
		
		assertEquals("aBcDe", NamingSupport.taskName("a", "-bc-de"));
	}
	
	@Test
	public void fileName() {
		
		assertEquals("name", NamingSupport.fileName("name", null, null, null));
		assertEquals("name-artifact", NamingSupport.fileName("name", "artifact", null, null));
		assertEquals("name-version", NamingSupport.fileName("name", null, "version", null));
		assertEquals("name.extension", NamingSupport.fileName("name", null, null, "extension"));
		assertEquals("name.extension", NamingSupport.fileName("name", null, null, ".extension"));
	}
}
