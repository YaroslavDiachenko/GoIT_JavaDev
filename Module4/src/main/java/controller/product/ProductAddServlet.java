package controller.product;

import controller.Manufacturing;
import model.Manufacturer;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/products-add")
public class ProductAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("action","add");
        request.getSession().setAttribute("manufacturers", Manufacturing.getManufacturerDAO().getAll());
        request.getRequestDispatcher("JSP/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean passValidation = true;
        List<String> errorMessagesList = new ArrayList<String>();

        Product product = new Product();

        String paramName = request.getParameter("name");
        String paramPrice = request.getParameter("price");
        String paramManufacturerId = request.getParameter("selected");

        if (paramName.equals("")) {
            errorMessagesList.add("Please input name");
            passValidation = false;
        }else product.setName(paramName);

        if (paramPrice.equals("")) {
            errorMessagesList.add("Please input price");
            passValidation = false;
        } else {
            try {
                product.setPrice(new BigDecimal(paramPrice));
            } catch (NumberFormatException e) {
                errorMessagesList.add("Please use numeric value for price");
                passValidation = false;
            }
        }
        if (paramManufacturerId.equals("noSelected")) {
            errorMessagesList.add("Please choose manufacturer");
            passValidation = false;
        }else {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setId(UUID.fromString(paramManufacturerId));
            product.setManufacturer(manufacturer);
        }

        if (passValidation) {
            Manufacturing.getProductDAO().add(product);
            response.sendRedirect("/products");
        } else {
            request.setAttribute("action","add");
            request.setAttribute("product", product);
            request.setAttribute("errorMessagesList", errorMessagesList);
            request.getRequestDispatcher("JSP/products.jsp").forward(request, response);
        }
    }
}
