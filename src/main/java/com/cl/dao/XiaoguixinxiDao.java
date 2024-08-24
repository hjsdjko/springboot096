package com.cl.dao;

import com.cl.entity.XiaoguixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoguixinxiView;


/**
 * 校规信息
 * 
 * @author 
 * @email 
 * @date 2024-03-11 17:57:39
 */
public interface XiaoguixinxiDao extends BaseMapper<XiaoguixinxiEntity> {
	
	List<XiaoguixinxiView> selectListView(@Param("ew") Wrapper<XiaoguixinxiEntity> wrapper);

	List<XiaoguixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoguixinxiEntity> wrapper);
	
	XiaoguixinxiView selectView(@Param("ew") Wrapper<XiaoguixinxiEntity> wrapper);
	

}
