package cn.zqq.Test;

import cn.zqq.Dao.EmployeeDao;
import cn.zqq.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * class创建日期
 *
 * @date 2020/9/719:27
 */
public class TestMybatis {
    @Test
    public void run() throws IOException {
        /*//加载配置文件
        InputStream resourceAsStream = null;
        SqlSession sqlSession=null;
        try {
            //获取配置文件
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            //构建工厂
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(resourceAsStream);
            //获取sqlSession
             sqlSession= factory.openSession();
            //获取代理对象
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            //调用Mapper方法
            List<Employee> employees = mapper.findAll();
            for (Employee e :
                    employees) {
                System.out.println(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
            resourceAsStream.close();
        }
*/
    }
}
