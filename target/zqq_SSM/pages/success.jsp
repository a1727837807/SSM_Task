<%--
  Created by IntelliJ IDEA.
  User: 翟
  Date: 2020/9/7
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC测试页面</title>
</head>
<body>
    <h3>验证码发送成功了...</h3>
    <table>
        <form action="/zqq_SSM_war_exploded/employee/validate.do" method="post">
            <tr>
                <td>验证码:<input type="text" name="code" /></td>
                <td><input type="submit" value="验证"></td>
            </tr>
        </form>
    </table>
</body>
</html>
