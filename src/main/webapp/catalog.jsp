<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.concurrent.ThreadLocalRandom" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
</head>
<body>
  <p>Catalog in url params!</p>
  <p>Random list of goods:</p>
  <% List<String> catalogList = List.of("Good1","Good2","Good3","Good4","Good5","Good6","Good7");
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
