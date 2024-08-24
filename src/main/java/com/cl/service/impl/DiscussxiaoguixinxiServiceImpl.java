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


import com.cl.dao.DiscussxiaoguixinxiDao;
import com.cl.entity.DiscussxiaoguixinxiEntity;
import com.cl.service.DiscussxiaoguixinxiService;
import com.cl.entity.view.DiscussxiaoguixinxiView;

@Service("discussxiaoguixinxiService")
public class DiscussxiaoguixinxiServiceImpl extends ServiceImpl<DiscussxiaoguixinxiDao, DiscussxiaoguixinxiEntity> implements DiscussxiaoguixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiaoguixinxiEntity> page = this.selectPage(
                new Query<DiscussxiaoguixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussxiaoguixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiaoguixinxiEntity> wrapper) {
		  Page<DiscussxiaoguixinxiView> page =new Query<DiscussxiaoguixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxiaoguixinxiView> selectListView(Wrapper<DiscussxiaoguixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiaoguixinxiView selectView(Wrapper<DiscussxiaoguixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
