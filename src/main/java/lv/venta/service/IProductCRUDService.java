package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductCRUDService {
	//CRUD - create, retrieve, update, delete
	
	//C -create 
	public abstract void create(String newProductName, double newPrice, String newDescription, int newQuantity, ProductType newProductType) throws Exception;
	
	// R -retrive all
	public abstract ArrayList<Product> retriveAll() throws Exception;
	
	// R -retrive by id
	public abstract Product retrieveByID(long id) throws Exception;
	
	//U - update
	public abstract void updatebyID(long id, String newProductName, double newPrice, String newDescription, int newQuantity, ProductType newProductType) throws Exception;
	
	//D - delete
	public abstract void deleteByID(long id) throws Exception;
}
