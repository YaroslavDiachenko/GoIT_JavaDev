package controller.manufacturer;

import controller.Manufacturing;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/manufacturers-delete")
public class ManufacturerDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paramId = request.getParameter("id");
        Manufacturing.getManufacturerDAO().delete(UUID.fromString(paramId));
        response.sendRedirect("/manufacturers");
    }
}