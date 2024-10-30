package com.entity.vo;

import java.io.Serializable;
 

/**
 *
 * 客户端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class ContactVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 姓名
	 */

	private String name;

	/**
	 * 电话号码
	 */

	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
