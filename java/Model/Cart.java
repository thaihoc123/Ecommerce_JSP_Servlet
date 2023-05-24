package Model;

public class Cart {
	private Product product;
	private int quanlity;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Product product, int quanlity) {
		super();
		this.product = product;
		this.quanlity = quanlity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

	@Override
	public String toString() {
		return "Cart [product=" + product + ", quanlity=" + quanlity + "]";
	}
	
	
}
