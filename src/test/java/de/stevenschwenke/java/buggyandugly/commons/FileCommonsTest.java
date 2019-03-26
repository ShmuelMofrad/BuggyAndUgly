package de.stevenschwenke.java.buggyandugly.commons;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
/**
 * This is a Test class for {@link de.stevenschwenke.java.buggyandugly.commons.FileCommons}
 * <br><br>
 * This test would like to test <b>FileCommons</b> class utils methods.
 * 
 * @author samuel.mofrad
 *
 */

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Test - FileCommons")
public class FileCommonsTest {

	File resourceFile = null;
	String resourceFileName = "test_import.txt";
	
	File emptyFile = null;
	String emptyResourceFileName = "empty.txt";
	
	@BeforeAll
	void resourceFile() {
		ClassLoader classLoader = this.getClass().getClassLoader();
        resourceFile =  new File(classLoader.getResource(resourceFileName).getFile());
        emptyFile = new File(classLoader.getResource(emptyResourceFileName).getFile());
	}
	
	@DisplayName("Test => can load Resource File")
	@Test
	public void loadResourceFile() {
        assertNotNull(resourceFile);
        assertTrue(resourceFile.exists());
        assertNotNull(emptyFile);
        assertTrue(emptyFile.exists());
	}

	@DisplayName("Test => can retrive path")
	@Test
	public void testPath() throws URISyntaxException {
		assertNotNull(FileCommons.getResourceFilePath(resourceFileName));
		assertNotNull(FileCommons.getResourceFilePath(emptyResourceFileName));
	}
	
	@DisplayName("Test => can retrive lines as UTF-8 in Path")
	@Test
	public void testLines() throws IOException, URISyntaxException {
		assertNotNull(FileCommons.retrieveAllLinesAsUTF8(FileCommons.getResourceFilePath(resourceFileName)));
		assertThat(FileCommons.retrieveAllLinesAsUTF8(FileCommons.getResourceFilePath(emptyResourceFileName)).count()).isZero();
	}
	
	@DisplayName("Test => can retrive lines as UTF-8 in File")
	@Test
	public void testLinesFile() throws IOException, URISyntaxException {
		assertNotNull(FileCommons.retrieveAllLinesAsUTF8(FileCommons.getFile(resourceFileName)));
	}
	
	@DisplayName("Test => is File Valid")
	@Test
	public void testIsFileValid(){
		assertTrue(FileCommons.isFileValid(resourceFileName));
		// Test empty file
		assertFalse(FileCommons.isFileValid(emptyResourceFileName));

	}
	
	@DisplayName("Test => search and get File")
	@Test
	public void testgetFile(){
		assertNotNull(FileCommons.getFile(resourceFileName));
		// Test empty file
		assertNull(FileCommons.getFile(emptyResourceFileName));
	}
	
}
