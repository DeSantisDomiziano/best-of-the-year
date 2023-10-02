package org.java.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model) {
		
		final String name = "Dom";
		model.addAttribute("name", name);
		
		return "web-index";
	}
}
