package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return "show-data-page";//tiks paradita show-tdata-page.html lapa
		
	}
	
}
