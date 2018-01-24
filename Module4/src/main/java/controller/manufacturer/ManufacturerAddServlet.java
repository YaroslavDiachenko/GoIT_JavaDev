package controller.manufacturer;

import controller.Manufacturing;
import model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/manufacturers-add")
public class ManufacturerAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("action","add");
        request.getRequestDispatcher("JSP/manufacturers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean passValidation = true;
        List<String> errorMessagesList = new ArrayList<String>();

        Manufacturer manufacturer = new Manufacturer();

        String paramName = request.getParameter("name");

        if (paramName.equals("")) {
            errorMessagesList.add("Please input name");
            passValidation = false;
        }else manufacturer.setName(paramName);

        if (passValidation) {
            Manufacturing.getManufacturerDAO().add(manufacturer);
            response.sendRedirect("/manufacturers");
        } else {
            request.setAttribute("action","add");
            request.setAttribute("manufacturer", manufacturer);
            request.setAttribute("errorMessagesList", errorMessagesList);
            request.getRequestDispatcher("JSP/manufacturers.jsp").forward(request, response);
        }
    }
}