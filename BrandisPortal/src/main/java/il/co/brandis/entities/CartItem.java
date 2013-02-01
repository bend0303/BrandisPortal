package il.co.brandis.entities;

public class CartItem {

	private Product product;
	private int amount;
	private double price;
	public CartItem(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
		this.price = amount * product.getProductPrice();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
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
