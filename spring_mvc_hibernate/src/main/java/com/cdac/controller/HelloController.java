package com.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory cls level annotation to declare -
//a spring bean as req handling controller(handler)
//singlton neager
public class HelloController {

	public HelloController() {
		System.out.println("in ctor of"+ getClass());
	}
   @RequestMapping("/")//mandatory method level annotation todeclare 
   //req handlling method:eqivalent to service(rq,rs)
   public String renderWelcomePage() {
	   System.out.println("in render welcome page....");
	   return "index";//handler -> return-> LVN(logical view name)
   }

}
