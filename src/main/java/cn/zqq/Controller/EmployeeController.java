package cn.zqq.Controller;

import cn.zqq.Service.EmployeeService;
import cn.zqq.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    public ModelAndView save(@ModelAttribute(name = "Employee") Employee employee, BindingResult bindingResult){
        ModelAndView mv = new ModelAndView();
        System.out.println("开始验证");
        new EmployeeValidator().validate(employee,bindingResult);
        if (bindingResult.hasErrors()){
            System.out.println("插入失败");
            mv.setViewName("error/SaveFail");
            return mv;
        }
        //调用Service，保存数据
        employeeService.save(employee);
        mv.setViewName("Success/insertSuccess");
        List<Employee> employeesList = employeeService.findAll();
        for (Employee e :
                employeesList) {
            System.out.println(e);
        }
        return mv;
    }
    @RequestMapping("/update.do")
    public ModelAndView update(@ModelAttribute(name = "Employee") Employee employee, BindingResult bindingResult){
        ModelAndView mv = new ModelAndView();
        new EmployeeValidator().validate(employee,bindingResult);
        if (bindingResult.hasErrors()){
            mv.setViewName("error/UpdateFail");
            return mv;
        }
        employeeService.update(employee);
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
    @ModelAttribute("NewEmployee")
    public @ResponseBody Employee
    findById(int id){
        Employee e = employeeService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employee/findById");
        /*Map<String, Object> model = mv.getModel();
        model.put("id",e.getId());
        model.put("name",e.getName());
        model.put("sex",e.getSex());
        model.put("address",e.getAddress());
        model.put("phone",e.getPhone());*/
        System.out.println(e);
        return e;
    }
    @RequestMapping(value = "/sendSms.do")
    @ResponseBody
    @ModelAttribute("Code")
    public ModelAndView sendSMS(@RequestParam("phone") String phone, HttpServletRequest request) throws Exception {
        System.out.println(phone);
        HttpSession session = request.getSession();
        session.setAttribute("validatePhone", phone);
        session.setAttribute("sendCodeTime", new Date().getTime());
        int Code = SMSUtil.SendCode(phone);
        String ResCode=Code+"";
        ModelAndView mv=new ModelAndView();
        if (ResCode!=Integer.MIN_VALUE+""&&ResCode!=""&&ResCode!=null){
            session.setAttribute("CorrectCode",ResCode);
        mv.addObject("resCode",ResCode);
        System.out.println("发送成功");
            System.out.println(ResCode);
        mv.setViewName("success");
        }else {
            System.out.println("发送失败");
            mv.setViewName("failure");
        }
        return mv;
    }
    @RequestMapping("/validate.do")
    @ResponseBody
    protected String validate(HttpServletRequest request,@RequestParam ("code") String inputCode){
        HttpSession session = request.getSession();
        Object resCode = session.getAttribute("CorrectCode");
        if (resCode instanceof String) {
            String code=(String) resCode;
            System.out.println(code);
            if(inputCode.length()==6&&code.equals(inputCode))
                return "success";
        }
        return "false";
    }
    @InitBinder("NewEmployee")
    public void initBinder_New(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Integer.class,new CustomNumberEditor(Integer.class,false));
    }
}
