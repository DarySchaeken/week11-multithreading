package be.pxl.multithreading.klas1extended;

import java.nio.file.Paths;



public class WordCount {

	public static void main(String[] args) {
		DirectoryMaster directoryMaster = new DirectoryMaster(Paths.get("subfolderedResources"));
		directoryMaster.start();
		try {
			directoryMaster.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total words: " + directoryMaster.getTotal());
		
	}

}
