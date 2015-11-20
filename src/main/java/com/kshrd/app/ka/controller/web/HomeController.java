package com.kshrd.app.ka.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	private final String WEBSERVICE_URL = "http://localhost:8081/SPRING-REST-SECURITY-BAISC-AUTHENTICATION";
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private HttpHeaders headers;
	

	@RequestMapping(value={"/home","/" })
	public String homePage(){
		return "home";
	}

	
	@ResponseBody
	@RequestMapping(value = "/list")
	public ResponseEntity<Map<String, Object>> getAllbook() {
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<Map> response = restTemplate.exchange(
				WEBSERVICE_URL + "/api/book/",
				HttpMethod.GET, entity,
				Map.class);
		System.out.println(response);
		return new ResponseEntity<Map<String, Object>>(response.getBody(), HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value="/delete/{id}" ,  method= RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable int id) {
		HttpEntity<Object> request = new HttpEntity<Object>(headers);
		ResponseEntity<Map> response = restTemplate.exchange(WEBSERVICE_URL + "/api/book/delete/{id}", HttpMethod.DELETE, request, Map.class, id);
		return new ResponseEntity<Map<String, Object>>(response.getBody(), HttpStatus.OK);
	}
	
	/*@ResponseBody
	@RequestMapping(value="/update/{id}", method= RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Book book) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		// Add the Jackson and String message converters
	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		HttpEntity<?> request = new HttpEntity<Object>(book, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(WEBSERVICE_URL + "/api/book/update/{id}", HttpMethod.PUT, request, String.class, book.getId());
		return responseEntity.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public String addStudent(@RequestBody Book book) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		// Add the Jackson and String message converters
	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	    
		HttpEntity<?> request = new HttpEntity<Object>(book, headers);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(WEBSERVICE_URL + "/api/book/add", request, String.class);
		return responseEntity.toString();
	}*/
	
}
