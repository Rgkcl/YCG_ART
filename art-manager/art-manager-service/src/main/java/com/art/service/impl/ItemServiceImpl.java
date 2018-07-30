 package com.art.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.art.mapper.ItemDescMapper;
import com.art.mapper.ItemMapper;
import com.art.pojo.ArtResult;
import com.art.pojo.EasyUIDataGridResult;
import com.art.pojo.Item;
import com.art.pojo.ItemDesc;
import com.art.pojo.ItemExample;
import com.art.service.ItemService;
import com.art.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService {
  @Autowired
  private ItemMapper itemmapper;
  @Autowired
  private ItemDescMapper itemdescmapper;

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

	@Override
	public  ArtResult addItem(Item item, String desc) {
	
			//生成商品id
		try {
			final long itemId = IDUtils.genItemId();
			//补全item的属性
			item.setId(itemId);
			//商品状态，1-正常，2-下架，3-删除
			item.setStatus( 1);
			item.setCreated(new Date());
			item.setUpdated(new Date());
			item.setSalesVolume("0");
			//向商品表插入数据
			itemmapper.insert(item);
			//创建一个商品描述表对应的pojo
			ItemDesc itemDesc = new ItemDesc();
			
			//补全pojo的属性
			itemDesc.setId(itemId);
			itemDesc.setItemDesc(desc);
			itemDesc.setCreated(new Date());
			itemDesc.setUpdated(new Date());
			System.out.println(itemDesc);
			//向商品描述表插入数据
			itemdescmapper.insertSelective(itemDesc);
			//返回结果
			return ArtResult.ok();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
			
		return null;
		

	}

}
