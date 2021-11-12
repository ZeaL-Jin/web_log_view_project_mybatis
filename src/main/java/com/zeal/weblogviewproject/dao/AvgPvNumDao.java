package com.zeal.weblogviewproject.dao;

import com.zeal.weblogviewproject.model.AvgPvNum;

import java.util.List;

/**
 * @author ZEAL
 * AvgPvNumDao接口(user表)
 * 接口（对外暴露的规则）
 */
public interface AvgPvNumDao {
    /**
     * 获取日平均访问量（规则）
     * @return
     */
    List<AvgPvNum> getAvgPvNumList();
}
