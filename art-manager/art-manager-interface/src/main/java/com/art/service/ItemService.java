package com.art.service;

import com.art.pojo.ArtResult;
import com.art.pojo.EasyUIDataGridResult;
import com.art.pojo.Item;

public interface ItemService {
Item getItemById(int id);

EasyUIDataGridResult getItemByPage(Integer page, Integer rows);

ArtResult addItem(Item item, String desc);

}
