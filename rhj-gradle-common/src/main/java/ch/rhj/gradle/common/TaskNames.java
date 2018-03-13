package ch.rhj.gradle.common;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TaskNames {
	
	private static final Pattern ALPHANUMERIC = Pattern.compile("^([A-Za-z0-9]+).*");
	private static final Pattern NON_ALPHANUMERIC = Pattern.compile("^([^A-Za-z0-9]+).*");

	public static String create(String prefix, String rawName) {
		
		ArrayList<String> parts = new ArrayList<>();
		String remaining = rawName.trim();
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
		
		return prefix + parts.stream()
			.map(part -> part.substring(0, 1).toUpperCase() + part.substring(1))
			.collect(Collectors.joining(""));
	}
}
