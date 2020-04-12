package com.in.salamtrend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.salamtrend.model.Items;

public interface ItemRepository extends JpaRepository<Items, Integer> {
	

}
