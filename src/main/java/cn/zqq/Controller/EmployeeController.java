package cn.zqq.Controller;

import cn.zqq.Service.EmployeeService;
import cn.zqq.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * class创建日期
 *
 * @date 2020/9/718:21
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        System.out.println("表现层：查询所有员工");
        List<Employee> employeesList = employeeService.findAll();
        for (Employee e :
                employeesList) {
            System.out.println(e);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping("/save.do")
    public ModelAndView save(Employee employee){
        //调用Service，保存数据
        employeeService.save(employee);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Success/insertSuccess");
        List<Employee> employeesList = employeeService.findAll();
        for (Employee e :
                employeesList) {
            System.out.println(e);
        }
        return mv;
    }
    @RequestMapping("/update.do")
    public ModelAndView update(Employee employee){
        employeeService.update(employee);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Success/updateSuccess");
        return mv;
    }
    @RequestMapping("/delete.do")
    public ModelAndView delete(int id){
        employeeService.delete(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Success/deleteSuccess");
        return mv;
    }
    @RequestMapping("/findById.do")
    public @ResponseBody ModelAndView
    findById(int id){
        Employee e = employeeService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Success/findSuccess");
        Map<String, Object> model = mv.getModel();
        model.put("id",e.getId());
        model.put("name",e.getName());
        model.put("sex",e.getSex());
        model.put("address",e.getAddress());
        model.put("phone",e.getPhone());
        System.out.println(e);
        return mv;
    }
}
