package com.fsantosbr.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsantosbr.workshopmongo.domain.Post;
import com.fsantosbr.workshopmongo.resources.util.URL;
import com.fsantosbr.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {	
	
	@Autowired
	private PostService service;	
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
		
		/* @RequestParam(value="text", defaultValue="") = means that the value "text" will be used as a parameter in the URL for the endpoint.
		 * http://localhost:8080/posts/titlesearch?text=Bom%20dia
		 * defaultValue="" = if the parameter is not mentioned, it returns an empty String.
		  */
		
		/* http://localhost:8080/posts/titlesearch?text=Bom%20dia
		 * posts = Path set in the RequestMapping annotation for this class
		 * titlesearch = Path set to get this seach method
		 * ? = HTTP protocol syntax to inform a parameter
		 * text = The parameter name explained before
		 * Bom%20dia = String encoded to be set in the parameter
		 */		
	}
	
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue="") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
		
		// http://localhost:8080/posts/fullsearch?text=bom&maxDate=2018-03-30
		// http://localhost:8080/posts/fullsearch?text=aproveite&minDate=2018-03-21&maxDate=2018-03-30
	}
}
