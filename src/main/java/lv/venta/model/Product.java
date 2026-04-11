package lv.venta.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
@Table(name = "ProductTable")
@Entity
public class Product {
	@Column(name = "Id")
	@Id //ka primara atslega
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "Price")
	private double price;
	@Column(name = "Description")
	private String description;
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "ProductType")
	private ProductType productType;
	
	
	
	
	
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
		setQuantity(newQuantity);
		setProductType(newProductType);
	}
	public Product() {
		setProductName("a");
		setPrice(0);
		setDescription("d");
		setQuantity(0);
		setProductType(ProductType.fruit);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + ", productType=" + productType + "]";
	}
	
	
	
	
	
}
