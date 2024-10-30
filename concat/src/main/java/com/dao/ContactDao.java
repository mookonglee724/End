//数据访问对象（DAO）接口

package com.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.ContactEntity;
import com.entity.view.ContactView;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.ContactVO;



/**
 * 通讯录
 */
public interface ContactDao extends BaseMapper<ContactEntity> {
	
	List<ContactVO> selectListVO(@Param("ew") Wrapper<ContactEntity> wrapper);
	
	ContactVO selectVO(@Param("ew") Wrapper<ContactEntity> wrapper);
	
	List<ContactView> selectListView(@Param("ew") Wrapper<ContactEntity> wrapper);

	List<ContactView> selectListView(Pagination page, @Param("ew") Wrapper<ContactEntity> wrapper);

	ContactView selectView(@Param("ew") Wrapper<ContactEntity> wrapper);
	
}
