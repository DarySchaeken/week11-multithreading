package be.pxl.multithreading.klas1extended;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DirectoryMaster extends Thread implements Total {
	Path path;
	int total;
	
	public DirectoryMaster(Path path) {
		this.path = path;
	}
	
	@Override
	public void run() {
		List<Thread> allThreads = new ArrayList<>();
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
			for(Path file: stream){
				if(Files.isDirectory(file)) {
					DirectoryMaster dm = new DirectoryMaster(file);
					dm.start();
					allThreads.add(dm);					
				} else {
					OneFileWordCounter thread = new OneFileWordCounter(file);
					thread.start();
					allThreads.add(thread);
				}
			}
			
		} catch (IOException | DirectoryIteratorException e) {
			System.err.println(e);
		}
		
		total = 0;
		try {
			for(Thread thread: allThreads){
				thread.join();
				total+= ((Total) thread).getTotal();
			}
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
	
	public int getTotal() {
		return total;
	};
}
