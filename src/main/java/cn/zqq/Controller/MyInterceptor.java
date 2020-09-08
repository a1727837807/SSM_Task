package cn.zqq.Controller;

import cn.zqq.domain.Employee;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

/**
 * class创建日期
 *
 * @date 2020/9/814:25
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("xxx");
        return false;
    }
}
