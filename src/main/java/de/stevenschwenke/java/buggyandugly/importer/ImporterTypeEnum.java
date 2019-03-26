package de.stevenschwenke.java.buggyandugly.importer;

/**
 * ImporterTypeEnum
 * 
 * @deprecated As of Refactor 0.1/2019-03-24/Refactoring/micro-refactoring and Version 1.1-SNAPSHOT Not more use please.
 * This class replaced by {@link de.stevenschwenke.java.buggyandugly.metadata.MetaDataResources} 
 * 
 * 
 * @author samuel.mofrad
 *
 */
@Deprecated
public enum ImporterTypeEnum {

    // other entries omitted for imports that aren't used in this demo
    IMPORT_PRODUCTION("PRODUCTION", "module.ENUMS.importerType.label.production");

    private final String name;
    private final String resourceKey;

    ImporterTypeEnum(String name, String resourceKey) {
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

