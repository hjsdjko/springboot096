package com.cl.dao;

import com.cl.entity.RuxuexuzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RuxuexuzhiView;


/**
 * 入学须知
 * 
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface RuxuexuzhiDao extends BaseMapper<RuxuexuzhiEntity> {
	
	List<RuxuexuzhiView> selectListView(@Param("ew") Wrapper<RuxuexuzhiEntity> wrapper);

	List<RuxuexuzhiView> selectListView(Pagination page,@Param("ew") Wrapper<RuxuexuzhiEntity> wrapper);
	
	RuxuexuzhiView selectView(@Param("ew") Wrapper<RuxuexuzhiEntity> wrapper);
	

}
