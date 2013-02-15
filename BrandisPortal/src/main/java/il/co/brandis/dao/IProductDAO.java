package il.co.brandis.dao;

import java.util.List;

import il.co.brandis.entities.DBProduct;

public interface IProductDAO {

	public abstract void addProduct(DBProduct ob);

	public abstract void delProduct(int pId);

	public abstract DBProduct getProductById(int pId);

	public abstract List<DBProduct> getProducts();
}