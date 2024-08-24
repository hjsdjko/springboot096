package com.cl.dao;

import com.cl.entity.DiscussruxuexuzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussruxuexuzhiView;


/**
 * 入学须知评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface DiscussruxuexuzhiDao extends BaseMapper<DiscussruxuexuzhiEntity> {
	
	List<DiscussruxuexuzhiView> selectListView(@Param("ew") Wrapper<DiscussruxuexuzhiEntity> wrapper);

	List<DiscussruxuexuzhiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussruxuexuzhiEntity> wrapper);
	
	DiscussruxuexuzhiView selectView(@Param("ew") Wrapper<DiscussruxuexuzhiEntity> wrapper);
	

}
