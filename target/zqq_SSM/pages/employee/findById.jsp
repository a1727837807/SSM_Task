<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <td><c:out value= "${NewEmployee.id}"/> </td>
            <td><c:out value= "${NewEmployee.name}"/></td>
            <td><c:out value= "${NewEmployee.sex}"/></td>
            <td><c:out value= "${NewEmployee.address}"/></td>
            <td><c:out value="${NewEmployee.phone}" /></td>
        </tr>
    </table>
</body>
</html>
