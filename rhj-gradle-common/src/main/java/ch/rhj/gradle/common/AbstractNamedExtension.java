package ch.rhj.gradle.common;

public class AbstractNamedExtension<C extends ExtensionContext>
	extends AbstractExtension<C> {
	
	protected final String name;

	public AbstractNamedExtension(String name, C context) {
		
		super(context);
		
		this.name = name;
	}
	
	public String getName() {
		
		return name;
	}
}
