package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;
///https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
@Service
public class ProductCRUDServiceImpl implements IProductCRUDService{
	
	@Autowired
	private IProductRepo prodRepo;
	
	@Override
	public void create(String newProductName, double newPrice, String newDescription, int newQuantity, ProductType newProductType) throws Exception {
		if (newProductName == null || !newProductName.matches("[A-Z]{1}[a-z ]{2,30}") || newPrice < 0 || newPrice > 1000 || newQuantity < 0 || newQuantity > 10000 || newDescription == null || newProductType == null) {
			throw new Exception("Kads no argumeniem nav atbilsetos");
		}
		//parbaudam via tads produkts jau eksiste, ja ta, tad papildina krajumus
		if (prodRepo.existsByProductNameAndPriceAndDescriptionAndProductType(newProductName, newPrice, newDescription, newProductType)) {
			Product productFromDB = prodRepo.findByProductNameAndPriceAndDescriptionAndProductType(newProductName, newPrice, newDescription, newProductType);
			int quantity = productFromDB.getQuantity() + newQuantity;
			productFromDB.setQuantity(quantity);
			prodRepo.save(productFromDB);
		}
		
		else {
			Product newProduct = new Product(newProductName, newPrice, newDescription, newQuantity, newProductType);
			prodRepo.save(newProduct);
		}
		
	}

	@Override
	public ArrayList<Product> retriveAll() throws Exception {
		if (prodRepo.count() == 0) {
			throw new Exception("produktu tabula DB ir tuksa");
		}
		ArrayList<Product> allProducts = (ArrayList<Product>)prodRepo.findAll();
		
		return allProducts;
	}

	@Override
	public Product retrieveByID(long id) throws Exception {
		if (id <= 0) {
			throw new Exception("Id nevar but negativs vai nulle");
		}
		if (!prodRepo.existsById(id)) {
			throw new Exception("Tads id DB nav");
		}
		Product newProd = prodRepo.findById(id).get();
		return newProd;
	}

	@Override
	public void updatebyID(long id, String newProductName, double newPrice, String newDescription, int newQuantity, ProductType newProductType) throws Exception {
		Product prod = retrieveByID(id);
		if (newProductName == null || !newProductName.matches("[A-Z]{1}[a-z ]{2,30}") || newPrice < 0 || newPrice > 1000 || newQuantity < 0 || newQuantity > 10000 || newDescription == null || newProductType == null) {
			throw new Exception("Kads no argumeniem nav atbilstos");
		}
		prod.setProductName(newProductName);
		prod.setPrice(newPrice);
		prod.setDescription(newDescription);
		prod.setQuantity(newQuantity);
		prod.setProductType(newProductType);
		prodRepo.save(prod);
		
	}

	@Override
	public void deleteByID(long id) throws Exception {
		if (id <= 0) {
			throw new Exception("Id nevar but negativs vai nulle");
		}
		if (!prodRepo.existsById(id)) {
			throw new Exception("Tads id DB nav");
		}
		prodRepo.deleteById(id);
	}
	
	
		
	
}
