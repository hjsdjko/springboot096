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

import com.cl.entity.ZiliaofenxiangEntity;
import com.cl.entity.view.ZiliaofenxiangView;

import com.cl.service.ZiliaofenxiangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 资料分享
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
@RestController
@RequestMapping("/ziliaofenxiang")
public class ZiliaofenxiangController {
    @Autowired
    private ZiliaofenxiangService ziliaofenxiangService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiliaofenxiangEntity ziliaofenxiang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			ziliaofenxiang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZiliaofenxiangEntity> ew = new EntityWrapper<ZiliaofenxiangEntity>();

		PageUtils page = ziliaofenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaofenxiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiliaofenxiangEntity ziliaofenxiang, 
		HttpServletRequest request){
        EntityWrapper<ZiliaofenxiangEntity> ew = new EntityWrapper<ZiliaofenxiangEntity>();

		PageUtils page = ziliaofenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaofenxiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiliaofenxiangEntity ziliaofenxiang){
       	EntityWrapper<ZiliaofenxiangEntity> ew = new EntityWrapper<ZiliaofenxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziliaofenxiang, "ziliaofenxiang")); 
        return R.ok().put("data", ziliaofenxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiliaofenxiangEntity ziliaofenxiang){
        EntityWrapper< ZiliaofenxiangEntity> ew = new EntityWrapper< ZiliaofenxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziliaofenxiang, "ziliaofenxiang")); 
		ZiliaofenxiangView ziliaofenxiangView =  ziliaofenxiangService.selectView(ew);
		return R.ok("查询资料分享成功").put("data", ziliaofenxiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiliaofenxiangEntity ziliaofenxiang = ziliaofenxiangService.selectById(id);
		ziliaofenxiang = ziliaofenxiangService.selectView(new EntityWrapper<ZiliaofenxiangEntity>().eq("id", id));
        return R.ok().put("data", ziliaofenxiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiliaofenxiangEntity ziliaofenxiang = ziliaofenxiangService.selectById(id);
		ziliaofenxiang = ziliaofenxiangService.selectView(new EntityWrapper<ZiliaofenxiangEntity>().eq("id", id));
        return R.ok().put("data", ziliaofenxiang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiliaofenxiangEntity ziliaofenxiang, HttpServletRequest request){
    	ziliaofenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziliaofenxiang);
        ziliaofenxiangService.insert(ziliaofenxiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiliaofenxiangEntity ziliaofenxiang, HttpServletRequest request){
    	ziliaofenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziliaofenxiang);
        ziliaofenxiangService.insert(ziliaofenxiang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiliaofenxiangEntity ziliaofenxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziliaofenxiang);
        ziliaofenxiangService.updateById(ziliaofenxiang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziliaofenxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
