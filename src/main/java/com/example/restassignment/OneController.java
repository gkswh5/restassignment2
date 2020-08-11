package com.example.restassignment;



import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneController {
	@Autowired
	OneService oneService;
	
	@GetMapping(value = "/{companyId}/list", produces = "application/json; charset=UTF-8")
	public ResponseEntity<ApiView> showList(@PathVariable("companyId") int companyId) {
		return ResponseEntity.ok(oneService.getList(companyId));
	}
	
	@DeleteMapping(value ="/{companyId}/del")
	public ResponseEntity<ApiView> delcom(@PathVariable("companyId") int companyId) {
		return ResponseEntity.ok(oneService.del(companyId));
	}
	
	@PostMapping(value ="/{companyId}/edit")
	public ResponseEntity<ApiView> editcom(@PathVariable("companyId") int companyId , Com param) {
		return ResponseEntity.ok(oneService.edit(companyId, param));
	}
	
	@PostMapping(value ="/add")
	public ResponseEntity<ApiView> addcom(@Valid Com param) {
		return ResponseEntity.ok(oneService.add(param));
	}
}
