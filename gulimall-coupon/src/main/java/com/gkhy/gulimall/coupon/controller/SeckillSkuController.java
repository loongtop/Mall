package com.gkhy.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gkhy.gulimall.coupon.entity.SeckillSkuEntity;
import com.gkhy.gulimall.coupon.service.SeckillSkuService;
import com.gkhy.common.utils.PageUtils;
import com.gkhy.common.utils.R;



/**
 * 秒杀活动商品关联
 *
 * @author leo
 * @email loongtop@gmail.com
 * @date 2021-02-06 13:20:52
 */
@RestController
@RequestMapping("coupon/seckillsku")
public class SeckillSkuController {
    @Autowired
    private SeckillSkuService seckillSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("coupon:seckillsku:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("coupon:seckillsku:info")
    public R info(@PathVariable("id") Long id){
		SeckillSkuEntity seckillSku = seckillSkuService.getById(id);

        return R.ok().put("seckillSku", seckillSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("coupon:seckillsku:save")
    public R save(@RequestBody SeckillSkuEntity seckillSku){
		seckillSkuService.save(seckillSku);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("coupon:seckillsku:update")
    public R update(@RequestBody SeckillSkuEntity seckillSku){
		seckillSkuService.updateById(seckillSku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("coupon:seckillsku:delete")
    public R delete(@RequestBody Long[] ids){
		seckillSkuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
