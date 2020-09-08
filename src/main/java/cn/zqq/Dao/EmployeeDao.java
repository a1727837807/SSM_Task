package cn.zqq.Dao;

import cn.zqq.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * class创建日期
 *
 * @date 2020/9/719:25
 */
public interface EmployeeDao {
    @Select(value = "select * from employee")
    List<Employee> findAll();
    @Insert("insert into employee(name,sex,address,phone,password) values(#{name},#{sex},#{address},#{phone},#{password})")
    void save(Employee employee);
    @Update("update employee set name=#{name},sex=#{sex},address=#{address},phone=#{phone},password=#{password} where id=#{id}")
    void update(Employee employee);
    @Delete("delete from employee where id=#{id}")
    void delete(int id);
    @Select("select * from employee where id=#{id}")
    Employee findById(int id);
}
