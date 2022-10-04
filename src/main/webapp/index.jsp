<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>T-shirts shop</title>
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<%
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }else{
        sessionID = session.getId();
    }
%>
    <ol class="rounded">
        <ul>
            <li><a href="/shopservletapp/main?where=catalog&sessionId=<%=sessionID%>" target="_blank" methods="post">Каталог продукции</a></li>
            <li><a href="/shopservletapp/main?where=chart&sessionId=<%=sessionID%>" target="_blank" methods="post">Корзина</a></li>
            <li><a href="/shopservletapp/main?where=login&sessionId=<%=sessionID%>" target="_blank" methods="post">Войти</a></li>
            <li><a href="/shopservletapp/main?where=register&sessionId=<%=sessionID%>" target="_blank" methods="post">Зарегистрироваться</a></li>
            <li><a href="/shopservletapp/About.html" target="_blank" methods="post">О нас</a></li>
        </ul>
    </ol>
</body>
</html>



