package be.pxl.multithreading.klas1extended;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class OneFileWordCounter extends Thread implements Total {
	private Path file;
	private int result;

	public OneFileWordCounter(Path file) {
		this.file = file;
	}

	@Override
	public void run() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toAbsolutePath().toFile()))) {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				result += line.split(" ").length;
				if(line.contains("sleep")){
					sleep(1000);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

	public int getTotal() {
		return result;
	}

}
