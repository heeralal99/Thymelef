package org.st.serviceimpl;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.st.model.Product;
import org.st.repositry.ProductRepositry;
import org.st.service.ProductService;
@Service
public class ProductserviceImpl implements ProductService {
	@Autowired
	private ProductRepositry repo;
	
	
	@Transactional
	public Integer save(Product product) {

		return repo.save(product).getId();
		
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> p=repo.findAll();
		return p;
	}
	@Transactional
	public Product getProductById(Integer id) {
					Optional<Product> ob=repo.findById(id);
					if(ob.isPresent())
					{
						return ob.get();
					}
		return null;
	}
}
