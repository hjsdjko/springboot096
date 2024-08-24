package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxiaoguixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiaoguixinxiView;


/**
 * 校规信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface DiscussxiaoguixinxiService extends IService<DiscussxiaoguixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiaoguixinxiView> selectListView(Wrapper<DiscussxiaoguixinxiEntity> wrapper);
   	
   	DiscussxiaoguixinxiView selectView(@Param("ew") Wrapper<DiscussxiaoguixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiaoguixinxiEntity> wrapper);
   	

}

