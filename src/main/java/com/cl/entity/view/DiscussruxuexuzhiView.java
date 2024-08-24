package com.cl.entity.view;

import com.cl.entity.DiscussruxuexuzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 入学须知评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-11 17:57:40
 */
@TableName("discussruxuexuzhi")
public class DiscussruxuexuzhiView  extends DiscussruxuexuzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussruxuexuzhiView(){
	}
 
 	public DiscussruxuexuzhiView(DiscussruxuexuzhiEntity discussruxuexuzhiEntity){
 	try {
			BeanUtils.copyProperties(this, discussruxuexuzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
