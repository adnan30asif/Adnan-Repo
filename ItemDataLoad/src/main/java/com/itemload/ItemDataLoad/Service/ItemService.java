package com.Khushboo.ItemDataLoad.Service;

import java.util.List;

import com.Khushboo.ItemDataLoad.Entities.Item;


public interface ItemService {

	public List<Item> getItems();
	
	public Item getItem(long l);
	
	public Item addItem(Item product);

	public void deleteItem(long itemId);

	public Item updateItem(long itemId, Item product);

	public boolean itemExist(long parseLong);

//	public boolean itemExistByName(String itemName);
	
	
}
