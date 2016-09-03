package com.automation.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportUtils {
	
	
	private File file;
	private BufferedWriter bw;
	private FileWriter fw;
	
	
	public ReportUtils(String filename) throws IOException {
		 file = new File(System.getProperty("user.dir")+filename+".txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		fw = new FileWriter(file.getAbsoluteFile());
		bw = new BufferedWriter(fw);
	}
	public void writedata(String content) throws IOException {
		bw.write(content+"\n");
	}
	
	public void closefile() throws IOException {
		bw.close();
	}

}
