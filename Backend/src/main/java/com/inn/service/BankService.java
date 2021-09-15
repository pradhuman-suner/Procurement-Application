package com.inn.service;

import java.util.List;

import com.inn.model.Bank;

public interface BankService {

	Bank saveDetails(Bank bank);

	List<Bank> showBankDetails();

	Bank deleteByAccountNumber(String acc);

}
