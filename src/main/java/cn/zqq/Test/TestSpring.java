package cn.zqq.Test;

import cn.zqq.Service.EmployeeService;
import cn.zqq.Service.EmployeeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * class创建日期
 *
 * @date 2020/9/717:25
 */
public class TestSpring {
    /**
     * 测试Spring框架可用性
     */
    @Test
    public void run(){
        //创建工厂，加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        EmployeeServiceImpl employeeService = (EmployeeServiceImpl) applicationContext.getBean(EmployeeService.class);
        employeeService.findAll();
    }
}
