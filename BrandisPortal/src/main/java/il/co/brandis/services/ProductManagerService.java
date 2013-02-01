package il.co.brandis.services;

import java.util.List;

import il.co.brandis.dao.IProductDAO;
import il.co.brandis.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IProductManagerService")
public class ProductManagerService implements IProductManagerService {

	@Autowired
	private IProductDAO ProductsDAO;

	@Transactional
	public void addProduct(Product product) {
		ProductsDAO.addProduct(product);
	}
	
	@Transactional
	public List<Product> getProducts() {
		return ProductsDAO.getProducts();
	}
	
	@Transactional
	public Product getProductById(int id){
	return ProductsDAO.getProductById(id);
		
	}
}
