package controller.product;


import controller.Manufacturing;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("products", Manufacturing.getProductDAO().getAll());
        request.getSession().setAttribute("manufacturers", Manufacturing.getManufacturerDAO().getAll());
        request.getRequestDispatcher("JSP/products.jsp").forward(request, response);
    }
}
