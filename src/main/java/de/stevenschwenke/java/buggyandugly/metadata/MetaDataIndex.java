package de.stevenschwenke.java.buggyandugly.metadata;

/**
 * This is MetaData Index
 * @author samuel.mofrad
 * @since Version 1.1-SNAPSHOT
 *
 */
public enum MetaDataIndex {
	COUNTRY (0),
    TYPE (1),
    PRODUCTION_PRODUCED (2),
    SOME_INTERNAL_NUMBER (3),
    SOME_INTERNAL_NUMBER_SECOND (4),
    PERIOD_FROM (5),
    PERIOD_UNTIL (6);
	
	private final int value;
	
	private MetaDataIndex(final int newValue) {
		value = newValue;
	}
	
	public int getValue() {
		return value;
	}
}
