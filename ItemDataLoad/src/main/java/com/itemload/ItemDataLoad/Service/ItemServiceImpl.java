package com.Khushboo.ItemDataLoad.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Khushboo.ItemDataLoad.Dao.ItemDao;
import com.Khushboo.ItemDataLoad.Entities.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> getItems() {	
		return itemDao.findAll();
	}

	@Override
	public Item getItem(long itemId) {
		return itemDao.findById(itemId);
	}

	@Override
	public Item addItem(Item item) {
		itemDao.save(item);
		return item;
	}

	@Override
	public void deleteItem(long itemId) {
		itemDao.deleteById(itemId);
	}

	@Override
	public Item updateItem(long itemId, Item item) {
		itemDao.save(item);
		return item;
	}

	@Override
	public boolean itemExist(long itemId) {
		return itemDao.existsById(itemId);
	}

	
}
