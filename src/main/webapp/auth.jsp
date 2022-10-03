<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<% String sessionId= request.getParameter("sessionId"); %>
<p>Enter your login and password for authorization</p>
<form method="post" action="/shopservletapp/main?where=authuser&sessionId=<%=sessionId%>">
    <input type="login" name="login" placeholder="login" required>
    <input type="password" name="password" placeholder="password" required>
    <input type="reset" value="reset">
    <input type="submit" value="submit">
</form>
<a href="/shopservletapp/main?where=register&sessionId=<%=sessionId%>" method="post" target="_blank">Register (if not registered yet)</a>
</body>
</html>