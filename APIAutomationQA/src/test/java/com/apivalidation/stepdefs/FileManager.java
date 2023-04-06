package com.apivalidation.stepdefs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

	private static FileManager objFileManager = null;

	private FileManager() {

	}

	public synchronized static FileManager getFileManagerObj() {
		return (objFileManager == null) ? new FileManager() : objFileManager;
	}

	public String searchFile(String dirPath, String fileName) {
		File dir = new File(dirPath);
		File[] listFiles = dir.listFiles();
		String filePath = null;
		for (File file : listFiles) {
			if (file.isDirectory()) {
				filePath = searchFile(file.getAbsolutePath(), fileName);
				if (filePath != null) {
					break;
				}
			} else {
				if (file.getName().equalsIgnoreCase(fileName)) {
					filePath = file.getAbsolutePath();
					break;
				}
			}
		}
		return filePath;
	}

	public String readFile(String filePath) {
		StringBuffer content = new StringBuffer();
		BufferedReader bufferedReader = null;
		if (isFileExists(filePath)) {
			try {
				bufferedReader = new BufferedReader(new FileReader(filePath));
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					content.append(line).append("\n");

				}
			} catch (IOException e) {

				e.printStackTrace();
			} finally {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return content.toString();
	}

	public boolean isFileExists(String filePath) {
		return new File(filePath).exists();
	}
	
	public boolean createFile(String filePath) {
		File file = new File(filePath);
		try {
			return file.createNewFile();
		}catch (IOException e) {
			//ExceptionHandler.handleException(e);
			e.printStackTrace();
			
		}
		return false;
	}
	
	public void write(String filePath , String writestr) {
		try {
			FileWriter fw = new FileWriter(filePath);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(writestr);
			writer.close();
			fw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
