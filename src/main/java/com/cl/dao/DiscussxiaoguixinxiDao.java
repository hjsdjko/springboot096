package com.cl.dao;

import com.cl.entity.DiscussxiaoguixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiaoguixinxiView;


/**
 * 校规信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface DiscussxiaoguixinxiDao extends BaseMapper<DiscussxiaoguixinxiEntity> {
	
	List<DiscussxiaoguixinxiView> selectListView(@Param("ew") Wrapper<DiscussxiaoguixinxiEntity> wrapper);

	List<DiscussxiaoguixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiaoguixinxiEntity> wrapper);
	
	DiscussxiaoguixinxiView selectView(@Param("ew") Wrapper<DiscussxiaoguixinxiEntity> wrapper);
	

}
