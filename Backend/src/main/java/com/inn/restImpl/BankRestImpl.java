package com.inn.restImpl;

import java.util.List;

import com.inn.model.Bank;
import com.inn.rest.BankRest;
import com.inn.service.BankService;

public class BankRestImpl implements BankRest{
	
	BankService bankService;
	

	@Override
	public Bank saveDetails(Bank bank)
	{
		return bankService.saveDetails(bank);
	}
	

	@Override
	public List<Bank> showAccounts(){
		return bankService.showBankDetails();
		
	}


	@Override
	public void removeAccount(String accountNumber) {
		bankService.deleteByAccountNumber(accountNumber);
	}
	

	
	

}
