package il.co.brandis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * User domain test
 */
@Entity
@Table(name = "USERS")
public class User {

	/**
	 * The user ID is nice
	 */ 
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int uId;

	/**
	 * The username
	 */
	@Column(name = "username")
	private String username;

	/**
	 * The password as an MD5 value
	 */
	@Column(name = "password")
	private String password;

	@Column(name = "gender")
	private String gender;

	@Column(name = "disability")
	private String disability;
	
	@Transient
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public User() {
		cart = new Cart();

	}

	public int getuId() {
		return uId;
	}

	public User(int uId, String username, String password) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
