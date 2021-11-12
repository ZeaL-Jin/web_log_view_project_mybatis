package com.zeal.weblogviewproject.model;

/**
 * @author ZEAL
 * 流量信息模型（t_flow_num表对应的JavaBean）
 * 对数据的定义
 */
public class FlowInformation {

    private int id;
    private String dateStr;
    private int pVNum;
    private int uVNum;
    private int iPNum;
    private int newUvNum;
    private int visitNum;

    public FlowInformation() {
    }

    public FlowInformation(int id, String dateStr, int pVNum, int uVNum, int iPNum, int newUvNum, int visitNum) {
        this.id = id;
        this.dateStr = dateStr;
        this.pVNum = pVNum;
        this.uVNum = uVNum;
        this.iPNum = iPNum;
        this.newUvNum = newUvNum;
        this.visitNum = visitNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public int getpVNum() {
        return pVNum;
    }

    public void setpVNum(int pVNum) {
        this.pVNum = pVNum;
    }

    public int getuVNum() {
        return uVNum;
    }

    public void setuVNum(int uVNum) {
        this.uVNum = uVNum;
    }

    public int getiPNum() {
        return iPNum;
    }

    public void setiPNum(int iPNum) {
        this.iPNum = iPNum;
    }

    public int getNewUvNum() {
        return newUvNum;
    }

    public void setNewUvNum(int newUvNum) {
        this.newUvNum = newUvNum;
    }

    public int getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(int visitNum) {
        this.visitNum = visitNum;
    }

    @Override
    public String toString() {
        return "FlowInformation{" +
                "id=" + id +
                ", dateStr='" + dateStr + '\'' +
                ", pVNum=" + pVNum +
                ", uVNum=" + uVNum +
                ", iPNum=" + iPNum +
                ", newUvNum=" + newUvNum +
                ", visitNum=" + visitNum +
                '}';
    }
}
