package il.co.brandis.entities;

import il.co.brandis.utils.EncryptionUtil;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
	 * The user ID is very nice test
	 */ 
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int uId;

	/**
	 * The email
	 */
	//@Size(min = 1, max = 20, message="E-mail length must be between 1-20")
	//@Email(message="Not a valid mail address")
	@Column(name = "email")
	private String email;

	/**
	 * The password as an MD5 value
	 */
	@Column(name = "password")
	private String password;

	@NotEmpty(message="You must choose gender")
	@Column(name = "gender")
	private String gender;
	
	@NotEmpty(message="You must enter your full name")
	@Column(name = "fullname")
	private String fullName;
	
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


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public User() {
		cart = new Cart();

	}

	public int getuId() {
		return uId;
	}

	public User(String email, String password, String gender, String fullName,
			Cart cart) {
		super();
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.fullName = fullName;
		this.cart = cart;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = EncryptionUtil.encrypt(password);
	}

}
