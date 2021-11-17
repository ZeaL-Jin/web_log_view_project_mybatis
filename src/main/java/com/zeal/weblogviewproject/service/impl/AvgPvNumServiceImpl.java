package com.zeal.weblogviewproject.service.impl;

import com.zeal.weblogviewproject.dao.impl.AvgPvNumMapperDaoImpl;
import com.zeal.weblogviewproject.model.AvgPvNum;
import com.zeal.weblogviewproject.model.AvgReturnPojo;
import com.zeal.weblogviewproject.service.AvgPvNumService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZEAL
 * AvgPvNumService实现类
 */
public class AvgPvNumServiceImpl implements AvgPvNumService {

    private AvgPvNumMapperDaoImpl avgPvNumMapperDaoImpl = new AvgPvNumMapperDaoImpl();

    @Override
    public AvgReturnPojo getAvgReturnPojo() throws IOException {
        //调用dao层的代码获取日平均访问量的集合

        List<AvgPvNum> avgPvNumList = avgPvNumMapperDaoImpl.getAvgPvNumList();

        //将avgPvNumList集合里面的数据封装成一个pojo对象
        ArrayList<String> datesArrays = new ArrayList<>();
        ArrayList<String> dataArrays = new ArrayList<>();

        for (AvgPvNum avgPvNum : avgPvNumList) {
            datesArrays.add(avgPvNum.getDateStr());
            dataArrays.add(String.valueOf(avgPvNum.getAvgPvNum()));
        }
        AvgReturnPojo avgReturnPojo = new AvgReturnPojo();
        avgReturnPojo.setDates(datesArrays);
        avgReturnPojo.setData(dataArrays);
        return avgReturnPojo;
    }
}
