<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 翟
  Date: 2020/9/7
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC测试页面</title>
    <h3>员工列表页面</h3>
    <a href="/zqq_SSM_war_exploded/employee/findAll.do">查询所有员工</a>
</head>
<h3>测试查找员工功能</h3>
<form action="/zqq_SSM_war_exploded/employee/findById.do" method="post">
    ID：<input type="text" name="id"/><br/>
    <input type="submit" value="查找"/>
</form>
<body>
    <h3>测试添加员工功能</h3>
<form action="/zqq_SSM_war_exploded/employee/save.do" method="post">
    姓名：<input type="text" name="name"/><br/>
    性别：<input type="text" name="sex" /> <br/>
    地址：<input type="text" name="address"/><br/>
    电话：<input type="text" name="phone"/><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" value="保存"/>
</form>

    <h3>测试修改员工功能</h3>
    <form action="/zqq_SSM_war_exploded/employee/update.do" method="post">
        ID：<input type="text" name="id"/><br/>
        <h4>更改内容</h4><br/>
        姓名：<input type="text" name="name"/><br/>
        性别：<input type="text" name="sex" /> <br/>
        地址：<input type="text" name="address"/><br/>
        电话：<input type="text" name="phone"/><br/>
        密码：<input type="text" name="password"/><br/>
        <input type="submit" value="更新"/>
    </form>
    <h3>测试删除员工功能</h3>
    <form action="/zqq_SSM_war_exploded/employee/delete.do" method="post">
        ID：<input type="text" name="id"/><br/>
        <input type="submit" value="删除"/>
    </form>
    <h3>测试发送验证信息</h3>
    <table>
    <form action="/zqq_SSM_war_exploded/employee/sendSms.do" method="post">
            <tr>
                <td>电话:<input type="text" name="phone"/></td>
                <td><input type="submit" value="发送"></td>
            </tr>
        </form>
    </table>
    </form>
    </body>
</html>
