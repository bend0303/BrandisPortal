package il.co.brandis.dao;

import java.util.List;

import il.co.brandis.entities.Product;

public interface IProductDAO {

	public abstract void addProduct(Product ob);

	public abstract void delProduct(int pId);

	public abstract Product getProductById(int pId);

	public abstract List<Product> getProducts();
}