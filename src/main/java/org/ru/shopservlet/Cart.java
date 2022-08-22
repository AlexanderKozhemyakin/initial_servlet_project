package org.ru.shopservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/shopservletapp/cart")
public class Cart extends HttpServlet {
    private List<String> carts = List.of("T-shirt1","T-shirt2","T-shirt3");
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter printWriter = response.getWriter();
        printWriter.println(carts.get(0));
    }
}
