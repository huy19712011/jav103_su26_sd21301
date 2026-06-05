package org.example.jav103_su26_sd21301.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jav103_su26_sd21301.entity.Category;
import org.example.jav103_su26_sd21301.entity.Product;
import org.example.jav103_su26_sd21301.service.CategoryService;
import org.example.jav103_su26_sd21301.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {
        "/products",
        "/products/new",
        "/products/insert",
        "/products/delete",
        "/products/edit",
        "/products/update"
})
public class ProductServlet extends HttpServlet {

    private ProductService service = new ProductService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        switch (path) {
            case "/products":
                listProducts(request, response);
                break;
            case "/products/new":
                showNewForm(request, response);
                break;
            case "/products/edit":
                editProduct(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        switch (path) {
            case "/products/insert":
                insertProduct(request, response);
                break;
            case "/products/update":
                updateProduct(request, response);
                break;
            case "/products/delete":
                deleteProduct(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = categoryService.getCategories();

        request.setAttribute("categories", categories);

        getServletContext()
                .getRequestDispatcher("/views/addProductForm.jsp")
                .forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read product info from form
        Product product = getProductFromForm(request);

        // update product
        service.updateProduct(product);

        // redirect to list products
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private Product getProductFromForm(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        long categoryId = Long.parseLong(request.getParameter("category_id"));
        Category category = categoryService.getCategoryById(categoryId);
        if (category == null) {
            throw new IllegalArgumentException("Invalid category id: " + categoryId);
        }
        Product product = new Product();
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            product.setId(Long.parseLong(idParam));
        }
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        return product;
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // load product info to the form
        // get product id from form
        Long id = Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        // get product by id
        Product product = service.getProductById(id);
        // send product to form
        request.setAttribute("product", product);
        // categories for dropdown list; categoryId for selected item
        List<Category> categories = categoryService.getCategories();
        request.setAttribute("categories", categories);
        request.setAttribute("categoryId", product.getCategory().getId());
        // redirect to form
        request
                .getRequestDispatcher("/views/updateProductForm.jsp")
                .forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        long id = Long.parseLong(request.getParameter("id"));

        service.deleteProduct(id);

        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // read product info from form
        Product product = getProductFromForm(request);

        // save product to list
        service.addProduct(product);

        // redirect to list products
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = service.getProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/productList.jsp").forward(request, response);
    }

}
