package be.pxl.multithreading.oefening1;

public class Teller extends Thread {
	private boolean runBool;
	private BankLine line;

	public Teller(BankLine line, String name, boolean bool) {
		setName(name);
		setLine(line);
		setRunBool(bool);
	}

	public boolean isRunBool() {
		return runBool;
	}

	public void setRunBool(boolean noIdea) {
		this.runBool = noIdea;
	}

	public BankLine getLine() {
		return line;
	}

	public void setLine(BankLine line) {
		this.line = line;
	}

	@Override
	public void run() {
		while (isRunBool()) {
			try {
				Customer customer = line.provideCustomer();
				if (customer == null) {
					Thread.sleep(10000);
				} else {
					System.out.println(getName() + " helping customer.");
					Thread.sleep(customer.getTransactionTime());
					System.out.println(getName() + " finished helping customer.");
				}
			} catch (Exception e) {
				// Continue
			}
		}

	}

}
