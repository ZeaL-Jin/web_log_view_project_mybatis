package com.zeal.weblogviewproject.service;

import com.zeal.weblogviewproject.model.AvgReturnPojo;

import java.io.IOException;

/**
 * @author ZEAL
 * AvgPvNumService业务层接口
 */
public interface AvgPvNumService {
    /**
     * 获取日平均流量pojo对象
     * @return 返回pojo
     * @throws IOException 抛出异常
     */
    AvgReturnPojo getAvgReturnPojo() throws IOException;
}
