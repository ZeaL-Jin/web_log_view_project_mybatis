package com.zeal.weblogviewproject.model;

import java.util.List;

/**
 * @author ZEAL
 */
public class FlowReturnPojo {
    private List<String> dateStr;
    private List<Integer> pVNum;
    private List<Integer> uVNum;
    private List<Integer> iPNum;
    private List<Integer> newUvNum;
    private List<Integer> visitNum;

    public List<String> getDatestr() {
        return dateStr;
    }

    public void setDatestr(List<String> datestr) {
        this.dateStr = datestr;
    }

    public List<Integer> getpVNum() {
        return pVNum;
    }

    public void setpVNum(List<Integer> pVNum) {
        this.pVNum = pVNum;
    }

    public List<Integer> getuVNum() {
        return uVNum;
    }

    public void setuVNum(List<Integer> uVNum) {
        this.uVNum = uVNum;
    }

    public List<Integer> getiPNum() {
        return iPNum;
    }

    public void setiPNum(List<Integer> iPNum) {
        this.iPNum = iPNum;
    }

    public List<Integer> getNewUvNum() {
        return newUvNum;
    }

    public void setNewUvNum(List<Integer> newUvNum) {
        this.newUvNum = newUvNum;
    }

    public List<Integer> getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(List<Integer> visitNum) {
        this.visitNum = visitNum;
    }


}
