package com.Khushboo.ItemDataLoad.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Khushboo.ItemDataLoad.Entities.Item;

public interface ItemDao extends JpaRepository<Item, Long>{

	Item findById(long itemId);
//	boolean existsByName(String itemName);

}
