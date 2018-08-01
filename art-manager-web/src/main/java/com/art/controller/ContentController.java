package com.art.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.art.content.service.ContentService;
import com.art.pojo.ArtResult;
import com.art.pojo.Content;
import com.art.pojo.EasyUIDataGridResult;



@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/save")
	@ResponseBody
	public ArtResult addContent(Content con) {
//		Content con = new Content();
//		con.setCategoryId(categoryId);
//		con.setTitle(title);
//		con.setContent(content);
//		con.setUrl(url);
//		con.setPrice(price);
//		con.setPic(pic);
		ArtResult result = contentService.addContent(con);
		return result;
	}
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult contentQuerylist(Integer page, Integer rows,Integer categoryId)
	{
		return contentService.getContentByPage(page,rows,categoryId);
	}
	
	@RequestMapping("/rest/content/edit")
	@ResponseBody
	public ArtResult contentEdit(Content content)
	{
		return contentService.restContent(content);
	}
	
	@RequestMapping("/content/delete")
	@ResponseBody
	public ArtResult contentEdit(long [] ids)
	{
		return contentService.deleteContent(ids);
	}
	
	
}
