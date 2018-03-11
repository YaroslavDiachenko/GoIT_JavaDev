package com.mycompany.app.controller;

import com.mycompany.app.model.Manufacturer;
import com.mycompany.app.model.Product;
import com.mycompany.app.service.ManufacturerService;
import com.mycompany.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
public class ProductController {
    private ProductService productService;
    private ManufacturerService manufacturerService;

    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired(required = true)
    @Qualifier(value = "manufacturerService")
    public void setManufacturerService(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model){
        model.addAttribute("products", this.productService.listProducts());
        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProdManufacturer(new Manufacturer());
        model.addAttribute("product", product);
        model.addAttribute("products", this.productService.listProducts());
        model.addAttribute("manufacturers", this.manufacturerService.listManufacturers());
        model.addAttribute("action", "add");
        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product){
        this.productService.addProduct(product);
        return "redirect:/products";
    }

    @RequestMapping(value = "/products/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("id") UUID id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("products", this.productService.listProducts());
        model.addAttribute("manufacturers", this.manufacturerService.listManufacturers());
        model.addAttribute("action", "edit");
        return "products";
    }

    @RequestMapping(value = "/products/edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product){
        this.productService.updateProduct(product);
        return "redirect:/products";
    }

    @RequestMapping("/products/remove/{id}")
    public String removeProduct(@PathVariable("id") UUID id){
        this.productService.removeProduct(id);
        return "redirect:/products";
    }
}