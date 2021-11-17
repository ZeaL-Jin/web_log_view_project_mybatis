package com.zeal.weblogviewproject.dao;

import com.zeal.weblogviewproject.model.AvgPvNum;
import java.io.IOException;
import java.util.List;

/**
 * AvgPvNumMapper接口
 * @author ZEAL
 */
public interface AvgPvNumMapperDao {
    /**
     * 获取日平均访问量
     * @return 返回查询结果
     * @throws IOException 抛出全部异常
     */
    List<AvgPvNum> getAvgPvNumList() throws IOException;
}
