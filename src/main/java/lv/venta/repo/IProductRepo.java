package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductRepo extends CrudRepository<Product, Long> {

	boolean existsByProductNameAndPriceAndDescriptionAndProductType(String newProductName, double newPrice,
			String newDescription, ProductType newProductType);
	//TODO papildinat pec nepieciesamibas citas funkcijas

	Product findByProductNameAndPriceAndDescriptionAndProductType(String newProductName, double newPrice,
			String newDescription, ProductType newProductType);

	ArrayList<Product> findByPriceLessThan(double filterPrice);

	ArrayList<Product> findByProductType(ProductType filterType);

	ArrayList<Product> findByProductNameContainingOrDescriptionContaining(String keyword, String keyword1);

	@Query(nativeQuery = true, value = "SELECT AVG(price) FROM product_table;")
	float calculateAveragePriceFromDB();

		
}
