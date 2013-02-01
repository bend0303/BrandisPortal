package il.co.brandis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import il.co.brandis.entities.Product;

@Repository
public class ProductDAO implements IProductDAO {
	protected static Logger logger = Logger.getLogger("productdao");
	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product ob) {
		sessionFactory.getCurrentSession().save(ob);
	}

	public void delProduct(int pId) {
		sessionFactory.getCurrentSession().delete(new Product(pId));
	}

	public Product getProductById(int pId) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class,
				pId);
	}

	public List<Product> getProducts() {
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) sessionFactory
				.getCurrentSession().createQuery("from Product").list();
		return products;
	}

}