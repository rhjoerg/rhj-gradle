package ch.rhj.gradle.common;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

public class NamingSupport {

	private static final Pattern ALPHANUMERIC = Pattern.compile("^([A-Za-z0-9]+).*");
	private static final Pattern NON_ALPHANUMERIC = Pattern.compile("^([^A-Za-z0-9]+).*");
	
	public static String normalize(String name) {
		
		ArrayList<String> parts = new ArrayList<>();
		String remaining = name.trim();
		Matcher matcher;
		
		while (!remaining.isEmpty()) {
			
			matcher = NON_ALPHANUMERIC.matcher(remaining);
			
			if (matcher.matches())
				remaining = remaining.substring(matcher.group(1).length());
			
			matcher = ALPHANUMERIC.matcher(remaining);
			
			if (matcher.matches()) {
				
				String part = matcher.group(1);
				
				parts.add(part);
				remaining = remaining.substring(part.length());
			}
		}
		
		if (parts.isEmpty())
			throw new IllegalArgumentException();
		
		return parts.stream()
			.map(part -> part.substring(0, 1).toUpperCase() + part.substring(1))
			.collect(Collectors.joining(""));
	}
	
	public static String taskName(String prefix, String name) {
		
		return prefix + normalize(name);
	}
	
	public static String fileName(String name, String artifact, String version, String extension) {
		
		StringBuilder fileName = new StringBuilder();
		
		fileName.append(name);
		
		if (!Strings.isNullOrEmpty(artifact))
			fileName.append('-').append(artifact);
		
		fileName.append('-').append(version);

		if (!Strings.isNullOrEmpty(extension)) {
			
			if (!extension.startsWith("."))
				fileName.append('.');
			
			fileName.append(extension);
		}
		
		return fileName.toString();
	}
}
