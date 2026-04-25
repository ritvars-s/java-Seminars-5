package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductFilterService;
@Service
public class ProductFilterServiceImpl implements IProductFilterService{
	
	@Autowired
	private IProductRepo prodRepo;
	
	@Override
	public ArrayList<Product> filterByPriceLessThan(double filterPrice) throws Exception {
		
		if(filterPrice <= 0) {
			throw new Exception("Ievaditai cenai jabut pozitivai");
		}
		
		ArrayList<Product> result = prodRepo.findByPriceLessThan(filterPrice);
		if (result.isEmpty()) {
			throw new Exception("Sistēmā nav produktu kuru cena ir mazāka kā " + filterPrice + " eiro");
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> filterByType(ProductType filterType) throws Exception {
		if (filterType == null) {
			throw new Exception("filtrs nevar but tukšs");
		}
		ArrayList<Product> result = prodRepo.findByProductType(filterType);
		if (result.isEmpty()) {
			throw new Exception("Sistēmā nav produktu kuru produkta tips ir " + filterType);
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> filterByKeyword(String keyword) throws Exception {
		if (keyword == null) {
			throw new Exception("filtrs nevar būt tukšs");
		}
		ArrayList<Product> result = prodRepo.findByProductNameContainingOrDescriptionContaining(keyword, keyword);
		if (result.isEmpty()) {
			throw new Exception("Sistēmā nav produktu kurā atslēgas vārds ir " + keyword);
		}
		
		return result;
	}

	@Override
	public double calculateAveragePrice() throws Exception {
		if(prodRepo.count() == 0) {
			throw new Exception("Db nav produktu un nevar aprekiāt cenu");
		}
		double result = prodRepo.calculateAveragePriceFromDB();
		
		return result;
	}
	

	
}
