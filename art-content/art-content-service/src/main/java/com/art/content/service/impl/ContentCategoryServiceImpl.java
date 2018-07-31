package com.art.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.art.content.service.ContentCategoryService;
import com.art.mapper.ArtContentCategoryMapper;
import com.art.pojo.ArtContentCategory;
import com.art.pojo.ArtContentCategoryExample;
import com.art.pojo.ArtContentCategoryExample.Criteria;
import com.art.pojo.ArtResult;
import com.art.pojo.EasyUITreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private ArtContentCategoryMapper artcontentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {

		// 根据parentId查询子节点列表
		ArtContentCategoryExample example = new ArtContentCategoryExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<ArtContentCategory> list = artcontentCategoryMapper.selectByExample(example);
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (ArtContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			// 添加到结果列表
			resultList.add(node);
		}
		return resultList;

	}

	@Override
	public ArtResult addContentCategory(Long parentId, String name) {
		// 创建一个pojo对象
		ArtContentCategory contentCategory = new ArtContentCategory();
		// 补全对象的属性
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		// 状态。可选值:1(正常),2(删除)
		contentCategory.setStatus(1);
		// 排序，默认为1
		contentCategory.setSortOrder(1);
		contentCategory.setIsParent(false);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		// 插入到数据库
		artcontentCategoryMapper.insert(contentCategory);
		// 判断父节点的状态
		ArtContentCategory parent = artcontentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parent.getIsParent()) {
			// 如果父节点为叶子节点应该改为父节点
			parent.setIsParent(true);
			// 更新父节点
			artcontentCategoryMapper.updateByPrimaryKey(parent);
		}

		// 返回结果
		return ArtResult.ok(contentCategory);
	}

	@Override
	public ArtResult deleteContentCategoryById(Long id) {
		// 1.查看是否是父节点
		ArtContentCategory artContentCategory = artcontentCategoryMapper.selectByPrimaryKey(id);

		if (artContentCategory.getIsParent()) {
			return ArtResult.build(400, "该节点是父节点，不能删除");
		} else {
			// 2.不是父节点，删除
			long pid = artContentCategory.getParentId();
			int i = artcontentCategoryMapper.deleteByPrimaryKey(id);
			// 如果删除成功，查看该父节点是否还有子节点，如果没有，则将其置为页子节点
			if (i == 1) {
				List<ArtContentCategory> list = artcontentCategoryMapper.selectByExample(null);
				boolean b = true;
				for (ArtContentCategory acg : list) {
					if (acg.getParentId() == pid)
						b = false;
				}
				if (b = false) {
					ArtContentCategory parent = artcontentCategoryMapper.selectByPrimaryKey(pid);
					parent.setIsParent(false);
					artcontentCategoryMapper.updateByPrimaryKeySelective(parent);
				}
				return ArtResult.ok();
			}
		}

		return ArtResult.build(500, "哎呦，服务器出错了！");
	}

	@Override
	public ArtResult resetContentCategoryNameById(Long id, String name) {
		ArtContentCategory contentCategory = artcontentCategoryMapper.selectByPrimaryKey(id);
		contentCategory.setName(name);
		int i = artcontentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
		if (i == 1)
			return ArtResult.ok();
		return ArtResult.build(500, "哎呦，服务器出错了！");
	}

}
