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


import com.cl.dao.ZiliaoleixingDao;
import com.cl.entity.ZiliaoleixingEntity;
import com.cl.service.ZiliaoleixingService;
import com.cl.entity.view.ZiliaoleixingView;

@Service("ziliaoleixingService")
public class ZiliaoleixingServiceImpl extends ServiceImpl<ZiliaoleixingDao, ZiliaoleixingEntity> implements ZiliaoleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiliaoleixingEntity> page = this.selectPage(
                new Query<ZiliaoleixingEntity>(params).getPage(),
                new EntityWrapper<ZiliaoleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiliaoleixingEntity> wrapper) {
		  Page<ZiliaoleixingView> page =new Query<ZiliaoleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZiliaoleixingView> selectListView(Wrapper<ZiliaoleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiliaoleixingView selectView(Wrapper<ZiliaoleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
