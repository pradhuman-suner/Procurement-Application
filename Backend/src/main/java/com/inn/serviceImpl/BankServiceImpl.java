package com.inn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.Dao.BankDao;
import com.inn.model.Bank;
import com.inn.service.BankService;


@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	BankDao bankDao;
	

	@Override
	public Bank saveDetails(Bank bank)
	{
		return bankDao.save(bank);
	}
	
	
	@Override
	public List<Bank> showBankDetails(){
		return bankDao.findAll();
		
	}


	@Override
	public Bank deleteByAccountNumber(String acc) {
		return bankDao.deleteByAccountNumber(acc);
	}
	

	
}
