package com.in.salamtrend.dao;

import java.util.List;
import com.in.salamtrend.model.Items;

public interface ItemsDAO {
	public Integer createOne(Items item);
	public Integer createBulk(List<Items> item);
	public Items getItemsById(Integer id);
	public Items getItemsByName(String name);
	List<Items>getItemsList();
	public void update(Items items);
	void delete(Integer id);

}
