package br.com.mystudies.scalability.thread.safety;

import static java.lang.System.nanoTime;

import java.io.File;
import java.io.IOException;

public class SequencialTotalFileSize {

	
	public double getTotalSizeOfFile(File file) throws IOException {

		if(file.isFile()) return file.length();

		File[] children = file.listFiles();
		double total = 0;
		if(children != null)
			for (File child : children) {
				total += getTotalSizeOfFile(child);
			}
		return total;
	}
	
	public static void main(String[] args) throws IOException {
		final long start = nanoTime();
		final double total = new SequencialTotalFileSize().getTotalSizeOfFile(new File("F:"));
		final long end  = nanoTime();
		System.out.println("Total Size in GB: " + ((( total / 1024 ) / 1024 ) / 1024 )) ;
		System.out.println("Time taken in seconds: " + (end - start) / 1.0e9) ;
	}

	/* 
	 * Total Size in GB: 82.32213742472231 
	 * Time taken in seconds: 11.426830916
	 */
	
	
}
