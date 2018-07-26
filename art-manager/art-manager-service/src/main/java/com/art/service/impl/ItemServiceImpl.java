package com.art.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.art.mapper.ItemMapper;
import com.art.pojo.EasyUIDataGridResult;
import com.art.pojo.Item;
import com.art.pojo.ItemExample;
import com.art.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ItemServiceImpl implements ItemService {
  @Autowired
  private ItemMapper itemmapper;

	public Item getItemById(int id) {
		
		return itemmapper.selectByPrimaryKey(id);
	}

	@Override
	public EasyUIDataGridResult getItemByPage(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		ItemExample example = new ItemExample();
		List<Item> list = itemmapper.selectByExample(example );
		PageInfo info = new PageInfo(list);
		EasyUIDataGridResult eud = new EasyUIDataGridResult();
		eud.setRows(list);
		eud.setTotal(eud.getTotal());
		return eud;
	}

}
