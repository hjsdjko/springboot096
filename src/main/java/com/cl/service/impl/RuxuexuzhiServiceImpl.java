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


import com.cl.dao.RuxuexuzhiDao;
import com.cl.entity.RuxuexuzhiEntity;
import com.cl.service.RuxuexuzhiService;
import com.cl.entity.view.RuxuexuzhiView;

@Service("ruxuexuzhiService")
public class RuxuexuzhiServiceImpl extends ServiceImpl<RuxuexuzhiDao, RuxuexuzhiEntity> implements RuxuexuzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RuxuexuzhiEntity> page = this.selectPage(
                new Query<RuxuexuzhiEntity>(params).getPage(),
                new EntityWrapper<RuxuexuzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RuxuexuzhiEntity> wrapper) {
		  Page<RuxuexuzhiView> page =new Query<RuxuexuzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RuxuexuzhiView> selectListView(Wrapper<RuxuexuzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RuxuexuzhiView selectView(Wrapper<RuxuexuzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
