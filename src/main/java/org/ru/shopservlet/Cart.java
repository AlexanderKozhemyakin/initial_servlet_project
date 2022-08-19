package org.ru.shopservlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cart")
public class Cart extends HttpServlet {
    private List<String> carts = List.of("Table","Chair","Door");
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter printWriter = response.getWriter();
        printWriter.println(carts.get(0));
    }
}
