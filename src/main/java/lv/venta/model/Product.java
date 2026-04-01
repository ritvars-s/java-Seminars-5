package lv.venta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
public class Product {
	private long id;
	private String productName;
	private double price;
	private String description;
	private int quantity;
	private ProductType productType;
	
	private static long counter = 0;
	
	
	
	
	//getters nak no lombok bibliotekas
	//setters nak no lombok bibliotekas
	//bezargumenta kons nak no lombok
	
	public long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}
	public double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public int getQuantity() {
		return quantity;
	}
	public ProductType getProductType() {
		return productType;
	}

	public void setId() {
		id= counter;
		counter++;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Product(String newProductName, double newPrice, String newDescription, int newQuantity, ProductType newProductType) {
		setProductName(newProductName);
		setPrice(newPrice);
		setDescription(newDescription);
		setId();
		setQuantity(newQuantity);
		setProductName(newProductName);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + ", productType=" + productType + "]";
	}
	
	
	
	
	
}
