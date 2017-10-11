package com.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		try {
			if (args.length != 2) {
				System.out.println("Usage: java copy sourceFile targetFile");
				System.exit(0);
			}
			
			// check if source file exists
			File sourceFile = new File(args[0]);
			if(!sourceFile.exists()) {
				System.out.println("Source file " + args[0] + " doesnt exist.");
				System.exit(0);
			}
			//check if target file already exists
			File targetFile = new File(args[1]);
			if(targetFile.exists()) {
				System.out.println("Target file " + args[1] + " already exists.");
				System.exit(0);
			}
			
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile));
			
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile));
			
			System.out.println("The file " + args[0] + " has " + in.available() + " bytes.");
			
			int r;
			while ((r = in.read()) != -1) {
				out.write((byte)r);
			}
			
			in.close();
			out.close();
			
			System.out.println("Copy complete!");
			System.exit(0);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
