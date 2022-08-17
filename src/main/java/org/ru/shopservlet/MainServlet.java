package org.ru.shopservlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final Logger logger = LogManager.getLogger(MainServlet.class);
        logger.debug("DEBUG logging - current url:" + request.getRequestURL());

        if (request.getParameter("catalog") != null) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/catalog");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("cart") != null) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cart");
            requestDispatcher.forward(request, response);
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("change url request.(it should include ?catalog= or ?cart=) current url:" + request.getRequestURL());
            printWriter.println("example url: localhost:8080/main?cart=TestCart");
            printWriter.close();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}