package com.Smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Smart.entity.User;
import com.Smart.service.PersonService;

@Controller
public class HomeController {
	@Autowired
	PersonService personService;

	@GetMapping("/home")
	public String home(Model model)

	{
		model.addAttribute("title", "Home-Smart Contact Manager");
		return "home";
	}

	@GetMapping("/signup")
	public String signup(Model model)

	{
		model.addAttribute("title", "Register-Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About-Smart Contact Manager");
		return "about";
	}

	@PostMapping("/do_register")
	private String do_register(@ModelAttribute User user, Model model) {
//	
		// model.addAttribute("user",user);

		personService.saveUserDetail(user);
		model.addAttribute("user", user);
		return "login";

	}

	@GetMapping("/userlogin")
	public String userlogin(Model model)

	{
		model.addAttribute("login", new User());
		return "userlogin";
	}

	@PostMapping("/userloginCheck")
  public String userloginCheck(@ModelAttribute User user,Model model)
  {
	String view="";
	  try
	  {
	    User user1= personService.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
	    
	    System.out.println(user1);
	  //  model.addAttribute("login", user1);
	    if(user1==null)
	    {
	    	  view= "userlogin";
	    }
	    else
	    {
	    	view= "dashboard";
	    	
	    }
	  }
	 
	  catch(Exception e) {
		  
		  System.out.println( e);
	  }
	  finally
	  {
		    return view;
	  }
  }
}
