package il.co.brandis.dao;

import org.apache.log4j.Logger;
import il.co.brandis.entities.User;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO implements IUserDAO {

	protected static Logger logger = Logger.getLogger("Userdao");
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(readOnly = true)
	public List<User> validateLogin(String username, String password) {
		@SuppressWarnings("unchecked")
		List<User> users = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from User where username=:user and password=:password")
				.setString("user", username).setString("password", password)
				.list();
		return users;
		//
	}

	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		logger.debug("User has been added");
	}

	public void delUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		logger.debug("User has been deleted");

	}
//test5Ben
	public User getUser(int uId) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class,
				uId);
		logger.debug("User found");
		return user;
	}
//test1
	public List<User> getUsers() {

		@SuppressWarnings("unchecked")
		List<User> products = (List<User>) sessionFactory.getCurrentSession()
				.createQuery("from User");
		logger.debug("Users list has been fetched");
		return products;
	}

}
