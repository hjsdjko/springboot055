package com.entity.view;

import com.entity.DiscusslvyoujingdianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 旅游景点评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 19:25:40
 */
@TableName("discusslvyoujingdian")
public class DiscusslvyoujingdianView  extends DiscusslvyoujingdianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusslvyoujingdianView(){
	}
 
 	public DiscusslvyoujingdianView(DiscusslvyoujingdianEntity discusslvyoujingdianEntity){
 	try {
			BeanUtils.copyProperties(this, discusslvyoujingdianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
