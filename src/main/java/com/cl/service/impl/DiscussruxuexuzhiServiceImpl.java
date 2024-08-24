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


import com.cl.dao.DiscussruxuexuzhiDao;
import com.cl.entity.DiscussruxuexuzhiEntity;
import com.cl.service.DiscussruxuexuzhiService;
import com.cl.entity.view.DiscussruxuexuzhiView;

@Service("discussruxuexuzhiService")
public class DiscussruxuexuzhiServiceImpl extends ServiceImpl<DiscussruxuexuzhiDao, DiscussruxuexuzhiEntity> implements DiscussruxuexuzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussruxuexuzhiEntity> page = this.selectPage(
                new Query<DiscussruxuexuzhiEntity>(params).getPage(),
                new EntityWrapper<DiscussruxuexuzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussruxuexuzhiEntity> wrapper) {
		  Page<DiscussruxuexuzhiView> page =new Query<DiscussruxuexuzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussruxuexuzhiView> selectListView(Wrapper<DiscussruxuexuzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussruxuexuzhiView selectView(Wrapper<DiscussruxuexuzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
