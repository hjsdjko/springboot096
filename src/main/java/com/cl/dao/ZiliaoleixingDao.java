package com.cl.dao;

import com.cl.entity.ZiliaoleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaoleixingView;


/**
 * 资料类型
 * 
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface ZiliaoleixingDao extends BaseMapper<ZiliaoleixingEntity> {
	
	List<ZiliaoleixingView> selectListView(@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);

	List<ZiliaoleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);
	
	ZiliaoleixingView selectView(@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);
	

}
