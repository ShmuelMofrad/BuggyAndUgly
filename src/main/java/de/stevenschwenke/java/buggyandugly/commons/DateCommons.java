package de.stevenschwenke.java.buggyandugly.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DateCommons {

	private static final Logger LOGGER = LogManager.getLogger();
	
	/**
     * Format of String: yyyy-mm-dd'T'HH:mm:ss
     */
    public static Date stringToDate(final String formattedString) {
        final String importantPartOfDate = formattedString.substring(0, 19);
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return sdf.parse(importantPartOfDate);
        } catch (final ParseException e) {
        	LOGGER.error("Could not parse from String to Date", e);
        }
        return new Date();
    }

    public static Date convertYearStringToDate(final String year) {
        if(year==null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        try {
            return sdf.parse(year);
        } catch (ParseException e) {
        	LOGGER.error("Could not parse from String to Date", e);
        }
        return null;
    }
}