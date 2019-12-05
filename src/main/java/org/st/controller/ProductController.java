package org.st.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.st.model.Product;
import org.st.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired      
	private ProductService service;

	@GetMapping("/show")
	public String showRegister(Model model)
	{
		model.addAttribute("product", new Product());

		return "Register";
	}  
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product,Model model)
	{
		Integer id =service.save(product);
		model.addAttribute("msg","save with "+id);
		model.addAttribute("product", new Product());
		return "Register";
	}
	@GetMapping("/all")
	public String getAll(Model model)
	{
		List<Product> pp=service.getAllProduct();
		model.addAttribute("allproduct",pp);
		return "All";
	}
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Integer id, Model model,Product product)
	{
			Product p=service.getProductById(id);
			 id =service.save(product);
			 model.addAttribute("editProduct",p);
			model.addAttribute("product", new Product());
			
		return "Edit";
	}

}