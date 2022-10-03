package org.shopservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(
    urlPatterns = "/authuser",
    initParams = @WebInitParam(name = "CookieMaxAge", value = "3600", description = "Default value is 1 hour")
    )
public class AuthUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType( "text/html" );
        response.setCharacterEncoding( "UTF-8" );

        final String LOGIN = request.getParameter("login");
        final String PASSWORD = request.getParameter("password");
        final String SESSIONID = request.getParameter("sessionId");

         if  (LoginAndPasswordValidate.isValid(LOGIN,PASSWORD)){
            if (SESSIONID.isBlank()) {
                final Cookie authCodeCookie = new Cookie("authenticated", "yes");
                response.addCookie(authCodeCookie);
            }
            String sql = "UPDATE SESSIONS_CARTS SET USERNAME=? WHERE SESSION_ID=? AND STATUS!='CONFIRMED'";
             try {
                 SqlExecutions.updateChartWithUsername(sql,LOGIN,SESSIONID);
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
             request.getRequestDispatcher("/main?where=chart&sessionId=" + SESSIONID + "&authusername=" + LOGIN).forward(request, response);

        }else if (LOGIN.isEmpty()||PASSWORD.isEmpty()){

            final Cookie errorCodeCookie = new Cookie("code", "400" );
            response.addCookie(errorCodeCookie);
            errorCodeCookie.setPath("/");

            response.sendError(400);
        } else {
            request.getRequestDispatcher("/main?where=login?test=authservlet&sessionId="+ SESSIONID).forward(request, response);
        }
    }
}
