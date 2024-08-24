package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaoguixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoguixinxiView;


/**
 * 校规信息
 *
 * @author 
 * @email 
 * @date 2024-03-11 17:57:39
 */
public interface XiaoguixinxiService extends IService<XiaoguixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoguixinxiView> selectListView(Wrapper<XiaoguixinxiEntity> wrapper);
   	
   	XiaoguixinxiView selectView(@Param("ew") Wrapper<XiaoguixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoguixinxiEntity> wrapper);
   	

}

