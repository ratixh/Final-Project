package com.Smart.controller;

import org.springframework.stereotype.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Smart.Repository.UserRepository;
import com.Smart.entity.User;
import com.Smart.helper.Message;
import com.Smart.service.*;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/base")
	public String base() {
		return "base";
		
	}
	
	
	@GetMapping("/home")
	public String home(Model model)
	{
		
		model.addAttribute("title","Home-Smart Contact Manager");
		
		return "home";
		
	}
	
	@GetMapping("/about")
	public String about(Model model)
	{
		
		model.addAttribute("title","About-Smart Contact Manager");
		
		return "about";
		
	}
	
	
	
	
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		
		model.addAttribute("title","Register-Smart Contact Manager");
		model.addAttribute("user",new User());
		
		return "signup";
	}
	
	
	
	
	@RequestMapping(value="/do_register", method = RequestMethod.POST)
	   public String do_register(@Valid @ModelAttribute("user") User user,
			   //BindingResult result1,
			   @RequestParam(value = "agreement",
			   defaultValue = "false")
	           boolean agreement, Model model, HttpSession session )
	
	     {
     try   {
			
	     if(!agreement) 
		 {		   
		    System.out.println("You have not agreed the terms and conditions");
		    throw new Exception("You have not agreed the terms and conditions");	
			}
	 
	 
			
			/*
			 * if(result1.hasErrors())
			 * 
			 * { System.out.println("ERROR"+ result1.toString()); model.addAttribute("user",
			 * user); return "signup"; }
			 */
			  
			user.setUserRole("Role_User");
			user.setUserEnabled(true);
			user.setUserImageUrl("default.png");
			
			
			System.out.println("Agreement" + agreement);
			System.out.println("User"+ user);
			
			User result = this.userRepository.save(user);
			
			model.addAttribute("user",user);
			
			
			session.setAttribute("message", new Message("Successfully Registered!!", "alert"));
		
			return "signup";
}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Error occured"+(e),"alert-danger"));
			
		}

		return "signup";		
	}
	

}
