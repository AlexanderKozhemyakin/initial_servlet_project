import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String catalog = request.getParameter("catalog");
        String cart = request.getParameter("cart");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body><p>Main page - add \"?catalog=...\" or \"?cart=...\" to url</p></body>");
//        printWriter.println("<p>catalog:"+catalog+"</p>");
//        printWriter.println("<p>cart:"+cart+"</p>");
        printWriter.println("</html>");

        if (catalog!=null){
            response.sendRedirect("/catalog.jsp");
        } else if (cart!=null) {
            response.sendRedirect("/cart.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
