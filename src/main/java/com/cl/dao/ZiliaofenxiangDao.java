package com.cl.dao;

import com.cl.entity.ZiliaofenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaofenxiangView;


/**
 * 资料分享
 * 
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface ZiliaofenxiangDao extends BaseMapper<ZiliaofenxiangEntity> {
	
	List<ZiliaofenxiangView> selectListView(@Param("ew") Wrapper<ZiliaofenxiangEntity> wrapper);

	List<ZiliaofenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<ZiliaofenxiangEntity> wrapper);
	
	ZiliaofenxiangView selectView(@Param("ew") Wrapper<ZiliaofenxiangEntity> wrapper);
	

}
