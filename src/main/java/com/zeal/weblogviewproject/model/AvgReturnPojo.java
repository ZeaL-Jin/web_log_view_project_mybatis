package com.zeal.weblogviewproject.model;

import java.util.List;

/**
 * @author ZEAL
 * pojo领域模型对象
 *
 */
public class AvgReturnPojo {
    private List<String> dates;
    private List<String> data;

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
