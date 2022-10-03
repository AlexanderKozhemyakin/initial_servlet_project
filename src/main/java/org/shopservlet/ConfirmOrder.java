package org.shopservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/confirmorder")
public class ConfirmOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        final String url = request.getRequestURL() + "?" + request.getQueryString();
        final String sessionId=SessionUtils.getSessionIdFromUrl(url);

        final String htmlReplySuccess = "<html><body><input type=\"button\" value=\"Order confirmed. Close this tab?\" onclick=\"self.close()\"></body></html>";
        final String htmlReplyLoginFirst =
                "<html><body>Please login first or register <a href=\"/shopservletapp/main?where=login&sessionId="+sessionId+
                "\" target=\"_blank\" methods=\"post\">here</a></body></html>";

        String authUserName = SessionUtils.getParameterValueFromUrl(request.getQueryString(), "authusername");
        PrintWriter pw = response.getWriter();
        if (authUserName.isEmpty()) {
            pw.println(htmlReplyLoginFirst);
        } else {
            try {
                String sql = "UPDATE SESSIONS_CARTS SET STATUS='CONFIRMED' WHERE STATUS='NEW' AND USERNAME=? AND PRODUCT!=''";
                SqlExecutions.confirmOrderForClient(sql,authUserName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            pw.println(htmlReplySuccess);
        }
    }
}