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

import com.cl.entity.ZiliaoleixingEntity;
import com.cl.entity.view.ZiliaoleixingView;

import com.cl.service.ZiliaoleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 资料类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
@RestController
@RequestMapping("/ziliaoleixing")
public class ZiliaoleixingController {
    @Autowired
    private ZiliaoleixingService ziliaoleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiliaoleixingEntity ziliaoleixing,
		HttpServletRequest request){
        EntityWrapper<ZiliaoleixingEntity> ew = new EntityWrapper<ZiliaoleixingEntity>();

		PageUtils page = ziliaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiliaoleixingEntity ziliaoleixing, 
		HttpServletRequest request){
        EntityWrapper<ZiliaoleixingEntity> ew = new EntityWrapper<ZiliaoleixingEntity>();

		PageUtils page = ziliaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiliaoleixingEntity ziliaoleixing){
       	EntityWrapper<ZiliaoleixingEntity> ew = new EntityWrapper<ZiliaoleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziliaoleixing, "ziliaoleixing")); 
        return R.ok().put("data", ziliaoleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiliaoleixingEntity ziliaoleixing){
        EntityWrapper< ZiliaoleixingEntity> ew = new EntityWrapper< ZiliaoleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziliaoleixing, "ziliaoleixing")); 
		ZiliaoleixingView ziliaoleixingView =  ziliaoleixingService.selectView(ew);
		return R.ok("查询资料类型成功").put("data", ziliaoleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiliaoleixingEntity ziliaoleixing = ziliaoleixingService.selectById(id);
		ziliaoleixing = ziliaoleixingService.selectView(new EntityWrapper<ZiliaoleixingEntity>().eq("id", id));
        return R.ok().put("data", ziliaoleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiliaoleixingEntity ziliaoleixing = ziliaoleixingService.selectById(id);
		ziliaoleixing = ziliaoleixingService.selectView(new EntityWrapper<ZiliaoleixingEntity>().eq("id", id));
        return R.ok().put("data", ziliaoleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiliaoleixingEntity ziliaoleixing, HttpServletRequest request){
    	ziliaoleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziliaoleixing);
        ziliaoleixingService.insert(ziliaoleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiliaoleixingEntity ziliaoleixing, HttpServletRequest request){
    	ziliaoleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziliaoleixing);
        ziliaoleixingService.insert(ziliaoleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiliaoleixingEntity ziliaoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziliaoleixing);
        ziliaoleixingService.updateById(ziliaoleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziliaoleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
