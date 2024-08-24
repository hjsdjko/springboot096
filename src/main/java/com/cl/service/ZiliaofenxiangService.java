package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiliaofenxiangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaofenxiangView;


/**
 * 资料分享
 *
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
public interface ZiliaofenxiangService extends IService<ZiliaofenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiliaofenxiangView> selectListView(Wrapper<ZiliaofenxiangEntity> wrapper);
   	
   	ZiliaofenxiangView selectView(@Param("ew") Wrapper<ZiliaofenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiliaofenxiangEntity> wrapper);
   	

}

