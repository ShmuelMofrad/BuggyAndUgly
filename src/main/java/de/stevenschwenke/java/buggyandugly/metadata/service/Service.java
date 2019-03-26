package de.stevenschwenke.java.buggyandugly.metadata.service;

import java.util.List;

import de.stevenschwenke.java.buggyandugly.metadata.MetaData;

public interface Service {
	List<MetaData> findAllMetaDataProduction(String resourceFile);
}
