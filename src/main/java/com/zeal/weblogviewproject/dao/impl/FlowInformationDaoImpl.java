package com.zeal.weblogviewproject.dao.impl;

import com.zeal.weblogviewproject.model.FlowInformation;
import com.zeal.weblogviewproject.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZEAL
 */
public class FlowInformationDaoImpl {
    public List<FlowInformation> getFlowInformation(){
        //JdbcUtil工具类
        JdbcUtil jdbcUtil = new JdbcUtil();
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<FlowInformation> flowInformationList = null;

        Connection connection = jdbcUtil.getConnection();

        try {
            //4.创建sql的运算器
            statement = connection.createStatement();

            //5.通过sql的运算器执行sql语句(获取结果集)
            String sql = "select * from t_flow_num;";
            //结果集
            resultSet = statement.executeQuery(sql);
            flowInformationList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String dateStr = resultSet.getString("dateStr");
                int pvNum = resultSet.getInt("pVNum");
                int uVNum = resultSet.getInt("uVNum");
                int iPNum = resultSet.getInt("iPNum");
                int newUvNum = resultSet.getInt("newUvNum");
                int visitNum = resultSet.getInt("visitNum");

                FlowInformation flowInformationDb = new FlowInformation(id,dateStr,pvNum,uVNum,iPNum,newUvNum,visitNum);

                flowInformationList.add(flowInformationDb);
            }
            System.out.println(flowInformationList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(connection, statement, resultSet);
        }
//
        return flowInformationList;
    }
}
