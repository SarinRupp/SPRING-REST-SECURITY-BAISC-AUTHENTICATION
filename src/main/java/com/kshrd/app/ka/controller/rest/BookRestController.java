package com.kshrd.app.ka.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kshrd.app.ka.entities.Book;
import com.kshrd.app.ka.services.BookService;

@RestController
@RequestMapping("api/book")
public class BookRestController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> list() {
		List<Book> list = bookService.list();
		Map<String, Object> map = new HashMap<String, Object>();
		if (list.isEmpty()) {
			map.put("MESSAGE", "NO DATA");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
		}
		map.put("RESP_DATA", list);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> add(@RequestBody Book b) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.addBook(b) == false) {
			System.out.println("Error..... cannot added book!");
			map.put("MESSAGE", "ERROR!");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
		System.out.println("Book has been inserted successfully.....!");
		map.put("MESSAGE", "SUCCESS!");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> update(@RequestBody Book b , @PathVariable int id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.updateBook(b) == false) {
			System.out.println("Error..... cannot update book!");
			map.put("MESSAGE", "ERROR!");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
		System.out.println("Book has been updated successfully.....!");
		map.put("MESSAGE", "SUCCESS!");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable int id){
		
		System.out.println(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(bookService.deleteBook(id) == false){
			map.put("MESSAGE", "ERROR!");
			return new ResponseEntity<Map<String, Object>>(map,HttpStatus.NOT_FOUND);
		}
		map.put("MESSAGE", "SUCCESS!");
		return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
	}

	
	
}
