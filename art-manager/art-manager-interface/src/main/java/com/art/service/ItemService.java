package com.art.service;

import com.art.pojo.EasyUIDataGridResult;
import com.art.pojo.Item;

public interface ItemService {
Item getItemById(int id);

EasyUIDataGridResult getItemByPage(Integer page, Integer rows);

}
