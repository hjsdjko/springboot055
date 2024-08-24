package com.controller;

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

import com.utils.ValidatorUtils;
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
import com.annotation.IgnoreAuth;

import com.entity.DiscusslvyoujingdianEntity;
import com.entity.view.DiscusslvyoujingdianView;

import com.service.DiscusslvyoujingdianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 旅游景点评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 19:25:40
 */
@RestController
@RequestMapping("/discusslvyoujingdian")
public class DiscusslvyoujingdianController {
    @Autowired
    private DiscusslvyoujingdianService discusslvyoujingdianService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusslvyoujingdianEntity discusslvyoujingdian,
		HttpServletRequest request){
        EntityWrapper<DiscusslvyoujingdianEntity> ew = new EntityWrapper<DiscusslvyoujingdianEntity>();

		PageUtils page = discusslvyoujingdianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusslvyoujingdian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusslvyoujingdianEntity discusslvyoujingdian, 
		HttpServletRequest request){
        EntityWrapper<DiscusslvyoujingdianEntity> ew = new EntityWrapper<DiscusslvyoujingdianEntity>();

		PageUtils page = discusslvyoujingdianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusslvyoujingdian), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusslvyoujingdianEntity discusslvyoujingdian){
       	EntityWrapper<DiscusslvyoujingdianEntity> ew = new EntityWrapper<DiscusslvyoujingdianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusslvyoujingdian, "discusslvyoujingdian")); 
        return R.ok().put("data", discusslvyoujingdianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusslvyoujingdianEntity discusslvyoujingdian){
        EntityWrapper< DiscusslvyoujingdianEntity> ew = new EntityWrapper< DiscusslvyoujingdianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusslvyoujingdian, "discusslvyoujingdian")); 
		DiscusslvyoujingdianView discusslvyoujingdianView =  discusslvyoujingdianService.selectView(ew);
		return R.ok("查询旅游景点评论表成功").put("data", discusslvyoujingdianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusslvyoujingdianEntity discusslvyoujingdian = discusslvyoujingdianService.selectById(id);
        return R.ok().put("data", discusslvyoujingdian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusslvyoujingdianEntity discusslvyoujingdian = discusslvyoujingdianService.selectById(id);
        return R.ok().put("data", discusslvyoujingdian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusslvyoujingdianEntity discusslvyoujingdian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusslvyoujingdian);
        discusslvyoujingdianService.insert(discusslvyoujingdian);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusslvyoujingdianEntity discusslvyoujingdian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusslvyoujingdian);
        discusslvyoujingdianService.insert(discusslvyoujingdian);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusslvyoujingdianEntity discusslvyoujingdian = discusslvyoujingdianService.selectOne(new EntityWrapper<DiscusslvyoujingdianEntity>().eq("", username));
        return R.ok().put("data", discusslvyoujingdian);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusslvyoujingdianEntity discusslvyoujingdian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusslvyoujingdian);
        discusslvyoujingdianService.updateById(discusslvyoujingdian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusslvyoujingdianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusslvyoujingdianEntity discusslvyoujingdian, HttpServletRequest request,String pre){
        EntityWrapper<DiscusslvyoujingdianEntity> ew = new EntityWrapper<DiscusslvyoujingdianEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discusslvyoujingdianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusslvyoujingdian), params), params));
        return R.ok().put("data", page);
    }










}
