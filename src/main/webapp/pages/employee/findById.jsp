<%--
  Created by IntelliJ IDEA.
  User: 翟
  Date: 2020/9/8
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FindSuccess</title>
</head>
<body>
    <table>
        <tr>
            <td>Id</td>
            <td>性名</td>
            <td>性别</td>
            <td>地址</td>
            <td>电话</td>
        </tr>
        <tr>
            <td>#{NewEmployee.id}</td>
            <td>#{NewEmployee.name}</td>
            <td>#{NewEmployee.sex}</td>
            <td>#{NewEmployee.address}</td>
            <td>#{NewEmployee.phone}</td>
        </tr>
    </table>
</body>
</html>
