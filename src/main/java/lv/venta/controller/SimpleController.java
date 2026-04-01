package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/simple")
public class SimpleController {
	
	@GetMapping("/page")//localhost:8080/simple/page
	public String getShowPage() {
		System.out.println("Mans primais kontrolieris");
		return "show-page";//tiks paradita show-page.html lapa ieks web parluka
	}
	
	@GetMapping("/data")//localhost:8080/simple/data
	public String getDataInPage(Model model) {
		System.out.println("Izpildas datu kontrolieris");
		Random rand = new Random();
		String data = "@Janis " + rand.nextInt(2000, 2026);
		model.addAttribute("package", data);
		return "show-data-page";//tiks paradita show-data-page.html lapa
		
	}
	
	@GetMapping("/product")//localhost:8080/simple/product
	public String getProductInPage(Model model) {
		System.out.println("Izpildas produkta kontrolieris");
		Product prod = new Product("Abols", 1, "1kg abols liels", 10, ProductType.fruit);
		model.addAttribute("package", prod);
		return "show-one-product-page";//tiks paradita show-one-product-page.html lapa
	}
	
}
