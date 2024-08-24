package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XuexiaoxinxiEntity;
import com.cl.entity.view.XuexiaoxinxiView;

import com.cl.service.XuexiaoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 学校信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
@RestController
@RequestMapping("/xuexiaoxinxi")
public class XuexiaoxinxiController {
    @Autowired
    private XuexiaoxinxiService xuexiaoxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuexiaoxinxiEntity xuexiaoxinxi,
		HttpServletRequest request){
        EntityWrapper<XuexiaoxinxiEntity> ew = new EntityWrapper<XuexiaoxinxiEntity>();

		PageUtils page = xuexiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuexiaoxinxiEntity xuexiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<XuexiaoxinxiEntity> ew = new EntityWrapper<XuexiaoxinxiEntity>();

		PageUtils page = xuexiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuexiaoxinxiEntity xuexiaoxinxi){
       	EntityWrapper<XuexiaoxinxiEntity> ew = new EntityWrapper<XuexiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuexiaoxinxi, "xuexiaoxinxi")); 
        return R.ok().put("data", xuexiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuexiaoxinxiEntity xuexiaoxinxi){
        EntityWrapper< XuexiaoxinxiEntity> ew = new EntityWrapper< XuexiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuexiaoxinxi, "xuexiaoxinxi")); 
		XuexiaoxinxiView xuexiaoxinxiView =  xuexiaoxinxiService.selectView(ew);
		return R.ok("查询学校信息成功").put("data", xuexiaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuexiaoxinxiEntity xuexiaoxinxi = xuexiaoxinxiService.selectById(id);
		xuexiaoxinxi = xuexiaoxinxiService.selectView(new EntityWrapper<XuexiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", xuexiaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuexiaoxinxiEntity xuexiaoxinxi = xuexiaoxinxiService.selectById(id);
		xuexiaoxinxi = xuexiaoxinxiService.selectView(new EntityWrapper<XuexiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", xuexiaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuexiaoxinxiEntity xuexiaoxinxi, HttpServletRequest request){
    	xuexiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiaoxinxi);
        xuexiaoxinxiService.insert(xuexiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuexiaoxinxiEntity xuexiaoxinxi, HttpServletRequest request){
    	xuexiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiaoxinxi);
        xuexiaoxinxiService.insert(xuexiaoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuexiaoxinxiEntity xuexiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuexiaoxinxi);
        xuexiaoxinxiService.updateById(xuexiaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuexiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
