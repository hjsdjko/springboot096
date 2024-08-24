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

import com.cl.entity.RuxuexuzhiEntity;
import com.cl.entity.view.RuxuexuzhiView;

import com.cl.service.RuxuexuzhiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 入学须知
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
@RestController
@RequestMapping("/ruxuexuzhi")
public class RuxuexuzhiController {
    @Autowired
    private RuxuexuzhiService ruxuexuzhiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RuxuexuzhiEntity ruxuexuzhi,
		HttpServletRequest request){
        EntityWrapper<RuxuexuzhiEntity> ew = new EntityWrapper<RuxuexuzhiEntity>();

		PageUtils page = ruxuexuzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ruxuexuzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RuxuexuzhiEntity ruxuexuzhi, 
		HttpServletRequest request){
        EntityWrapper<RuxuexuzhiEntity> ew = new EntityWrapper<RuxuexuzhiEntity>();

		PageUtils page = ruxuexuzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ruxuexuzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RuxuexuzhiEntity ruxuexuzhi){
       	EntityWrapper<RuxuexuzhiEntity> ew = new EntityWrapper<RuxuexuzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ruxuexuzhi, "ruxuexuzhi")); 
        return R.ok().put("data", ruxuexuzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RuxuexuzhiEntity ruxuexuzhi){
        EntityWrapper< RuxuexuzhiEntity> ew = new EntityWrapper< RuxuexuzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ruxuexuzhi, "ruxuexuzhi")); 
		RuxuexuzhiView ruxuexuzhiView =  ruxuexuzhiService.selectView(ew);
		return R.ok("查询入学须知成功").put("data", ruxuexuzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RuxuexuzhiEntity ruxuexuzhi = ruxuexuzhiService.selectById(id);
		ruxuexuzhi = ruxuexuzhiService.selectView(new EntityWrapper<RuxuexuzhiEntity>().eq("id", id));
        return R.ok().put("data", ruxuexuzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RuxuexuzhiEntity ruxuexuzhi = ruxuexuzhiService.selectById(id);
		ruxuexuzhi = ruxuexuzhiService.selectView(new EntityWrapper<RuxuexuzhiEntity>().eq("id", id));
        return R.ok().put("data", ruxuexuzhi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        RuxuexuzhiEntity ruxuexuzhi = ruxuexuzhiService.selectById(id);
        if(type.equals("1")) {
        	ruxuexuzhi.setThumbsupnum(ruxuexuzhi.getThumbsupnum()+1);
        } else {
        	ruxuexuzhi.setCrazilynum(ruxuexuzhi.getCrazilynum()+1);
        }
        ruxuexuzhiService.updateById(ruxuexuzhi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RuxuexuzhiEntity ruxuexuzhi, HttpServletRequest request){
    	ruxuexuzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ruxuexuzhi);
        ruxuexuzhiService.insert(ruxuexuzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RuxuexuzhiEntity ruxuexuzhi, HttpServletRequest request){
    	ruxuexuzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ruxuexuzhi);
        ruxuexuzhiService.insert(ruxuexuzhi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RuxuexuzhiEntity ruxuexuzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ruxuexuzhi);
        ruxuexuzhiService.updateById(ruxuexuzhi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ruxuexuzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
