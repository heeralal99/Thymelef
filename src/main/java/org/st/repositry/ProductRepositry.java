package org.st.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.st.model.Product;

public interface ProductRepositry extends JpaRepository<Product, Integer> {

}
