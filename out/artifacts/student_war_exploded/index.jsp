<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/1/12
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>首页</title>
    </head>
    <body>
        <h2>学生管理系统</h2>
        <table>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>分数</th>
                <th>操作</th>
            </tr>
            <c:forEach var="student" items="${list}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.score}</td>
                    <td>
                        <a href="/servlet?method=update&id=${student.id}">更新</a>
                        <a href="/servlet?method=delete&id=${student.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table><br>
        <form action="add.jsp" method="get">
            <input type="submit" value="添加">
        </form>
    </body>
</html>
