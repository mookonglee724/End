package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ContactEntity;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 通讯录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("contact")
public class ContactView extends ContactEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ContactView(){
	}
 
 	public ContactView(ContactEntity contactEntity){
 	try {
			BeanUtils.copyProperties(this, contactEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
