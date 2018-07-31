package com.art.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.art.content.service.ContentService;
import com.art.pojo.Content;
import com.art.portal.pojo.AD1Node;
import com.art.utils.JsonUtils;


@Controller
public class PageController {
	@Value("${AD1_CATEGORY_ID}")
	private Long AD1_CATEGORY_ID;
	
	@Autowired
    ContentService contentservice;
    @RequestMapping("/index")
	public String showIndex(Model model)
	{
		//根据cid查询轮播图内容列表
		List<Content> contentList = contentservice.getContentByCid(AD1_CATEGORY_ID);
		//把列表转换为Ad1Node列表
		List<AD1Node> ad1Nodes = new ArrayList<>();
		for (Content content : contentList) {
			AD1Node node = new AD1Node();
			node.setSrc(content.getPic());
			node.setHref(content.getUrl());
			
			//添加到节点列表
			ad1Nodes.add(node);
		}
		//把列表转换成json数据
		String ad1Json = JsonUtils.objectToJson(ad1Nodes);
		//把json数据传递给页面
		model.addAttribute("ad1", ad1Json);
		return "index";
	}
}
