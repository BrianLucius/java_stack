package net.brianlucius.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.products_and_categories.models.Category;
import net.brianlucius.products_and_categories.models.Product;
import net.brianlucius.products_and_categories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired ProductRepository productRepository;
	
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(!product.isPresent()) {
			return null;
		}
		return product.get();
	}
	
//	public List<Product> productsInCategory(Category category) {
//		return productRepository.findAllByCategories(category);
//	}
	
	public List<Product> productsNotInCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
