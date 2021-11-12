package com.zeal.weblogviewproject.dao;

import com.zeal.weblogviewproject.model.FlowInformation;

import java.util.List;

/**
 * @author ZEAL
 * FlowInformationDao接口
 */
public interface FlowInformationDao {
    /**
     * 获取流量信息
     * @return
     */
    List<FlowInformation> getFlowInformation();
}
