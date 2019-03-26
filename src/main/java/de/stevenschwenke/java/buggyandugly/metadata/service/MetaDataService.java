package de.stevenschwenke.java.buggyandugly.metadata.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.stevenschwenke.java.buggyandugly.metadata.MetaData;
import de.stevenschwenke.java.buggyandugly.metadata.MetaDataIndex;
import de.stevenschwenke.java.buggyandugly.metadata.MetaDataPrefix;
import de.stevenschwenke.java.buggyandugly.metadata.MetaDataResources;
/**
 * *********************
 * *
 * * 	not finished yet, I will update this status of my task, as soon as I finish it.
 * *
 * *********************
 * This is MetaData Service 
 * @author samuel.mofrad
 *
 */
public class MetaDataService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public List<MetaData> findAllMetaDataProduction(String resourceFile) {
		//TODO Should be implemented.
		throw new UnsupportedOperationException("not yet implemented and should be implemented!");
	}

	private String[] lineSplitter(String line) {
		return line.split(MetaDataPrefix.SPLIT_DELIMITER.getValue());
	}

	private boolean isProduction(String[] productionLine) {
		final int PRODUCTION_INDEX = MetaDataIndex.PRODUCTION_PRODUCED.getValue();
		if (productionLine.length <= PRODUCTION_INDEX) {
			return false;
		} else {
			return MetaDataResources.PRODUCTION.getName().equals(productionLine[PRODUCTION_INDEX].trim());
		}
	}
}
