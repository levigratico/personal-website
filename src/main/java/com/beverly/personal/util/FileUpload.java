package com.beverly.personal.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUpload {
	
	
	public static boolean uploadFile(InputStream input, File file) {
		try {
			byte[] buffer = new byte[input.available()];
			input.read(buffer);
			OutputStream outStream;
			outStream = new FileOutputStream(file);
			outStream.write(buffer);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
