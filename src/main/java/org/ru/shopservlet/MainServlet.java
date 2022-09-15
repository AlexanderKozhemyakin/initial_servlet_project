package org.ru.shopservlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info(request.getRequestURI());

        if (request.getParameter("catalog") != null) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/catalog");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("cart") != null) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cart");
            requestDispatcher.forward(request, response);
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("change url request.(it should include ?catalog= or ?cart=) current url:" + request.getRequestURL());
            printWriter.println("example url: localhost:8080/shopappservletapp/main?cart=TestCart");
            printWriter.close();
        }
    }
}