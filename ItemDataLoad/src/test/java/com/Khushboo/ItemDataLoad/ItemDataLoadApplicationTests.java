package com.Khushboo.ItemDataLoad;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.Khushboo.ItemDataLoad.Dao.ItemDao;
import com.Khushboo.ItemDataLoad.Entities.Item;

@SpringBootTest
class ItemDataLoadApplicationTests {

	@Autowired
	private ItemDao itemDao;
	
	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void setUp(){
		Item item= new Item(1,"abcde","400",1,'a',1,1,"abc",true,"abc");
		itemDao.save(item);
	}
	
	@Test
	void addItem() {
		Item item= new Item(2,"abcde","300",1,'a',1,1,"abc",true,"abc");
		itemDao.save(item);
	}

	@Test
	void updateItem() {
		Item item = new Item(4,"abcde","200",1,'a',1,1,"abc",true,"abc");
		itemDao.save(item);
	}
	
	@Test
	void findById() {
		Item actual = itemDao.findById(1);
		assertThat(actual).isNull();
 	}
	
	@Test
	void getItems() {
		List<Item> actual = itemDao.findAll();
		assertThat(actual).asList();
 	}
	
	@Test
	void deleteItem(){
		itemDao.deleteById((long) 1);
	}	
}
