package com.example.restassignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.restassignment.model.entity.Com;
import com.example.restassignment.model.view.ApiView;
import com.example.restassignment.model.view.ListView;
import com.example.restassignment.service.OneService;

@ControllerAdvice
@RestController
public class OneController {
	@Autowired
	OneService oneService;

	public ApiView restApi(Object o, int status) {
		ApiView v = new ApiView();
		switch (status) {
		case 200:
			v.setCode("200");
			v.setStatus("Ok");
			v.setData(o);
			break;
		case 2000:
			v.setCode("2000");
			v.setStatus("Fail");
			v.setData("Failed");
			break;
		default:
			v.setCode("9999");
			v.setStatus("Fail");
			v.setData("Failed");
			break;

		}
		return v;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiView> notValid() {
		System.out.println("notValid");
		return ResponseEntity.badRequest().body(restApi("Faild", 2000));

	}

	@GetMapping(value = "/{companyId}/list", produces = "application/json; charset=UTF-8")
	public ResponseEntity<ApiView> showList(@PathVariable("companyId") int companyId) {
		ListView result = oneService.getList(companyId);
		if (result != null) {
			return ResponseEntity.ok(restApi(result, 200));
		} else {
			return ResponseEntity.badRequest().body(restApi(result, 2000));
		}
	}

	@DeleteMapping(value = "/{companyId}/del", produces = "application/json; charset=UTF-8")
	public ResponseEntity<ApiView> delcom(@PathVariable("companyId") int companyId) {
		int result = oneService.del(companyId);
		if (result == 1) {
			return ResponseEntity.ok(restApi("Success", 200));
		} else {
			return ResponseEntity.badRequest().body(restApi("Fail", 2000));
		}
	}

	@PostMapping(value = "/{companyId}/edit", produces = "application/json; charset=UTF-8")
	public ResponseEntity<ApiView> editcom(@PathVariable("companyId") int companyId, Com param) {
		int result = oneService.edit(companyId, param);
		if (result == 1) {
			return ResponseEntity.ok(restApi("Success", 200));
		} else {
			return ResponseEntity.badRequest().body(restApi("Fail", 2000));
		}
	}

	@PostMapping(value = "/add", produces = "application/json; charset=UTF-8")
	public ResponseEntity<ApiView> addcom(@Valid Com param) {
		int result = oneService.add(param);
		if (result == 1) {
			return ResponseEntity.ok(restApi("Success", 200));
		} else {
			return ResponseEntity.badRequest().body(restApi("Fail", 2000));
		}

	}
}
