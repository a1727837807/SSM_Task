package cn.zqq.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * class创建日期
 *
 * @date 2020/9/88:41
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e ){
        try {
            FileOutputStream fos=new FileOutputStream("D:\\SSM_Error.log",true);
            PrintStream ps=new PrintStream(fos);
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=sdf.format(date)+"---------";
            System.out.println(time);
            ps.println();
            ps.print(time);

            //错误信息打印
            e.printStackTrace(ps);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error/exception");
        return mv;
    }
}
