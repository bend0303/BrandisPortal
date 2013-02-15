package il.co.brandis.services;

import java.util.List;

import il.co.brandis.entities.DBProduct;

public interface IProductManagerService {
	public void addProduct(DBProduct product);
	public List<DBProduct> getProducts();
	public DBProduct getProductById(int id);

}
