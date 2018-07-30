package com.art.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.art.mapper.ItemCatMapper;
import com.art.pojo.EasyUITreeNode;
import com.art.pojo.ItemCat;
import com.art.pojo.ItemCatExample;
import com.art.pojo.ItemCatExample.Criteria;
import com.art.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;
	
	

	@Override
	public List<EasyUITreeNode> getItemCatList(Long parentId) {
		//根据父节点id查询子节点列表
				ItemCatExample example = new ItemCatExample();
				//设置查询条件
				Criteria criteria = example.createCriteria();
				//设置parentid
				criteria.andParentIdEqualTo(parentId);
				//执行查询
				List<ItemCat> list = itemCatMapper.selectByExample(example);
				//转换成EasyUITreeNode列表
				List<EasyUITreeNode> resultList = new ArrayList<>();
				for (ItemCat tbItemCat : list) {
					EasyUITreeNode node = new EasyUITreeNode();
					node.setId(tbItemCat.getId());
					node.setText(tbItemCat.getName());
					//如果节点下有子节点“closed”，如果没有子节点“open”
					node.setState(tbItemCat.getIsParent()?"closed":"open");
					//添加到节点列表
					resultList.add(node);
				}
				return resultList;
	}

}
