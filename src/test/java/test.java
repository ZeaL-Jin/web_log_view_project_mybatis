import com.zeal.weblogviewproject.dao.AvgPvNumMapperDao;
import com.zeal.weblogviewproject.dao.FlowInformationMapperDao;
import com.zeal.weblogviewproject.model.AvgPvNum;
import com.zeal.weblogviewproject.model.FlowInformation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AvgPvNumMapperDao userMapperapper = sqlSession.getMapper(AvgPvNumMapperDao.class);

        List<AvgPvNum> all = userMapperapper.getAvgPvNumList();
        System.out.println(all);
    }

    @Test
    public void test2() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FlowInformationMapperDao userMapperapper = sqlSession.getMapper(FlowInformationMapperDao.class);

        List<FlowInformation> all = userMapperapper.getFlowInformation();
        System.out.println(all);
    }
}
