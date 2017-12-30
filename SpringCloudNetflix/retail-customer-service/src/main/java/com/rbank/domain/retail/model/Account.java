package com.rbank.domain.retail.model;

public class Account {
	public long getAccontId() {
		return accontId;
	}
	public void setAccontId(long accontId) {
		this.accontId = accontId;
	}
	public String getAccontType() {
		return accontType;
	}
	public void setAccontType(String accontType) {
		this.accontType = accontType;
	}
	public String getAccontName() {
		return accontName;
	}
	public void setAccontName(String accontName) {
		this.accontName = accontName;
	}
	public double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	private long accontId;
	private String accontType;
	private String accontName;
	private double availableBalance;
	private double currentBalance;
}
