package com.art.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.art.content.service.ContentService;
import com.art.mapper.ContentMapper;
import com.art.pojo.ArtResult;
import com.art.pojo.Content;
import com.art.pojo.ContentExample;
import com.art.pojo.ContentExample.Criteria;
import com.art.pojo.EasyUIDataGridResult;
import com.art.pojo.Item;
import com.art.pojo.ItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentMapper contentmapper;
	
	public ArtResult addContent(Content content) {
		System.out.println(content);
		//补全pojo的属性
		content.setCreated( new Date());
		content.setUpdated(new Date());
		//插入到内容表
		contentmapper.insert(content);
		//同步缓存
//		//删除对应的缓存信息
//		jedisClient.hdel(INDEX_CONTENT, content.getCategoryId().toString());
		return ArtResult.ok();
	}

	@Override
	public List<Content> getContentByCid(Long cid) {
//		//先查询缓存
//		//添加缓存不能影响正常业务逻辑
//		try {
//			//查询缓存
//			String json = jedisClient.hget(INDEX_CONTENT, cid + "");
//			//查询到结果，把json转换成List返回
//			if (StringUtils.isNotBlank(json)) {
//				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
//				return list;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//缓存中没有命中，需要查询数据库
		ContentExample example = new ContentExample();
		ContentExample.Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<Content> list = contentmapper.selectByExample(example);
//		//把结果添加到缓存
//		try {
//			jedisClient.hset(INDEX_CONTENT, cid + "", JsonUtils.objectToJson(list));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		//返回结果
		return list;
	}

	@Override
	public EasyUIDataGridResult getContentByPage(Integer page, Integer rows, long categoryId) {

		PageHelper.startPage(page, rows);
		ContentExample example = new ContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<Content> list = contentmapper.selectByExample(example);
		PageInfo info = new PageInfo(list);
		EasyUIDataGridResult eud = new EasyUIDataGridResult();
		eud.setRows(list);
		eud.setTotal(eud.getTotal());
		return eud;
	
	}

	@Override
	public ArtResult restContent(Content content) {
		ContentExample example = new ContentExample();
		int i = contentmapper.updateByPrimaryKey(content);
		
		if(i!=1)
		return ArtResult.build(500, "更新失败");
		return ArtResult.ok();
	}

	@Override
	public ArtResult deleteContent(long[] ids) {
		
		for(int i=0;i<ids.length;i++)
		{   int k = contentmapper.deleteByPrimaryKey(ids[i]);
             if(k!=1)
             {
            	return ArtResult.build(500, "服务器出现故障！");
             }
		}
		return ArtResult.ok();
	}

}
