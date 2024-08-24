package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiliaoleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaoleixingView;


/**
 * 资料类型
 *
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface ZiliaoleixingService extends IService<ZiliaoleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiliaoleixingView> selectListView(Wrapper<ZiliaoleixingEntity> wrapper);
   	
   	ZiliaoleixingView selectView(@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiliaoleixingEntity> wrapper);
   	

}

