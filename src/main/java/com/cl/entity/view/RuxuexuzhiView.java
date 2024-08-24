package com.cl.entity.view;

import com.cl.entity.RuxuexuzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 入学须知
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
@TableName("ruxuexuzhi")
public class RuxuexuzhiView  extends RuxuexuzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RuxuexuzhiView(){
	}
 
 	public RuxuexuzhiView(RuxuexuzhiEntity ruxuexuzhiEntity){
 	try {
			BeanUtils.copyProperties(this, ruxuexuzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
