import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    @Test
    public void testPageHelper() {

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            PageHelper.startPage(1,2);
            List<Emp> list = mapper.selectByExample(null);
            PageInfo<Emp> page = new PageInfo<>(list,3);
            list.forEach(emp -> System.out.println(emp));
            System.out.println(page);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}