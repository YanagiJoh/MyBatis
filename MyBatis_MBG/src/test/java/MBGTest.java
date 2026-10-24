import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MBGTest {

    @Test
    public void testMBG(){

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
//            EmpExample example = new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("Yang").andAgeGreaterThanOrEqualTo(20);
//            example.or().andDidIsNotNull();
//            List<Emp> list = mapper.selectByExample(example);
//            list.forEach(emp -> System.out.println(emp));
            mapper.updateByPrimaryKey(new Emp(1,"admin",22,"女","456@qq.com",3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
