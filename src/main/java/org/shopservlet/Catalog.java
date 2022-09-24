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

@WebServlet("/catalog")
public class Catalog extends HttpServlet {

    private List<String> catalog = List.of("T-shirt white","T-shirt black","T-shirt yellow","T-shirt green","T-shirt grey","T-shirt blue");

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final PrintWriter printWriter = response.getWriter();
        printWriter.println(catalog.subList(0,ThreadLocalRandom.current().nextInt(0,catalog.size())));
    }
}
