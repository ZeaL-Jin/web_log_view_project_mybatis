package com.zeal.weblogviewproject.dao;

import com.zeal.weblogviewproject.model.FlowInformation;

import java.io.IOException;
import java.util.List;

/**
 *FlowInformationDao接口
 * @author ZEAL
 */
public interface FlowInformationMapperDao {
    /**
     * 获取流量信息
     * @return 返回查询结果
     * @throws IOException 抛出异常
     */
    List<FlowInformation> getFlowInformation() throws IOException;
}
