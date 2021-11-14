package com.zeal.weblogviewproject.service;

import com.zeal.weblogviewproject.model.FlowInformation;
import com.zeal.weblogviewproject.model.FlowReturnPojo;

/**
 * @author ZEAL
 */
public interface FlowInformationService {
    /**
     * 获取流量信息的pojo对象
     *
     * @return
     */
    FlowReturnPojo getFlowReturnPojo();
}
