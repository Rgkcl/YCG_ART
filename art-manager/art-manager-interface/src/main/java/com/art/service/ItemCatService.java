package com.art.service;

import java.util.List;

import com.art.pojo.EasyUITreeNode;

public interface ItemCatService {

	List<EasyUITreeNode> getItemCatList(Long parentId);

}
