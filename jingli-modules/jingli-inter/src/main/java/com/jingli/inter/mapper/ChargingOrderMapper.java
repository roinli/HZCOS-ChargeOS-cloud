package com.jingli.inter.mapper;

import com.jingli.inter.entity.ChargingOrder;
import org.apache.ibatis.annotations.Mapper;


 /**
 * 充电订单表;(c_charging_order)表数据库访问层
 * @author : Abdulla
 * @date : 2023-8-25
 */
@Mapper
public interface ChargingOrderMapper{
    int insert(ChargingOrder chargingOrder);


 }