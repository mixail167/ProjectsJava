<%-- 
    Document   : view
    Created on : 09.01.2019, 9:13:15
    Author     : mixail167
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View - SAPWeb</title>
    </head>
    <body>
        <c:forEach items="${list}" var="item">
          ${item}
          <br>
        </c:forEach>
    </body>
</html>
