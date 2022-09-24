package org.shopservlet;

import java.io.IOException;
import java.util.regex.Pattern;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
@WebFilter(
    filterName = "CalculatorValidator",
    urlPatterns = {"/calc"},
    servletNames = "calc",
    asyncSupported = true)
public class RequestsWebFilter implements Filter{

    private Pattern patternNumeric = Pattern.compile("-?\\d+(\\.\\d+)?");
    private boolean isNumeric (String stringNum){
        if (stringNum==null){
            return false;
        }
        return patternNumeric.matcher(stringNum).matches();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        HttpServletRequest req = (HttpServletRequest) request;
        String servletPath = req.getServletPath();
        String realRootPath = request.getServletContext().getRealPath("");
        try{

            response.setContentType( "text/html" );
            response.setCharacterEncoding( "UTF-8" );
    
            if (isNumeric(request.getParameter("InputCalculatorText"))){
                //save str to session and forward on other HTML page with same one input form 
                //after submit from second page request after filter check should again go to Calculator servlet/ Filter again should check that number in request
                //request.getServletContext().getRequestDispatcher("/shopservletapp/calc").forward(request, response);
                chain.doFilter(request, response);
            } else {
                //forward on page with text of error reason
                log.error("Not number in request");
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendError(400);
            }
        }catch(IOException|ServletException e){
            log.error("Filter error", e);
            MDC.remove("JSESSIONID");

            try{
                ((HttpServletResponse) response).sendError(500,"Server internal error");
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
