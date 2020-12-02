
public class book {
	private int SKU;
	private String title;
	private double price;
	private int quantity;
	
	public book (int sku, String title, double price, int quant) {
		this.SKU = sku;
		this.title = title;
		this.price = price;
		this.quantity = quant;
	}
	
	public int getSKU() {
		return this.SKU;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
}
