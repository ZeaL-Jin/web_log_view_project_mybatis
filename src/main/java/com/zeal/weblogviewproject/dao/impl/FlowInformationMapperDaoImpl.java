package com.zeal.weblogviewproject.dao.impl;

import com.zeal.weblogviewproject.dao.FlowInformationMapperDao;
import com.zeal.weblogviewproject.model.FlowInformation;
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
public class FlowInformationMapperDaoImpl implements FlowInformationMapperDao{
    @Override
    public List<FlowInformation> getFlowInformation() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FlowInformationMapperDao userMapperapper = sqlSession.getMapper(FlowInformationMapperDao.class);
        List<FlowInformation> findAll = userMapperapper.getFlowInformation();
        System.out.println("菜市场上厕所测试测试测试测试"+findAll);
        return findAll;
    }
}
