package com.inn.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inn.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

	List<Cart> findAllByUserId(int userId);
	
	void deleteAllByUserId(int userId);
	
	@Query("SELECT SUM(total) FROM Cart WHERE userId=:userId")
	long getCartListTotalByUserId(int userId);
}
