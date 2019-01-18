<%-- 
    Document   : index
    Created on : 09.01.2019, 8:27:49
    Author     : mixail167
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAPWeb</title>
    </head>
    <body>
    <center>
        <div>
            <form method="POST" action="${pageContext.request.contextPath}/index">
                <input type="hidden" name="redirectId" value="${param.redirectId}" />
                <table border="0">
                    <tr>
                        <td>Имя пользователя:</td>
                        <td>
                            <input type="text" name="userName" value= "${user.userName}" /> 
                        </td>
                    </tr>
                    <tr>
                        <td>Пароль:</td>
                        <td>
                            <input type="password" name="password" value= "${user.password}" />                        
                        </td>
                    <tr>
                        <td colspan ="2" align="right">
                            <input type="submit" value= "Submit"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan ="2" align="center">
                            <font color="red">${errorMessage}</font>
                        </td>
                    </tr>
            </table>
        </form>
    </div>
</center>
</body>
</html>
