package org.shopservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet("/cart")
public class Cart extends HttpServlet {

    List<String> carts = List.of("T-shirt1","T-shirt2","T-shirt3","T-shirt4","T-shirt5");

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final PrintWriter printWriter = response.getWriter();
        printWriter.println("<div align=\"center\">\n" +
                "     <table border=\"5px\" style=\"width:600px\">\n" +
                "          <tr>\n" +
                "              <th>Image Id </th>\n" +
                "              <th>Image</th>\n" +
                "          </tr></table>\n" +
                "</div>");
    }
//        printWriter.println(carts.subList(0,ThreadLocalRandom.current().nextInt(0,carts.size())));
//        try {
//            SqlExecutions.createDB();
//            printWriter.println("db recreated");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        printWriter.println("cart ok");
//        printWriter.close();
//    }
}
