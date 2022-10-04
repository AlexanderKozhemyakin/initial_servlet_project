package org.shopservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/addtochart")
public class AddToChart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        final String url = request.getRequestURL() + "?" + request.getQueryString();

        ProductsInChart pc = new ProductsInChart();
        pc.setProduct(SessionUtils.getParameterValueFromUrl(url,"addproductnametochart"));
        pc.setQuantity(SessionUtils.getParameterValueFromUrl(url,"addproducttochartquantity"));
        pc.setSession_id(SessionUtils.getSessionIdFromUrl(url));
        pc.setUsername(SessionUtils.getParameterValueFromUrl(url,"addproducttochartusername"));
        pc.setPrice(SessionUtils.getParameterValueFromUrl(url,"addproducttochartprice"));

        try {
            String query = "INSERT INTO SESSIONS_CARTS (session_id,product,quantity,username,price,status) values (?,?,?,?,?,?)";
            SqlExecutions.addProductToCart(query, pc, url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter pw = response.getWriter();
        pw.print("<html><body><input type=\"button\" value=\"Added to chart. Close this tab?\" onclick=\"self.close()\"></body></html>");

    }
}