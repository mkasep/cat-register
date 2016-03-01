package ttu.idu0080.rest.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.ui.Model;

import ttu.idu0080.rest.service.*;
import ttu.idu0080.rest.data.*;

@Controller
public class HomeController {
	
	@Autowired
	private DataService dataService;

	@RequestMapping(value="/test")
	public ModelAndView goTestPage(Model model) throws IOException{
		List<Cat> cats = dataService.getAllCats();
		 model.addAttribute("cats",  cats);
		return new ModelAndView("test");
	}
	
	@RequestMapping(value="/")
	public ModelAndView goHomePage(Model model) throws IOException{

		return new ModelAndView("home");
	}
	
}
