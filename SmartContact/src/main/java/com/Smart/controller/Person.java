package com.Smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Person
{
	
 // @RequestMapping(value="/display",method= RequestMethod.GET)
  @GetMapping("/display")
  public String display()
  {
	  return"index";
  }
  
  @GetMapping("/dashboard")
  public String dashboard() 
  {
	  return "dashboard";
  }
  
}
