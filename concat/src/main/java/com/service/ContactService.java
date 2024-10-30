package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ContactEntity;
import com.entity.view.ContactView;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;
import com.entity.vo.ContactVO;
import org.apache.ibatis.annotations.Param;



/**
 * 通讯录
 */
public interface ContactService extends IService<ContactEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ContactVO> selectListVO(Wrapper<ContactEntity> wrapper);
   	
   	ContactVO selectVO(@Param("ew") Wrapper<ContactEntity> wrapper);
   	
   	List<ContactView> selectListView(Wrapper<ContactEntity> wrapper);

	ContactView selectView(@Param("ew") Wrapper<ContactEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ContactEntity> wrapper);
   	
}

