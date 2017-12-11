package be.pxl.multithreading.oefening1;

import java.time.Duration;
import java.time.LocalTime;

public class Customer {
	
	private String name;
	private LocalTime steppedInLine;
	private LocalTime helped;
	private int transactionTime;

	public Customer(String name) {
		this.setName(name);
		transactionTime = (int) (1001 + Math.random() * 9000);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getTimeWaited(){
		if(helped != null)
		return Duration.between(steppedInLine, helped).getSeconds();
		return 0;
	}

	public void stopWaiting(){
		helped = LocalTime.now();
	}
	
	public void inLine(){
		steppedInLine = LocalTime.now();
	}
	
	public int getTransactionTime() {
		return transactionTime;
	}
	
	

}
