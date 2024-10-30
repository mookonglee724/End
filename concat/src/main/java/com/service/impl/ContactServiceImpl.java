package com.service.impl;

import com.dao.ContactDao;
import com.entity.ContactEntity;
import com.entity.view.ContactView;
import com.service.ContactService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.entity.vo.ContactVO;

@Service("contactService")
public class ContactServiceImpl extends ServiceImpl<ContactDao, ContactEntity> implements ContactService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ContactEntity> page = this.selectPage(
                new Query<ContactEntity>(params).getPage(),
                new EntityWrapper<ContactEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ContactEntity> wrapper) {
		  Page<ContactView> page =new Query<ContactView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ContactVO> selectListVO(Wrapper<ContactEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ContactVO selectVO(Wrapper<ContactEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ContactView> selectListView(Wrapper<ContactEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ContactView selectView(Wrapper<ContactEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
