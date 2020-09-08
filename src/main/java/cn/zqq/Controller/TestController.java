package cn.zqq.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * class创建日期
 *
 * @date 0000/9/88:06
 */
@Controller
@RequestMapping("/testException")
public class TestController {
    @RequestMapping("/login")
    public String login(String username,String password){
        if ("admin".equals(username)&&"123456".equals(password))
            return "success";
        return "fail";
    }
    @RequestMapping(value="/nullPointerException")
    public void nullPointerExceptionTest() throws Exception{
        String str=null;
        str.length();
    }
    @RequestMapping(value = "/indexOutOfBoundsTest")
    public void indexOutOfBoundsTest()throws  Exception{
        int[] arr={1,2};
        System.out.println(arr[10]);

    }
    @RequestMapping(value = "arithmeticExceptionTest")
    public void arithmeticExceptionTest()throws  Exception{
        int i=10/0;
    }
}
