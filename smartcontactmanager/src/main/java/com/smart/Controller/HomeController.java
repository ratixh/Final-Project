package com.smart.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.Entities.User;
import com.smart.helper.Message;
import com.smart.repository.UserRepository;

@Controller
public class HomeController
{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("title","Home-Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title","About-Contact Manager");
		return "about";
	}
	
	@RequestMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("title","Register-Contact Manager");
		model.addAttribute("user",new User());
		return "register";
	}
	
	
	//handler for register user
	@RequestMapping(value ="/do_register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user")User user,
			BindingResult result1, 
			@RequestParam(value = "agreement",
			defaultValue = "false")boolean agreement,
			Model model,
			HttpSession session)
	{
		try {
			
			if(!agreement)
			{
			System.out.println("You have not agreed terms and conditions");
			throw new Exception("You have not agreed terms and conditions");
			}
			
			
			if(result1.hasErrors())
			{
				System.out.println("ERROR"+ result1.toString());
				model.addAttribute("user", user);
				return "register";
			}
			
			user.setUserRole("ROLE_USER");
			user.setEnabled(true);
			user.setUserImage("default.png");
			user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
			
			System.out.println("Agreement" + agreement);
			System.out.println("USER" + user);
			
			User result = this.userRepository.save(user);
			
			model.addAttribute("user", new User());
			
			session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
			
			return "register";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went wrong !!"+ e.getMessage(), "alert-danger"));
			return "register";
		}
		
		
	}
	
	//handler for login
	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("title", "Login - Smart Contact");
		return"login";
	}
	
	
}
