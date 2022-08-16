package net.brianlucius.products_and_categories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.brianlucius.products_and_categories.models.Category;
import net.brianlucius.products_and_categories.models.Product;
import net.brianlucius.products_and_categories.services.CategoryService;
import net.brianlucius.products_and_categories.services.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String dashboard(Model model) {
		List<Product> productList = productService.allProducts();
		List<Category> categoryList = categoryService.allCategories();
		model.addAttribute("productList", productList);
		model.addAttribute("categoryList", categoryList);
		return "dashboard.jsp";
	}
	
	// ----- New Product -----
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String processNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
    		return "newProduct.jsp";
    	}
		productService.createProduct(product);
		return "redirect:/";
	}
	
	// ----- Show Product -----
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("category") Category category) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		List<Category> categoryList = categoryService.categoriesNotInProduct(product);
		model.addAttribute("categoryList", categoryList);
		return "showProduct.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(@PathVariable("id") Long id, @ModelAttribute("category") Category category, BindingResult result, Model model) {
		Product product = productService.getProductById(id);
		product.getCategories().add(category);
		productService.updateProduct(product);
		
		List<Category> categoryList = categoryService.categoriesNotInProduct(product);
		model.addAttribute("categoryList", categoryList);
		return "redirect:/products/"+id;
	}
	
	// ----- New Category -----
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String processNewCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
    		return "newCategory.jsp";
    	}
		categoryService.createCategory(category);
		return "redirect:/";
	}
	
	// ----- Show Category -----
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model, @ModelAttribute("product") Product product) {
		Category category = categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		
		List<Product> productList = productService.productsNotInCategory(category);
		model.addAttribute("productList", productList);
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String addProductToCategory(@PathVariable("id") Long id, @ModelAttribute("product") Product product, BindingResult result, Model model) {
		Category category = categoryService.getCategoryById(id);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		
		List<Product> productList = productService.productsNotInCategory(category);
		model.addAttribute("productList", productList);
		return "redirect:/categories/"+id;
	}
}
