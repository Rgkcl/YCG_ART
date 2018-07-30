package com.art.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.art.pojo.ArtResult;
import com.art.pojo.EasyUIDataGridResult;
import com.art.pojo.Item;
import com.art.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

@RequestMapping("item/{itemId}")
@ResponseBody
public Item getItemById(@PathVariable int itemId)
{
	return itemService.getItemById(itemId);
}

@RequestMapping("item/list")
@ResponseBody
public EasyUIDataGridResult getItemListByPage(Integer page,Integer rows)
{
	return itemService.getItemByPage(page,rows);
}

@RequestMapping("/item/save")
@ResponseBody
public ArtResult addItem(Item item,String desc)
{   System.out.println(item);
	return itemService.addItem(item,desc);
}
}

