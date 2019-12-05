package org.st.service;

import java.util.List;

import org.st.model.Product;

public interface ProductService {

	
	public Integer save(Product product);
	public List<Product> getAllProduct();
	public Product getProductById(Integer id);
}
