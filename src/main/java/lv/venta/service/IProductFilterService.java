package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductFilterService {
	//1 fuckcija kas izfiltere produktus pec cenas slieksna
	public abstract ArrayList<Product> filterByPriceLessThan(double filterPrice) throws Exception;
	//public abstract ArrayList<Product> filterByPriceMoreThan(double filterPrice) throws Exception;
	//2 funkcij kas izfiltre produktus pec filtra
	public abstract ArrayList<Product> filterByType(ProductType filterType) throws Exception;
	//3 funkcija kas izfiltre pec padoto keywprd uh skatas title un descriptin
	public abstract ArrayList<Product> filterByKeyword(String keyword)throws Exception;
	//4funkcija kas aprekina videjo cenu visiem produktem
	public abstract double calculateAveragePrice()throws Exception;
}	
