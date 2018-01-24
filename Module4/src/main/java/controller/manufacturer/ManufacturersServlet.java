package controller.manufacturer;


import controller.Manufacturing;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manufacturers")
public class ManufacturersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("action", null);
        request.getSession().setAttribute("manufacturers", Manufacturing.getManufacturerDAO().getAll());
        request.getRequestDispatcher("JSP/manufacturers.jsp").forward(request, response);
    }
}