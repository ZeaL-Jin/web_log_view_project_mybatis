package com.zeal.weblogviewproject.dao.impl;

import com.zeal.weblogviewproject.dao.AvgPvNumMapperDao;

import com.zeal.weblogviewproject.model.AvgPvNum;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @author ZEAL
 */
public class AvgPvNumMapperDaoImpl implements AvgPvNumMapperDao{
    @Override
    public List<AvgPvNum> getAvgPvNumList() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AvgPvNumMapperDao userMapperapper = sqlSession.getMapper(AvgPvNumMapperDao.class);
        List<AvgPvNum> findAll = userMapperapper.getAvgPvNumList();
        System.out.println("菜市场上厕所测试测试测试测试"+findAll);
        return findAll;
    }
}
