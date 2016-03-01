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
public class RESTController {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private RESTDataService restDataService;

	@RequestMapping(value="/service/cats",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Cat> getCats(HttpServletResponse response) throws IOException{
		
		List<Cat> cats = dataService.getAllCats();
		return cats;
	}
	
	@RequestMapping(value="/service/cat/{id}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Cat getCat(@PathVariable int id) throws IOException{
		
		Cat cat = dataService.getCatById(id);
		return cat;
	}
	
	@Transactional
	@RequestMapping(value = "/service/cat/{id}", method=RequestMethod.POST)
	public @ResponseBody void updateCat(@RequestBody Cat cat)
	{
		dataService.update(cat);
		
	}
	
	
	
	@RequestMapping(value="/service/external/cats",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Cat> getExternalCats(HttpServletResponse response) throws IOException{
		List<Cat> cats = restDataService.getAllCats();
		return cats;
	}


	@Transactional
	@RequestMapping(value = "/service/cat/{id}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteCat(@PathVariable int id)
	{
		dataService.delete(id);
	}

	@Transactional
	@RequestMapping(value = "/service/cat/", method=RequestMethod.PUT)
	public @ResponseBody void insertCat(@RequestBody Cat cat)
	{
		dataService.save(cat);
	}

	@Transactional
	@RequestMapping(value="/service/search",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Cat> searchCats(@RequestParam String name) throws IOException{
		List<Cat> cats = dataService.searchByName(name);
		return cats;
	}
}
