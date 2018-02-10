package com.test.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.entity.Person;
import com.test.service.PersonService;

@Controller
@RequestMapping(value="/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(String username,String password) {
		System.out.println("进入到SpringMVC");
		if (Objects.equals(username, "admin")
				&&Objects.equals(password, "admin")) {
			return "redirect:main";
		}
		return "redirect:login";
	}
	
	@RequestMapping("/main")
	public String main(Model model) {
		model.addAttribute("persons", this.personService.gets());
		return "main";
	}
	
	@RequestMapping("/addPrompt")
	public String addPrompt() {
		return "addPerson";
	}
	
	@RequestMapping("/updatePrompt")
	public String updatePrompt(Model model,String id) {
		model.addAttribute("person", this.personService.getbyId(id));
		return "updatePerson";
	}
	
	@RequestMapping(value="/addPerson")
	public String add(Person person) {
         personService.add(person);
         return "redirect:main";
	}

	@RequestMapping(value="/updatePerson")
	public String update(Person person) {
		 personService.update(person);
		 return "redirect:main";
	}	

	@RequestMapping(value="/getsPerson")
	@ResponseBody
	public List<Person> gets() {
		return personService.gets();
	}
	
	@RequestMapping(value="/deletePersonbyId")
	public String deletebyId(String id) {
		personService.deletebyId(id);  
		return "redirect:main";
	}

	@RequestMapping(value="/getPersonbyId")
	@ResponseBody
    public Person getbyId(String id) {
		return personService.getbyId(id);
	}
}
