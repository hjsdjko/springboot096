package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.XiaoguixinxiDao;
import com.cl.entity.XiaoguixinxiEntity;
import com.cl.service.XiaoguixinxiService;
import com.cl.entity.view.XiaoguixinxiView;

@Service("xiaoguixinxiService")
public class XiaoguixinxiServiceImpl extends ServiceImpl<XiaoguixinxiDao, XiaoguixinxiEntity> implements XiaoguixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoguixinxiEntity> page = this.selectPage(
                new Query<XiaoguixinxiEntity>(params).getPage(),
                new EntityWrapper<XiaoguixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoguixinxiEntity> wrapper) {
		  Page<XiaoguixinxiView> page =new Query<XiaoguixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaoguixinxiView> selectListView(Wrapper<XiaoguixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoguixinxiView selectView(Wrapper<XiaoguixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
