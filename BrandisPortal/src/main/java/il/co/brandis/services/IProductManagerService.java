package il.co.brandis.services;

import java.util.List;

import il.co.brandis.entities.Product;

public interface IProductManagerService {
	public void addProduct(Product product);
	public List<Product> getProducts();
	public Product getProductById(int id);

}
