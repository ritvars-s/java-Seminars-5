package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.service.IProductFilterService;

@Controller
@RequestMapping("/product/filter")
public class ProductfilterController {
	
	@Autowired
	private IProductFilterService prodFilterService;
	
	
	@GetMapping("/price/{threshold}")//localhost:8080/product/filter/price/1
	public String getFilterProductByPrice(@PathVariable(name = "threshold") float threshold, Model model) {
		try {
			ArrayList<Product> productsFromDB = prodFilterService.filterByPriceLessThan(threshold);
			model.addAttribute("package", productsFromDB);
			model.addAttribute("myHeader", "Produkti, kuru cena ir zem " + threshold + " eur");
			return "show-all-products-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/type/{type}")//localhost:8080/product/filter/type/fruit
	public String getFilterProductByType(@PathVariable(name = "type") ProductType type, Model model) {
		try {
			ArrayList<Product> productsFromDB = prodFilterService.filterByType(type);
			model.addAttribute("package", productsFromDB);
			model.addAttribute("myHeader", "Produkti, kuru tips ir " + type);
			return "show-all-products-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/keyword/{keyword}")//localhost:8080/product/filter/keyword/abols
	public String getFilterProductByKeyword(@PathVariable(name = "keyword") String keyword, Model model) {
		try {
			ArrayList<Product> productsFromDB = prodFilterService.filterByKeyword(keyword);
			model.addAttribute("package", productsFromDB);
			model.addAttribute("myHeader", "Produkti, kuru atslegas vards ir " + keyword);
			return "show-all-products-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
		
	}
	@GetMapping("/average/price")//localhost:8080/product/filter/average/price
	public String getAverageProductPrice(Model model){
		try {
			double average = prodFilterService.calculateAveragePrice();
			model.addAttribute("package", average);
			model.addAttribute("myHeader", "Produktu, videja cena ir " + average);
			return "show-product-average-price";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
}
