package de.stevenschwenke.java.buggyandugly.metadata;

/**
 * This is MetaData Prefix
 * @author samuel.mofrad
 * @since Version 1.1-SNAPSHOT
 *
 */
public enum MetaDataPrefix {
	STAR ("*"),
	SPLIT_DELIMITER(";");
	
	private final String value;
	
	private MetaDataPrefix(final String newValue) {
		value = newValue;
	}
	
	public String getValue() {
		return value;
	}
}
