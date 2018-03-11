package ch.rhj.gradle.publish;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

import com.google.common.base.Strings;

import groovy.lang.Closure;

public class PublishingExtension {
	
	private Project project;
	
	private String name;
	private String title;
	private String description;
	
	private String group;
	private String version;
	private String packaging;
	
	private String site;
	private String year;
	
	private final NamedDomainObjectContainer<LicenseExtension> licenses;
	
	public PublishingExtension(Project project) {
		
		this.project = project;
		this.licenses = project.container(LicenseExtension.class);
	}
	
	public String getName() {
		
		return Strings.isNullOrEmpty(name) ? project.getName() : name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getTitle() {
		
		return Strings.isNullOrEmpty(title) ? getName() : title;
	}
	
	public void setTitle(String title) {
		
		this.title = title;
	}
	
	public String getDescription() {
		
		return Strings.isNullOrEmpty(description) ? getTitle() : description;
	}
	
	public void setDescription(String description) {
		
		this.description = description;
	}
	
	public String getGroup() {
		
		return Strings.isNullOrEmpty(group) ? project.getGroup().toString() : group;
	}
	
	public void setGroup(String group) {
		
		this.group = group;
	}

	public String getVersion() {
		
		return Strings.isNullOrEmpty(version) ? project.getVersion().toString() : version;
	}

	public void setVersion(String version) {
		
		this.version = version;
	}
	
	public String getPackaging() {
		
		if (!Strings.isNullOrEmpty(packaging))
			return packaging;
		
		if (project.getTasks().getNames().contains("jar"))
			return "jar";
		
		return "pom";
	}

	public void setPackaging(String packaging) {
		
		this.packaging = packaging;
	}

	public String getSite() {
		
		return site;
	}

	public void setSite(String site) {
		
		this.site = site;
	}

	public String getYear() {
		
		if (!Strings.isNullOrEmpty(year))
			return year;
		
		return Integer.toString(GregorianCalendar.getInstance().get(Calendar.YEAR));
	}

	public void setYear(String year) {
		
		this.year = year;
	}
	
	public NamedDomainObjectContainer<LicenseExtension> getLicenses() {
		
		return licenses;
	}

	public void licenses(@SuppressWarnings("rawtypes") final Closure configureClosure) {
		
		licenses.configure(configureClosure);
	}
}
