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

import com.cl.entity.XiaoguixinxiEntity;
import com.cl.entity.view.XiaoguixinxiView;

import com.cl.service.XiaoguixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 校规信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 17:57:39
 */
@RestController
@RequestMapping("/xiaoguixinxi")
public class XiaoguixinxiController {
    @Autowired
    private XiaoguixinxiService xiaoguixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoguixinxiEntity xiaoguixinxi,
		HttpServletRequest request){
        EntityWrapper<XiaoguixinxiEntity> ew = new EntityWrapper<XiaoguixinxiEntity>();

		PageUtils page = xiaoguixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoguixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoguixinxiEntity xiaoguixinxi, 
		HttpServletRequest request){
        EntityWrapper<XiaoguixinxiEntity> ew = new EntityWrapper<XiaoguixinxiEntity>();

		PageUtils page = xiaoguixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoguixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoguixinxiEntity xiaoguixinxi){
       	EntityWrapper<XiaoguixinxiEntity> ew = new EntityWrapper<XiaoguixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoguixinxi, "xiaoguixinxi")); 
        return R.ok().put("data", xiaoguixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoguixinxiEntity xiaoguixinxi){
        EntityWrapper< XiaoguixinxiEntity> ew = new EntityWrapper< XiaoguixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoguixinxi, "xiaoguixinxi")); 
		XiaoguixinxiView xiaoguixinxiView =  xiaoguixinxiService.selectView(ew);
		return R.ok("查询校规信息成功").put("data", xiaoguixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoguixinxiEntity xiaoguixinxi = xiaoguixinxiService.selectById(id);
		xiaoguixinxi = xiaoguixinxiService.selectView(new EntityWrapper<XiaoguixinxiEntity>().eq("id", id));
        return R.ok().put("data", xiaoguixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoguixinxiEntity xiaoguixinxi = xiaoguixinxiService.selectById(id);
		xiaoguixinxi = xiaoguixinxiService.selectView(new EntityWrapper<XiaoguixinxiEntity>().eq("id", id));
        return R.ok().put("data", xiaoguixinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XiaoguixinxiEntity xiaoguixinxi = xiaoguixinxiService.selectById(id);
        if(type.equals("1")) {
        	xiaoguixinxi.setThumbsupnum(xiaoguixinxi.getThumbsupnum()+1);
        } else {
        	xiaoguixinxi.setCrazilynum(xiaoguixinxi.getCrazilynum()+1);
        }
        xiaoguixinxiService.updateById(xiaoguixinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoguixinxiEntity xiaoguixinxi, HttpServletRequest request){
    	xiaoguixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoguixinxi);
        xiaoguixinxiService.insert(xiaoguixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoguixinxiEntity xiaoguixinxi, HttpServletRequest request){
    	xiaoguixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoguixinxi);
        xiaoguixinxiService.insert(xiaoguixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaoguixinxiEntity xiaoguixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoguixinxi);
        xiaoguixinxiService.updateById(xiaoguixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoguixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
