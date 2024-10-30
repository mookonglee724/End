package com.controller;


import java.util.Arrays;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.entity.ContactEntity;

import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


/**
 * 通讯录
 * 后端接口
 */
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ContactEntity contact,
                  HttpServletRequest request){
        EntityWrapper<ContactEntity> ew = new EntityWrapper<ContactEntity>();
		PageUtils page = contactService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, contact), params), params));

        return R.ok().put("data", page);
    }


	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ContactEntity contact = contactService.selectById(id);
        return R.ok().put("data", contact);
    }

    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ContactEntity contact, HttpServletRequest request){
        contactService.insert(contact);
        return R.ok();
    }
    


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ContactEntity contact, HttpServletRequest request){
        contactService.updateById(contact);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        contactService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
