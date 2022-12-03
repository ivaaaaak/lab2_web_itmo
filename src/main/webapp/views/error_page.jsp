<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>lab2web</title>
</head>
<body>
    <h1>Error</h1>
    <img src="../images/hack.jpg" width="100" height="100">
    <h4>Кажется, вы отправили некорректные данные</h4>
    <p style="color: red"><%=exception.getMessage()%></p>
</body>
</html>