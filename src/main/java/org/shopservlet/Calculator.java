package org.shopservlet;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/calc")
public class Calculator extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        final HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect("/shopservletapp/connectionPool");

    }
}
