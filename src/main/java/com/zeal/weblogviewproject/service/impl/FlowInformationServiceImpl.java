package com.zeal.weblogviewproject.service.impl;

import com.zeal.weblogviewproject.dao.impl.FlowInformationMapperDaoImpl;
import com.zeal.weblogviewproject.model.FlowInformation;
import com.zeal.weblogviewproject.model.FlowReturnPojo;
import com.zeal.weblogviewproject.service.FlowInformationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZEAL
 * FlowInformationService实现类
 */
public class FlowInformationServiceImpl implements FlowInformationService {
    private FlowInformationMapperDaoImpl flowInformationMapperDaoImpl = new FlowInformationMapperDaoImpl();

    @Override
    public FlowReturnPojo getFlowReturnPojo() throws IOException {
        List<FlowInformation> informationList = flowInformationMapperDaoImpl.getFlowInformation();

        ArrayList<String> datesArrays = new ArrayList<>();
        ArrayList<Integer> dataArrays1 = new ArrayList<>();
        ArrayList<Integer> dataArrays2 = new ArrayList<>();
        ArrayList<Integer> dataArrays3 = new ArrayList<>();
        ArrayList<Integer> dataArrays4 = new ArrayList<>();
        ArrayList<Integer> dataArrays5 = new ArrayList<>();

        for (FlowInformation flowInformation : informationList) {
            datesArrays.add(flowInformation.getDateStr());
            dataArrays1.add(flowInformation.getpVNum());
            dataArrays2.add(flowInformation.getuVNum());
            dataArrays3.add(flowInformation.getiPNum());
            dataArrays4.add(flowInformation.getNewUvNum());
            dataArrays5.add(flowInformation.getVisitNum());
        }
        FlowReturnPojo flowReturnPojo = new FlowReturnPojo();
        flowReturnPojo.setDatestr(datesArrays);
        flowReturnPojo.setpVNum(dataArrays1);
        flowReturnPojo.setpVNum(dataArrays1);
        flowReturnPojo.setuVNum(dataArrays2);
        flowReturnPojo.setiPNum(dataArrays3);
        flowReturnPojo.setNewUvNum(dataArrays4);
        flowReturnPojo.setVisitNum(dataArrays5);
        return flowReturnPojo;
    }
}
