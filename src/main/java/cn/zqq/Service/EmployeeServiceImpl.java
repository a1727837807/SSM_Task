package cn.zqq.Service;

import cn.zqq.Dao.EmployeeDao;
import cn.zqq.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * class创建日期
 *
 * @date 2020/9/717:14
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        System.out.println("业务层查询所有的员工");
        return employeeDao.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
        System.out.println("添加员工已保存");
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
        System.out.println("员工信息已更新");
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
        System.out.println("员工："+id+"已删除");
    }

    @Override
    public Employee findById(int id) {
        Employee e = employeeDao.findById(id);
        System.out.println("查找员工："+id);
        return e;
    }
}
