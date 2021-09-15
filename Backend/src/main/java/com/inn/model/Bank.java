package com.inn.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bankDetail")
public class Bank {
	
	@Id
	private String accountNumber;
	private String upiId;
	private String branchName;
	private String IFSC;
	private String accountHolderName;
		
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", upiId=" + upiId + ", branchName=" + branchName + ", IFSC="
				+ IFSC + ", accountHolderName=" + accountHolderName + "]";
	}
	public Bank(String accountNumber, String upiId, String branchName, String iFSC, String accountHolderName) {
		super();
		this.accountNumber = accountNumber;
		this.upiId = upiId;
		this.branchName = branchName;
		IFSC = iFSC;
		this.accountHolderName = accountHolderName;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
