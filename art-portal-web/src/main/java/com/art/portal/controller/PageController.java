package com.art.portal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.content.service.ContentService;
import com.art.pojo.Content;
import com.art.portal.pojo.AD1Node;
import com.art.utils.JsonUtils;


@Controller
public class PageController {
	@Value("${AD1_CATEGORY_ID}")
	private Long AD1_CATEGORY_ID;
	
	@Value("${TJ_CATEGORY_ID}")
	private Long TJ_CATEGORY_ID;
	
	@Value("${JX_CATEGORY_ID}")
	private Long JX_CATEGORY_ID;
	
	@Value("${ZJ_CATEGORY_ID}")
	private Long ZJ_CATEGORY_ID;
	
	@Autowired
    ContentService contentservice;
    @RequestMapping("/index")
	public ModelAndView showIndex()
	{
		//根据cid查询轮播图内容列表
		List<Content> contentList = contentservice.getContentByCid(AD1_CATEGORY_ID);
		//查询今日推荐的商品
	    List<Content> TJcontent = contentservice.getContentByCid(TJ_CATEGORY_ID);
	    //查询商城精选
	  //查询今日推荐的商品
	  	List<Content> JXcontent = contentservice.getContentByCid(JX_CATEGORY_ID);
	   //查询今日推荐的商品
	    List<Content> ZJcontent = contentservice.getContentByCid(ZJ_CATEGORY_ID);
		//把列表转换为Ad1Node列表，方便轮播图显示
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
		//把列表转换成json数据
		String TJJson = JsonUtils.objectToJson(TJcontent);
		//把列表转换成json数据
		String JXJson = JsonUtils.objectToJson(JXcontent);
		//把列表转换成json数据
		String ZJJson = JsonUtils.objectToJson(ZJcontent);
		//把json数据传递给页面
		Map<String,List> map = new HashMap<String,List>();
		map.put("ad1", ad1Nodes);
		map.put("TJ", TJcontent);
		map.put("JX", JXcontent);
		map.put("ZJ", ZJcontent);
		return new ModelAndView("index",map);
	}
}
