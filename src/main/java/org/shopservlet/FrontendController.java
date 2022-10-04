package org.shopservlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static org.shopservlet.SessionUtils.*;

@Slf4j
@WebServlet("/main")
public class FrontendController extends HttpServlet {

    protected void handleRequests(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException, SQLException {

        class DispatcherServlet{
            class ChartController{
                void show(String url) throws IOException, SQLException {
                    PrintWriter pw = response.getWriter();
                    pw.println(Chart.showCartPage(url));
                }
            }
            class CatalogController{
                void show(String url) throws IOException, SQLException {
                    PrintWriter pw = response.getWriter();
                    pw.println(ProductCatalog.showProductsPage(url));
                }
            }
            class LoginController{
                void show(String url) throws ServletException, IOException {
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/auth.jsp?test=test&sessionId" + SessionUtils.getSessionIdFromUrl(url));
                    requestDispatcher.forward(request,response);
                }
            }
            class RegisterController{
                void show(String url) throws ServletException, IOException {
                    PrintWriter pw = response.getWriter();
                    pw.println(AuthHandler.registerForm(url));
                }
            }
            class AuthController{
                void show(String url) throws ServletException, IOException {
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/authuser?test=test&sessionId" + SessionUtils.getSessionIdFromUrl(url));
                    requestDispatcher.forward(request,response);
                }
            }
            class DefaultController{
                void show(String url) throws ServletException, IOException {
                    PrintWriter pw = response.getWriter();
                    pw.println("Check url:"+url);
                }
            }
            void process(String url) throws ServletException, IOException, SQLException {
                if (url.startsWith("/main?where=chart")){
                    new ChartController().show(url);
                } else if (url.startsWith("/main?where=catalog")){
                    new CatalogController().show(url);
                } else if (url.startsWith("/main?where=login")){
                    new LoginController().show(url);
                } else if (url.startsWith("/main?where=register")){
                    new RegisterController().show(url);
                } else if (url.startsWith("/main?where=authuser")){
                    new AuthController().show(url);
                } else {
                    new DefaultController().show(url);
                }
            }
        }
            try {
                new DispatcherServlet().process(url);
            } catch (ServletException | IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            handleRequests(request,response,handleUrlFromRequest(request));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            handleRequests(request,response,handleUrlFromRequest(request));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


