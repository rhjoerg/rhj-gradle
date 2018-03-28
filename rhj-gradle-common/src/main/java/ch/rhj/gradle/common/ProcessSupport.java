package ch.rhj.gradle.common;

import java.io.File;
import java.util.Optional;
import java.util.stream.Stream;

public class ProcessSupport {

	public static Optional<File> findExecutable(String name) {
		
		return Stream.of(System.getenv("PATH").split(File.pathSeparator))
			.map(s -> s.trim())
			.filter(s -> !s.isEmpty())
			.map(s -> new File(s))
			.filter(d -> d.isDirectory())
			.map(d -> new File(d, name))
			.filter(f -> f.exists() && f.canExecute())
			.map(f -> f.getAbsoluteFile())
			.findFirst();
	}
}
