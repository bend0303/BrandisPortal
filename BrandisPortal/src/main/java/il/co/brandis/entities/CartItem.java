package il.co.brandis.entities;

public class CartItem {

	private DBProduct product;
	private int amount;
	private double price;
	public CartItem(DBProduct product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
		this.price = amount * product.getProductPrice();
	}
	public DBProduct getProduct() {
		return product;
	}
	public void setProduct(DBProduct product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
