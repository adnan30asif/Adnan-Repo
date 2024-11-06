package com.Khushboo.ItemDataLoad.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private long itemId;
	
	@NotBlank
	@Size(min=5,message="Name must have atleast 5 characters")
	private String itemName;
	
	@NotBlank(message="Must be integer ")	
	private String itemCost;
	
	//@Digits(message="Must be integer", fraction = 0, integer = 2)
	@NotNull
	private int itemQuantity;
	
	@NotNull
	private char itemPack;
	
	@NotNull
	private int itemContents;
	
	@NotNull
	private int itemDimensions;
	
	@NotBlank
	private String itemOriginLocation;
	
	
	private boolean itemShip;
	
	@NotBlank
	private String itemCompany;
	
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCost() {
		return itemCost;
	}
	public void setItemCost(String itemCost) {
		this.itemCost = itemCost;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public char getItemPack() {
		return itemPack;
	}
	public void setItemPack(char itemPack) {
		this.itemPack = itemPack;
	}
	public int getItemContents() {
		return itemContents;
	}
	public void setItemContents(int itemContents) {
		this.itemContents = itemContents;
	}
	public int getItemDimensions() {
		return itemDimensions;
	}
	public void setItemDimensions(int itemDimensions) {
		this.itemDimensions = itemDimensions;
	}
	public String getItemOriginLocation() {
		return itemOriginLocation;
	}
	public void setItemOriginLocation(String itemOriginLocation) {
		this.itemOriginLocation = itemOriginLocation;
	}
	public boolean isItemShip() {
		return itemShip;
	}
	public void setItemShip(boolean itemShip) {
		this.itemShip = itemShip;
	}
	public String getItemCompany() {
		return itemCompany;
	}
	public void setItemCompany(String itemCompany) {
		this.itemCompany = itemCompany;
	}
	public Item(long itemId, String itemName, String itemCost, int itemQuantity, char itemPack, int itemContents,
			int itemDimensions, String itemOriginLocation, boolean itemShip, String itemCompany) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.itemQuantity = itemQuantity;
		this.itemPack = itemPack;
		this.itemContents = itemContents;
		this.itemDimensions = itemDimensions;
		this.itemOriginLocation = itemOriginLocation;
		this.itemShip = itemShip;
		this.itemCompany = itemCompany;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", itemName=" + itemName + ", itemCost=" + itemCost + ", itemQuantity="
				+ itemQuantity + ", itemPack=" + itemPack + ", itemContents=" + itemContents + ", itemDimensions="
				+ itemDimensions + ", itemOriginLocation=" + itemOriginLocation + ", itemShip=" + itemShip
				+ ", itemCompany=" + itemCompany + "]";
	}
	
	

	
}
