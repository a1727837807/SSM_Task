package cn.zqq.Controller;

import cn.zqq.domain.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * class创建日期
 *
 * @date 2020/9/813:35
 */
public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        System.out.println("xxx");
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            String phone = e.getPhone();
            if (!phone.matches("^1(3|4|5|7|8)\\d{9}$")) {
                errors.rejectValue("PhoneNum", "error.PhoneNum.NoMatch", "must match the regex");
            }
            String sex = e.getSex();
            if (!sex.matches("(男|女)")) {
                errors.rejectValue("Sex", "error.Sex.NoMatch", "must match the regex");
            }
            String password = e.getPassword();
            if (!password.matches(
                    "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,30}")) {
                errors.rejectValue("Password", "error.PassWord.NoMatch", "输入密码不符合要求");
            }
            System.out.println("xxx");
        }

    }
}
