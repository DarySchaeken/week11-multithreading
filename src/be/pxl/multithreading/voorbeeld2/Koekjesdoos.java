package be.pxl.multithreading.voorbeeld2;

public class Koekjesdoos {
	private int aantalKoekjes = 0;
	
	public synchronized void voegKoekjesToe(int koekjes) {
		System.out.println("Koekjes klaar");
		aantalKoekjes += koekjes; 
		status();
	}
	
	public synchronized boolean neemKoekje(Kind kind) {
		if (aantalKoekjes > 0) {
			System.out.println(kind.getNaam() + " eet een koekje");
			aantalKoekjes--;
			status();
			return true;
		}
		return false;
	}
	
	public void status() {
		System.out.println(aantalKoekjes + " in de koekjesdoos");
	}
}
