package lv.venta.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
	
	@GetMapping("/products")//localhost:8080/simple/products
	public String getProductsInPage(Model model) {
		System.out.println("Izpildas produktu kontrolieris");
		ArrayList<Product> allProducts = new ArrayList<Product>();
		Product prod = new Product("Abols", 1, "1kg abols liels", 10, ProductType.fruit);
		Product prod1 = new Product("Bumbieris", 0.99, "1kg bumbieris liels", 30, ProductType.fruit);
		allProducts.add(prod1);
		allProducts.add(prod);
		model.addAttribute("package", allProducts);
		return "show-many-product-page";//tiks paradita show-many-product-page.html lapa
	}
	
	@GetMapping("/add")//localhost:8080/simple/add
	public String getAddNewProduct(Model model) {
		model.addAttribute("product", new Product());
		return "add-new-product-page"; //add-new-product-page.html
	}
	@PostMapping("/add")
	public String postAddNewProduct(Product product) {
		//TODO veic datu parbaudi un saglabasanu
		
		System.out.println(product);
		return "redirect:/simple/page";
	}
	@GetMapping("/update")//localhost:8080/simple/update
	public String getUpdateProduct(Model model) {
		Product prod = new Product("Abols", 1, "1kg abols liels", 10, ProductType.fruit);
		model.addAttribute("product", prod);
		return "update-product-page"; //update-product-page.html
	}
	@PostMapping("/update")
	public String postUpdateProduct(Product product) {
		//TODO veic datu parbaudi un saglabasanu regetajam produktam
		
		System.out.println(product);
		return "redirect:/simple/page";
	}
}
