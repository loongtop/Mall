package com.gkhy.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gkhy.common.utils.PageUtils;
import com.gkhy.gulimall.ware.entity.WareOrderBillDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author leo
 * @email loongtop@gmail.com
 * @date 2021-02-06 21:14:16
 */
public interface WareOrderBillDetailService extends IService<WareOrderBillDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

