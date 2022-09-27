package org.shopservlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Optional;

import static org.shopservlet.SessionUtils.*;

@Slf4j
@WebServlet("/main")
public class MainServlet extends HttpServlet {

    protected void handleRequests(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        HttpSession session = request.getSession(false);

        String query = Optional.ofNullable(request.getQueryString()).orElse("");
        String url = request.getServletPath() + (query.isEmpty() ? "" : "?" + query);

        String sessionId = "";

        if (isClientNotAuthenticated(url)) {
            session = request.getSession();
            sessionId = generateRandomBase64TokenSessionId(256);
            url = addSessionIdToUrl(url, sessionId);
        } else {
            session.getAttribute("sessionId");
        }

        String finalUrl = url;
        String finalSessionId = sessionId;
        class DispatcherServlet{
            class CartController{
                void show() throws ServletException, IOException {
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cart");
                    requestDispatcher.forward(request,response);
//                    PrintWriter pw = response.getWriter();
//                    pw.println("cart: url - "+ finalUrl);
//                    pw.println("cart: sessionId - "+ finalSessionId);
//                    pw.println(Product.TSHIRT1.name());
////                    pw.println("<img src=\"${pageContext.request.contextPath}/images/TSHIRT1.jpeg.\">");
//                    String imageBase64 = "iVBORw0KGgoAAAANSUhEUgAAAAgAAAAIAQMAAAD+wSzIAAAABlBMVEX///+/v7+jQ3Y5AAAADklEQVQI12P4AIX8EAgALgAD/aNpbtEAAAAASUVORK5CYII";
//                    OutputStream out = response.getOutputStream();
//                    writeOutputStream(imageBase64, out);
//
//                    response.setContentType("image/png");
//                    response.setHeader("Pragma", "");
//                    response.setHeader("Cache-Control", "");
//                    response.setHeader("Content-Disposition", "inline; fileName=image.png");
                }
            }
            class CatalogController{
                void show() throws IOException, ServletException {
                    PrintWriter pw = response.getWriter();
                    pw.println(ProductCatalog.showProductsPage());

//                    pw.println("<div align=\"center\">");
//                    pw.println("<table border=\"5px\" style=\"width:600px\">");
//                    pw.println("    <tr>");
//                    pw.println("      <th>Product</th>");
//                    pw.println("      <th>Image</th>");
//                    pw.println("    </tr>");
//                    pw.println("<%");
//                    pw.println("                    if(imgFileName!=\"\" && imgId!=\"\")");
//                            pw.println("                    {");
//                                    pw.println("%>");
//                                            pw.println("<tr>");
//                                                    pw.println("<td><%=imgId %></td>");
//                                                            pw.println("<%--      <td><img src=\"images/tshirt1.jpeg\" style=\"width:300px;height:250px\"></td>--%>");
//                    pw.println("<td><img src=\"images/<%=imgFileName%>\" style=\"width:300px;height:250px\"></td>");
//                            pw.println("</tr>");
//                                    pw.println("<%");
//                                            pw.println("}");
//                                                    pw.println("%>");
//                    pw.println("  </table>");
//                    pw.println("</div>");
//
//                    pw.println("</body>");
//                    pw.println("</html>");
                }
            }
            class OneFileLoadController{
                void show() throws ServletException, IOException {
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/fileuploadservlet");
                    requestDispatcher.forward(request,response);
                    // /fileuploadservlet
//                    PrintWriter pw = response.getWriter();
//                    pw.println("577");
                }
            }
            class DefaultController{
                void show() throws ServletException, IOException {
                    PrintWriter pw = response.getWriter();
                    pw.println("577");
                }
            }
            void process(String url) throws ServletException, IOException {
                if (url.startsWith("/main?cart")){
                    new CartController().show();
                } else if (url.startsWith("/main?catalog")){
                    new CatalogController().show();
                } else if (url.startsWith("/main?onefileload")){
                    new OneFileLoadController().show();
                } else if (url.startsWith("/main?twofilesload")){
                    new OneFileLoadController().show();
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

    private void writeOutputStream(String value, OutputStream outputStream) throws IOException {
        byte[] dd=value.getBytes();
        byte[] imgBytes = Base64.getDecoder().decode(dd);
        BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imgBytes));
        ImageIO.write(bufImg, "jpeg", outputStream);
    }
}


