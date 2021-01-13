<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加页面</title>
    </head>
    <body>
        <h2>添加信息</h2>
        <form method="post" action="/servlet">
            编号：<input type="text" name="id"><br>
            姓名：<input type="text" name="name"><br>
            分数：<input type="text" name="score"><br>
            <input type="hidden" name="method" value="add">
            <input type="submit" value="提交">
        </form>
    </body>
</html>
