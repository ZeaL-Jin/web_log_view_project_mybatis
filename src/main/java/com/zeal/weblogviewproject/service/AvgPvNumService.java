package com.zeal.weblogviewproject.service;

import com.zeal.weblogviewproject.model.AvgReturnPojo;

/**
 * @author ZEAL
 * AvgPvNumService业务层接口
 */
public interface AvgPvNumService {
    /**
     * 获取日平均访问量的pojo对象
     *
     * @return
     */
    AvgReturnPojo getAvgReturnPojo();
}
