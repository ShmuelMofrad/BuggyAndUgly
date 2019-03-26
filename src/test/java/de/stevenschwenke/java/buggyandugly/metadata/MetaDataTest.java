package de.stevenschwenke.java.buggyandugly.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import de.stevenschwenke.java.buggyandugly.metadata.MetaData;

/**
 * This is a Test class for {@link de.stevenschwenke.java.buggyandugly.metadata.MetaData}
 * <br><br>
 * This test would like to test <b>MetaData</b> class getter and setter with lombok project.
 * 
 * @author samuel.mofrad
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Test - MetaData")
public class MetaDataTest {
	
	MetaData metadata;
	
	@BeforeAll
	void initialData() {
		metadata = new MetaData();
		metadata.setCountry("GERMANY");
		metadata.setType("City Bike");
		metadata.setSomeInternalNumber("123  7, 789  7, 456  L");
		metadata.setPeriodFrom(getTodayTime());
		metadata.setPeriodUntil(getTomorrowTime());
		metadata.setFilename("TestFilen.csv");
		metadata.setCreationDate(getTodayTime());
		metadata.setArchive(true);
	}
	
	@Test
	@DisplayName("MetaData - Country")
	public void countryTest() {
		assertEquals(metadata.getCountry(), "GERMANY");
	}
	
	@Test
	@DisplayName("MetaData - Type")
	public void typeTest() {
		assertEquals(metadata.getType(), "City Bike");
	}
	
	@Test
	@DisplayName("MetaData - Creation Date")
	public void CreationDateTest() {
		assertEquals(format(metadata.getCreationDate()), format(getTodayTime()));
	}
	
	@Test
	@DisplayName("MetaData - Some Internal Number")
	public void SomeInternalNumberTest() {
		assertEquals(metadata.getSomeInternalNumber(), "123  7, 789  7, 456  L");
	}

	private Date getTodayTime() {
		return Calendar.getInstance().getTime();
	}
	
	private Date getTomorrowTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1); 
		return calendar.getTime();
	}
	
	// format just date without time
	private String format(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
}
