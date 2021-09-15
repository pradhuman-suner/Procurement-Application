package com.inn.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inn.model.Bank;

public interface BankRest {

	@PostMapping("/saveBankDetails")
	Bank saveDetails(@RequestBody Bank bank);

	@GetMapping("/showAccountDetails")
	List<Bank> showAccounts();

	@DeleteMapping("/deleteAccountDetails")
	void removeAccount(@PathVariable String accountNumber);
}
