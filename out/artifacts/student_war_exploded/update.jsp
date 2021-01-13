<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/1/13
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>更新页面</title>
    </head>
    <body>
        <h2>更新信息</h2>
        <form method="post" action="/servlet">
            编号：<input type="text" name="id" readonly value=${student.id}><br>
            姓名：<input type="text" name="name" value=${student.name}><br>
            分数：<input type="text" name="score" value=${student.score}><br>
            <input type="hidden" name="method" value="update">
            <input type="submit" value="提交">
        </form>
    </body>
</html>
