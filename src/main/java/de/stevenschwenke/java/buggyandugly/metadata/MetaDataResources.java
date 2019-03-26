package de.stevenschwenke.java.buggyandugly.metadata;

/**
 * This is MetaData Resources constants
 * @author samuel.mofrad
 * @since Version 1.1-SNAPSHOT
 *
 */
public enum MetaDataResources {
	// other entries omitted for imports that aren't used in this demo
	PRODUCTION("PRODUCTION", "module.ENUMS.importerType.label.production");

	private final String name;
	private final String resourceKey;

	MetaDataResources(String name, String resourceKey) {
        this.name = name;
        this.resourceKey = resourceKey;
    }

	public String getName() {
		return name;
	}

	public String getResourceKey() {
		return resourceKey;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "Resource key: " + this.resourceKey;
	}
}
