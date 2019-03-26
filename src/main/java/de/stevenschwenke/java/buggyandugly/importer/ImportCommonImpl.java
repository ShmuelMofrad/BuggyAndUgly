package de.stevenschwenke.java.buggyandugly.importer;

/**
 * ImportCommonImpl
 * 
 * @deprecated As of Refactor 0.1/2019-03-24/Refactoring/micro-refactoring and Version 1.1-SNAPSHOT Not more use please.
 * This class replaced by {@link de.stevenschwenke.java.buggyandugly.metadata.MetaDataIndex} and {@link de.stevenschwenke.java.buggyandugly.metadata.MetaDataPrefix} 
 * 
 * 
 * @author samuel.mofrad
 *
 */
@Deprecated
public class ImportCommonImpl {
    // Lines that begin with a "*" are metadata
    static final String METADATA_PREFIX = "*";

    static final int METADATA_INDEX_COUNTRY = 0;
    static final int METADATA_INDEX_TYPE = 1;
    static final int METADATA_INDEX_PRODUCTION_PRODUCED = 2;
    static final int METADATA_INDEX_SOME_INTERNAL_NUMBER = 3;
    static final int METADATA_INDEX_SOME_INTERNAL_NUMBER_2 = 4;
    static final int METADATA_INDEX_PERIOD_FROM = 5;
    static final int METADATA_INDEX_PERIOD_UNTIL = 6;

}
