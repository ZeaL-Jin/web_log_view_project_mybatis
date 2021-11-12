package com.zeal.weblogviewproject.dao.impl;

import com.zeal.weblogviewproject.dao.AvgPvNumDao;
import com.zeal.weblogviewproject.model.AvgPvNum;
import com.zeal.weblogviewproject.utils.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZEAL
 *AvgPvNumDao接口的实现类
 */
public class AvgPvNumDaoImpl implements AvgPvNumDao {
    @Override
    public List<AvgPvNum> getAvgPvNumList() {
        //JdbcUtil工具类
        JdbcUtil jdbcUtil = new JdbcUtil();
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<AvgPvNum> avgPvNumList = null;

        Connection connection = jdbcUtil.getConnection();

        try {
            //4.创建sql的运算器
            statement = connection.createStatement();

            //5.通过sql的运算器执行sql语句(获取结果集)
            String sql = "select * from visitordata;";
            //结果集
            resultSet = statement.executeQuery(sql);
            avgPvNumList = new ArrayList<>();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String dateStr = resultSet.getString("dateStr");
                Float avgPvNum = resultSet.getFloat("avgPvNum");
                AvgPvNum avgPvNumDb = new AvgPvNum(id, dateStr, avgPvNum);
                avgPvNumList.add(avgPvNumDb);
            }
            System.out.println(avgPvNumList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(connection, statement, resultSet);
        }
        return avgPvNumList;
    }

}
