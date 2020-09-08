package cn.zqq.Service;

import cn.zqq.domain.Employee;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * class创建日期
 *
 * @date 2020/9/717:11
 */
public interface EmployeeService {
    //查询所有
     List<Employee> findAll();

    void save(Employee employee);

    void update(Employee employee);

    void delete(int id);

    Employee findById(int id);
}
