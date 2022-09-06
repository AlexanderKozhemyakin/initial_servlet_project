package org.ru.shopservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/errorHandler")
public class ErrorHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
        response.setContentType("text/html; charset=utf-8");
        
        try (PrintWriter writer = response.getWriter()) {
            writer.write("<html><head><title>Test Page Error description</title></head><body>");
            writer.write("<h2>Error description</h2>");
            writer.write("<ul>");
            Arrays.asList(
              jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE, 
              jakarta.servlet.RequestDispatcher.ERROR_EXCEPTION_TYPE, 
              jakarta.servlet.RequestDispatcher.ERROR_MESSAGE)
              .forEach(e ->
                writer.write("<li>" + e + ":" + request.getAttribute(e) + " </li>")
            );
            writer.write("</ul>");

            writer.write("<h2>Cookies:</h2>");
            Cookie[] cookies = request.getCookies();
            if (cookies!=null){
                writer.write("<ul>");
                int i = 0;
                for (Cookie cookie : cookies ) {
                    writer.write("<li>Cookie " + i + ":" + cookies[i].getName() + ":" + cookies[i].getValue() + " </li>");
                    i++;
                }                
                writer.write("</ul>");
            } else {
                writer.write("No cookies found");
            }
            writer.write("</html></body>");
        }
    }  
}
