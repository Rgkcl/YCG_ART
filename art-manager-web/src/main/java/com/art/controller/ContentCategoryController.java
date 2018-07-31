package com.art.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.art.content.service.ContentCategoryService;
import com.art.pojo.ArtResult;
import com.art.pojo.EasyUITreeNode;



@Controller
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(
			@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
		return list;
		
	}
	
	@RequestMapping("/content/category/create")
	@ResponseBody
	public ArtResult addContentCategory(Long parentId, String name) {
		ArtResult result = contentCategoryService.addContentCategory(parentId, name);
		return result;
	}
	/**
	 * 根据内容分类ID删除内容
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("/content/category/delete")
	@ResponseBody
	public ArtResult deleteContentCategoryById(Long id) {
		ArtResult result = contentCategoryService.deleteContentCategoryById(id);
		return result;
	}
	/**
	 * 重命名内容分类ID
	 * @param Id
	 * @param name
	 * @return
	 */
	@RequestMapping("/content/category/update")
	@ResponseBody
	public ArtResult resetContentCategoryNameById(Long id,String name) {
		ArtResult result = contentCategoryService.resetContentCategoryNameById(id,name);
		return result;
	}
	
}

