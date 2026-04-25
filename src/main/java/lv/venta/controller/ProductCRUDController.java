package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {
	@Autowired
	private IProductCRUDService prodService;
	@GetMapping("/all")//localhost:8080/product/crud/all
	public String getAllProducts(Model model) {
		try {
			model.addAttribute("package", prodService.retriveAll());
			return "show-all-products-page";//tiks paradit show-all-products.html lapa
		}
		catch(Exception e){
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/one")//localhost:8080/product/crud/one
	public String getOneProductById(@RequestParam(name = "id") long id, Model model ) {
		try {
		Product prodFromDB = prodService.retrieveByID(id);
		model.addAttribute("package", prodFromDB);
		return "show-one-product-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	//otrais variants ar /
	@GetMapping("/all/{id}")//localhost:8080/product/crud/all/2
	public String getOneProductById2(@PathVariable(name = "id") long id, Model model ) {
		try {
		Product prodFromDB = prodService.retrieveByID(id);
		model.addAttribute("package", prodFromDB);
		return "show-one-product-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/add")//localhost:8080/product/crud/add
	public String getAddNewProduct(Model model) {
		model.addAttribute("product", new Product());
		return "add-new-product-page"; //add-new-product-page.html
	}
	@PostMapping("/add")
	public String postAddNewProduct(@Valid Product product, BindingResult result, Model model) {
		//ja ievades datos ir kadas validacijas kludas
		if(result.hasErrors()) {
			return "add-new-product-page";
		}
		try {
		prodService.create(product.getProductName(), product.getPrice(), product.getDescription(), product.getQuantity(), product.getProductType());
		//ja ir redirect tad uz url adresi parmet ne lapu
		return "redirect:/product/crud/all";
		}
		catch(Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/update/{id}")//localhost:8080/product/crud/update/2
	public String getUpdateProductById(@PathVariable(name = "id") long id, Model model) {
		try {
		Product prodFromDB = prodService.retrieveByID(id);
		model.addAttribute("product", prodFromDB);
		return "update-product-page";
	
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@PostMapping("/update/{id}")
	public String postUpdateProductById(@PathVariable(name = "id") long id, Product product, Model model) {
		try {
		prodService.updatebyID(id, product.getProductName(), product.getPrice(), product.getDescription(), product.getQuantity(), product.getProductType());
		return "redirect:/product/crud/all";
		}
		
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteProductById(@PathVariable(name = "id") long id, Model model) {
		try {
			prodService.deleteByID(id);
			model.addAttribute("package", prodService.retriveAll());
			return "show-all-products-page";
		}
		
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	
	
}
