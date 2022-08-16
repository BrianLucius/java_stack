package net.brianlucius.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brianlucius.products_and_categories.models.Category;
import net.brianlucius.products_and_categories.models.Product;
import net.brianlucius.products_and_categories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired CategoryRepository categoryRepository;
	
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if(!category.isPresent()) {
			return null;
		}
		return category.get();
	}
	
//    public List<Category> categoriesInProduct(Product product) {
//    	return categoryRepository.findAllByProducts(product);
//    }
    
    public List<Category> categoriesNotInProduct(Product product) {
    	return categoryRepository.findByProductsNotContains(product);
    }
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);		
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
