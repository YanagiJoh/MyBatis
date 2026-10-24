import com.mybatis.mapper.DynamicSQLMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    @Test
    public void testGetEmpByCondition(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "Yang", 35, "男", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByChoose(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "Yang", 35, "男", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testDeleteEmpByArray(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result  = mapper.deleteMoreByArray(new Integer[]{6,7,8});
        System.out.println(result);
    }

    @Test
    public void testInsertEmpByList(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",23,"男","123@qq.com");
        Emp emp2 = new Emp(null,"a2",23,"男","123@qq.com");
        Emp emp3 = new Emp(null,"a3",23,"男","123@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int result  = mapper.insertMoreByList(emps);
        System.out.println(result);
    }

}

