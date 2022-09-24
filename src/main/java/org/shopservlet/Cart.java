package org.shopservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet("/cart")
public class Cart extends HttpServlet {

    List<String> carts = List.of("T-shirt1","T-shirt2","T-shirt3","T-shirt4","T-shirt5");

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        final PrintWriter printWriter = response.getWriter();
        printWriter.println(carts.subList(0,ThreadLocalRandom.current().nextInt(0,carts.size())));
    }
}
