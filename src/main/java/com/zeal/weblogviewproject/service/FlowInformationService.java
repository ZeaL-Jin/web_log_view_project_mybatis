package com.zeal.weblogviewproject.service;

import com.zeal.weblogviewproject.model.FlowInformation;
import com.zeal.weblogviewproject.model.FlowReturnPojo;

import java.io.IOException;

/**
 * @author ZEAL
 */
public interface FlowInformationService {
    /**
     * 获取流量信息的pojo对象
     * @return 返回pojo
     * @throws IOException 抛出异常
     */
    FlowReturnPojo getFlowReturnPojo() throws IOException;
}
