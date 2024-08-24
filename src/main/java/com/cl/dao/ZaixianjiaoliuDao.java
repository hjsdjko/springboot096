package com.cl.dao;

import com.cl.entity.ZaixianjiaoliuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZaixianjiaoliuView;


/**
 * 在线交流
 * 
 * @author 
 * @email 
 * @date 2024-03-11 17:57:39
 */
public interface ZaixianjiaoliuDao extends BaseMapper<ZaixianjiaoliuEntity> {
	
	List<ZaixianjiaoliuView> selectListView(@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);

	List<ZaixianjiaoliuView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);
	
	ZaixianjiaoliuView selectView(@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);
	

}
