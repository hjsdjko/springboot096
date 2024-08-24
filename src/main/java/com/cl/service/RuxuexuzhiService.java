package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RuxuexuzhiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RuxuexuzhiView;


/**
 * 入学须知
 *
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface RuxuexuzhiService extends IService<RuxuexuzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RuxuexuzhiView> selectListView(Wrapper<RuxuexuzhiEntity> wrapper);
   	
   	RuxuexuzhiView selectView(@Param("ew") Wrapper<RuxuexuzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RuxuexuzhiEntity> wrapper);
   	

}

