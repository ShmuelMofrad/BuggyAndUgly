package de.stevenschwenke.java.buggyandugly.metadata;

import java.util.Date;

import lombok.Data;

/**
 * This is class MetaData and implemented with Lombok project
 * @author samuel.mofrad
 * @since Version 1.1-SNAPSHOT
 *
 */

@Data
public class MetaData {

	private String country;
    private String type;
    private String someInternalNumber;
    private Date periodFrom;
    private Date periodUntil;
    private String filename;
    private Date creationDate;
    private Boolean archive;
}