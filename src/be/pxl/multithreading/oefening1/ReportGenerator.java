package be.pxl.multithreading.oefening1;

public class ReportGenerator extends Thread {
	private BankLine line;
	private int waitTime;

	public ReportGenerator(BankLine line, int waitTime) {
		this.line = line;
		this.waitTime = waitTime;
	}

	public BankLine getLine() {
		return line;
	}

	public int getWaitTime() {
		return waitTime;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(waitTime);
				System.out.println(line);
			} catch (InterruptedException e) {
				// Continue
			}
		}
	}

}
