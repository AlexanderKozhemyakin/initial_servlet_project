package org.ru.shopservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name="FileUploadServlet", urlPatterns = {"/shopservletapp/fileuploadservlet"})
@MultipartConfig(
        fileSizeThreshold = 1024*1024*1, //1MB
        maxFileSize = 1024*1024*30, //30MB
        maxRequestSize = 1024*1024*100, //100MB
        location = "/tmp"
)
public class FileUploadServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        final Collection<Part> parts = request.getParts();
        final PrintWriter printWriter = response.getWriter();

        if(parts.isEmpty()){
            printWriter.print("no parts provided");
        }else{
            for(Part part: parts){
                final String submittedFileName = part.getSubmittedFileName();
                final String partName = part.getName();

                if(submittedFileName.isBlank()){
                    printWriter.printf("File nmae is empty for %s", partName);
                }else{
                    printWriter.printf("getSubmittedFileName: %s, ", submittedFileName);
                    printWriter.printf("getName: %s, ", partName);

                    part.write(submittedFileName);

                    printWriter.printf("The file %s uploaded sucessfully.", submittedFileName);
                }
            }
        }
    printWriter.close();

    }
}
