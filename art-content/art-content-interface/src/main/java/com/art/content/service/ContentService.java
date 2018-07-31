package com.art.content.service;

import java.util.List;

import com.art.pojo.ArtResult;
import com.art.pojo.Content;
import com.art.pojo.EasyUIDataGridResult;

public interface ContentService {

	List<Content> getContentByCid(Long aD1_CATEGORY_ID);

	ArtResult addContent(Content content);

	EasyUIDataGridResult getContentByPage(Integer page, Integer rows, long categoryId);

	ArtResult restContent(Content content);

	ArtResult deleteContent(long[] ids);

}
