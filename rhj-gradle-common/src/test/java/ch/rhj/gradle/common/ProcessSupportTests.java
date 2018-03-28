package ch.rhj.gradle.common;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class ProcessSupportTests {

	@Test
	public void findExecutable() {
		
		Optional<File> file1 = ProcessSupport.findExecutable("javaw");
		Optional<File> file2 = ProcessSupport.findExecutable("javaw.exe");
		
		assertTrue(file1.isPresent() || file2.isPresent());
	}
}
