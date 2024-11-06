package com.Khushboo.ItemDataLoad.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.Khushboo.ItemDataLoad.Entities.Item;
import com.Khushboo.ItemDataLoad.Exception.ItemAlreadyExistException;
import com.Khushboo.ItemDataLoad.Exception.ItemNotFoundException;
import com.Khushboo.ItemDataLoad.Service.ItemService;
import jakarta.validation.Valid;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/home")
	public String home() {
		return "Hello!";
	}

	@GetMapping("/item")
	public List<Item> getItems() throws ItemNotFoundException {
		List<Item> item = this.itemService.getItems();
		if (item.isEmpty()){
			throw new ItemNotFoundException("Item Not Found");
		}
		return item;
	}

	@GetMapping("/item/{itemId}")
	public Item getItem(@PathVariable String itemId) throws ItemNotFoundException {
		if (itemService.itemExist(Long.parseLong(itemId))){
			Item item = itemService.getItem(Long.parseLong(itemId));
			return item;
		} 
		else {
			throw new ItemNotFoundException("Item with id " + itemId + " not found");
		}
	}

	@PostMapping("/item")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Item addItem(@Valid @RequestBody Item item) throws ItemAlreadyExistException {
		if (itemService.itemExist(item.getItemId())) {
			throw new ItemAlreadyExistException("Item with id " + item.getItemId() + " already exists");
		} else {
			return this.itemService.addItem(item);
		}
	}

	@PutMapping("/item/{itemId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Item updateItem(@Valid @PathVariable long itemId, @RequestBody Item item)
			throws ItemNotFoundException {
		if (itemService.itemExist(itemId)) {
			return this.itemService.updateItem(itemId, item);
		} 
		else {
			throw new ItemNotFoundException("Item Not Found");
		}
	}

	@DeleteMapping("/item/{itemId}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteItem(@PathVariable String itemId) throws ItemNotFoundException {
		if (itemService.itemExist(Long.parseLong(itemId))) {
			this.itemService.deleteItem(Long.parseLong(itemId));
		} 
		else {
			throw new ItemNotFoundException("Item Not Found");
		}
	}
}
