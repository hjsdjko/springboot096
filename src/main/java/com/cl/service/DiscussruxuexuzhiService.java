package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussruxuexuzhiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussruxuexuzhiView;


/**
 * 入学须知评论表
 *
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface DiscussruxuexuzhiService extends IService<DiscussruxuexuzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussruxuexuzhiView> selectListView(Wrapper<DiscussruxuexuzhiEntity> wrapper);
   	
   	DiscussruxuexuzhiView selectView(@Param("ew") Wrapper<DiscussruxuexuzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussruxuexuzhiEntity> wrapper);
   	

}

