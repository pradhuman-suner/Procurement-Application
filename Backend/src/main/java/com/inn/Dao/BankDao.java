package com.inn.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inn.model.Bank;

public interface BankDao extends JpaRepository<Bank, String>{

	Bank deleteByAccountNumber(String acc);

}
