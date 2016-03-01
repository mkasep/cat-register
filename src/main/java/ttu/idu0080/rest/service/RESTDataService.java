package ttu.idu0080.rest.service;

import ttu.idu0080.rest.data.*;

import java.util.*;
import java.text.*;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;;
@Service
public class RESTDataService  {



	
	
	public List<Cat> getAllCats()  {
		
		Cat[] cat_array = null;
		try
		{
			RestTemplate restTemplate = new RestTemplate();
		cat_array = restTemplate.getForObject("http://localhost:8080/REST_service/service/cats", Cat[].class) ;
		System.out.println("Kasse REST-teenusest:" + cat_array.length);
		}
		catch(Exception ex)
		{
			System.out.println("RESTDataService.getAllCats():"+ ex.getMessage());
		}

		List<Cat> cat_list= Arrays.asList(cat_array);
		return cat_list;
	}

	
	
	
}
