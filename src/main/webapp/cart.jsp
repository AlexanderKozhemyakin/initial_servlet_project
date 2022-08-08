<%@ page import="java.util.Random" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.function.Consumer" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <p>Cart in url params!</p>
    <p>Random list of cart items:</p>
    <% List<String> catalogList = List.of("1cart","2cart","3cart","4cart","5cart","6cart","8cart");
       Random rand = new Random();
       int numberOfElements = catalogList.size() - rand.nextInt(catalogList.size());
       String result="";

            for (int i = 0; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(catalogList.size());
                result = result + " " + catalogList.get(randomIndex);
            }
    %>
    <%= result %>
</body>
</html>
