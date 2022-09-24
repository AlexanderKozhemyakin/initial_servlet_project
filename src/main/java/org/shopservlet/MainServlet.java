package org.shopservlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

import static org.shopservlet.SessionUtils.isClientNotAuthenticated;

@Slf4j
@WebServlet("/main")
public class MainServlet extends HttpServlet {

    protected void handleRequests(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        class DispatcherServlet{
            class CartController{
                void show() throws ServletException, IOException {
                    PrintWriter printWriter = response.getWriter();
                    printWriter.println("111");
                    printWriter.close();
                }
            }
            class CatalogController{
                void show() throws IOException {
                    PrintWriter printWriter = response.getWriter();
                    printWriter.println("222");
                    printWriter.close();
                }
            }
            class DefaultController{
                void show() throws ServletException, IOException {
                    PrintWriter printWriter = response.getWriter();
                    printWriter.println("333");
                    printWriter.close();
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cart");
                    requestDispatcher.forward(request, response);
                }
            }
            void process(String url) throws ServletException, IOException {
                if (url.startsWith("/main?cart")){
                    new CartController().show();
                } else if (url.startsWith("/main?catalog")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?onefileload")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?twofilesload")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?login")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?logout")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?profile")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?viewtshirtpictures")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?productsinfo")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?about")){
                    new CatalogController().show();
                }
            }
        }
        String requestedUrl = request.getServletPath() + "?" + request.getQueryString();

        if (requestedUrl.isEmpty()){
            try {
                new DispatcherServlet().process("/main?catalog");
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                new DispatcherServlet().process(requestedUrl);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        handleRequests(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        handleRequests(request,response);
    }
}


