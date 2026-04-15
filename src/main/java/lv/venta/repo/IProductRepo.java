package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductRepo extends CrudRepository<Product, Long> {

	boolean existsByProductNameAndPriceAndDescriptionAndProductType(String newProductName, double newPrice,
			String newDescription, ProductType newProductType);
	//TODO papildinat pec nepieciesamibas citas funkcijas

	Product findByProductNameAndPriceAndDescriptionAndProductType(String newProductName, double newPrice,
			String newDescription, ProductType newProductType);
	
}
