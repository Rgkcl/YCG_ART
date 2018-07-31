package com.art.content.service;

import java.util.List;

import com.art.pojo.ArtResult;
import com.art.pojo.EasyUITreeNode;

public interface ContentCategoryService {
	List<EasyUITreeNode> getContentCategoryList(long parentId);

	ArtResult addContentCategory(Long parentId, String name);

	ArtResult deleteContentCategoryById(Long id);

	ArtResult resetContentCategoryNameById(Long id, String name);
}
