package com.swarga.project.productapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.swarga.project.productapp.model.Product;
import com.swarga.project.productapp.service.ProductService;

@Controller
public class HomePageController {

	@Autowired
	private ProductService productService;
	@RequestMapping("/")
	public String showHomePage(Model model)
	{
		List<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		return "index";

	}

	@RequestMapping("/add-product-form")
	public String showAddProductForm(Model model)
	{
		model.addAttribute("title", "Add Product Form");
		return "add-product-form";
	}

	@RequestMapping(path = "/add-product", method = RequestMethod.POST)
	public RedirectView handleAddProduct(@ModelAttribute Product product, HttpServletRequest request)
	{

		this.productService.addProduct(product);
		RedirectView redirectView= new RedirectView();
		String url=request.getContextPath()+"/";
		redirectView.setUrl(url);
		return redirectView;

	}
	@RequestMapping(path = "/delete-product/{productId}")
	public RedirectView handleDeleteProduct(@PathVariable(name = "productId") String productId, HttpServletRequest request)
	{
		this.productService.deleteProduct(productId);
		RedirectView redirectView= new RedirectView();
		String url=request.getContextPath()+"/";
		redirectView.setUrl(url);
		return redirectView;
	}
}
