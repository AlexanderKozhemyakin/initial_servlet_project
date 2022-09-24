<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<html>
   <head>
      <title>A sample custom tag</title>
   </head>
    <%@ taglib uri="hellotag" prefix="custom"%>
   <body>
      <custom:hellotag/>
        <center>TAGTEST</center>
      </custom:hellotag>
   </body>
</html>