package il.co.brandis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import il.co.brandis.entities.DBProduct;

@Repository
public class ProductDAO implements IProductDAO {
	protected static Logger logger = Logger.getLogger("productdao");
	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(DBProduct ob) {
		sessionFactory.getCurrentSession().save(ob);
	}

	public void delProduct(int pId) {
		sessionFactory.getCurrentSession().delete(new DBProduct(pId));
	}

	public DBProduct getProductById(int pId) {
		return (DBProduct) sessionFactory.getCurrentSession().get(DBProduct.class,
				pId);
	}

	public List<DBProduct> getProducts() {
		@SuppressWarnings("unchecked")
		List<DBProduct> products = (List<DBProduct>) sessionFactory
				.getCurrentSession().createQuery("from DBProduct").list();
		return products;
	}

}