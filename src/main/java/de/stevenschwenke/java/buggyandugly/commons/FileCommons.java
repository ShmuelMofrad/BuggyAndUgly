package de.stevenschwenke.java.buggyandugly.commons;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * This class is commons class for useful File / IO methods 
 * 
 * @author samuel.mofrad
 * 
 * @since Version 1.1-SNAPSHOT
 *
 */
public class FileCommons {

	static final String CLASS_PATH = System.getProperty("java.class.path");
	static final String PATH_SEPARATOR = System.getProperty("path.separator");
	
	/**
	 * this method get String as filename and return {@link java.nio.file.Path }
	 * @param filePath
	 * @return Path
	 * @throws URISyntaxException 
	 */
	public static Path getResourceFilePath(String filePath) throws URISyntaxException {
		return Paths.get(FileCommons.class.getClassLoader().getResource(filePath).toURI());
	}
	
	/**
	 * this method get resource filename and returen resource file
	 * @param fileName
	 * @return File
	 */
	public static File getResourceFile(String fileName) {
		ClassLoader classLoader = FileCommons.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
	}
	
	/**
	 * get a file name and search this file in classpath then return File if find it and it's not a empty File.
	 * @param fileName
	 * @return File
	 */
	public static File getFile(String fileName) {
		File  targetFile;
		StringTokenizer tokenizer = getTokenizer(CLASS_PATH, PATH_SEPARATOR);
		while(tokenizer.hasMoreTokens()) {
			String element = tokenizer.nextToken();
			File tempSurvey = new File(element);
			File tempAbsolute = tempSurvey.getAbsoluteFile();
			if(isFile(tempAbsolute)) {
				targetFile = getTargetFile(null, tempAbsolute.getParent(), fileName);
				if(targetFile.exists() && hasLines(targetFile)) {
					return targetFile; 
				}
			} else {
				targetFile = getTargetFile(tempSurvey, null, fileName);
				if(targetFile.exists() && hasLines(targetFile)) {
					return targetFile; 
				} 
			}
		}
		return null;
	}
	
	/**
	 * this method get file path and return all lines as UTF-8
	 * @param file {@link java.nio.file.Path}
	 * @return {@link java.util.stream.Stream } all lines in file as String
	 * @throws IOException
	 */
	public static Stream<String> retrieveAllLinesAsUTF8(Path path) throws IOException {
		return Files.lines(path);
	}
	
	/**
	 * this method get file and return all lines as UTF-8
	 * @param file
	 * @return File Lines as <code>Stream < String ></code>  
	 * @throws IOException
	 */
	public static Stream<String> retrieveAllLinesAsUTF8(File file) throws IOException {
		return retrieveAllLinesAsUTF8(file.toPath());
	}
		
	/**
	 * this method get file path and return all lines
	 * @param file {@link java.nio.file.Path}
	 * @return {@link java.util.stream.Stream } all lines in file as String
	 * @throws IOException
	 */
	public static Stream<String> retrieveAllLines(Path path, Charset cs) throws IOException {
		return Files.lines(path, cs);
	}
	
	/**
	 * get path and return file attributes
	 * @param path
	 * @return File Attributes as <code>BasicFileAttributes</code>
	 * @throws IOException
	 */
	public static BasicFileAttributes getAttributes(Path path) throws IOException {
		return Files.readAttributes(path, BasicFileAttributes.class);
	}
	
	/**
	 * get a file name return true, when it in classpath exists.
	 * @param fileName
	 * @return <code>true</code> if and only if the file or directory denoted
     *          by this abstract pathname exists; <code>false</code> otherwise
	 */
	public static boolean isFileValid(String fileName) {
		if(getFile(fileName) == null)
			return false;
		else
			return true;
	}
	
	/**
	 * get a file name and return Path 
	 * @param fileName
	 * @return Path or null if file not exists
	 */
	public static Path getFilePath(String fileName) {
		if(isFileValid(fileName))
			return getFile(fileName).toPath();
		else
			return null;
	}
	
	
	private static boolean hasLines(File file) {
		if(file.length() > 0)
			return true;
		else
			return false;
	}
	
	private static StringTokenizer getTokenizer(String classPath, String pathSeparator) {
		return new StringTokenizer(classPath, pathSeparator);
	}
	
	private static boolean isFile(File file) {
		return file.isFile();
	}
	
	private static File getTargetFile(File parentDir, String parent, String fileName) {
		if(parentDir == null)
			return new File(parent, fileName);
		else
			return new File(parentDir, fileName);
	}
}