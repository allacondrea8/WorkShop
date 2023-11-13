package com.Workshop.Workshop.Spring.Boot.MVC.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

	  @RequestMapping("/")
	    public String index() {
	        return "index"; // This will look for src/main/resources/templates/index.html
	    }

}
