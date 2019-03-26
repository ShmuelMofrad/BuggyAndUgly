package de.stevenschwenke.java.buggyandugly.metadata.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * This is a Test class for
 * {@link de.stevenschwenke.java.buggyandugly.metadata.service.MetaDataService}
 * <br>
 * <br>
 * This test would like to test private methode in <b>MetaDataService</b>
 * because is <b>TDD</b> test.
 * 
 * @author samuel.mofrad
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Test - MetaData Service")
public class TestMetaDataService {

	static MetaDataService service;

	@BeforeAll
	void initialData() {
		service = new MetaDataService();
	}

	@Test
	@DisplayName("MetaData Service - private method LineSplitter")
	public void testLineSplitter() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		String line = "* GERMANY   ;Ultra Fast Bike   ;PRODUCTION        ;123 ;7;2015;2016;";
		Method method = MetaDataService.class.getDeclaredMethod("lineSplitter", String.class);
		method.setAccessible(true);
		String[] output = (String[]) method.invoke(service, line);
		assertThat(output).isNotNull();
		assertThat(output).isNotEmpty();
		assertThat(output).hasSize(7);
	}

	@Test
	@DisplayName("MetaData Service - private method isProduction")
	public void testIsProduction() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		String[] PRODUCTION_LINE = {"* GERMANY   ", "Ultra Fast Bike   ", "PRODUCTION        ", "123 ", "7", "2015", "2016"};
		String[] NORMAL_LINE = {"* GERMANY   ", "City Bike ", "PRODUCED       ", "456 ", "L", "2017", "2023"};
		
		Method method = MetaDataService.class.getDeclaredMethod("isProduction", String[].class);
		method.setAccessible(true);
		boolean output = (boolean) method.invoke(service, new Object[] {PRODUCTION_LINE});
		assertThat(output).isTrue();
		
		output = (boolean) method.invoke(service, new Object[] {NORMAL_LINE});
		assertThat(output).isFalse();
	}
}
