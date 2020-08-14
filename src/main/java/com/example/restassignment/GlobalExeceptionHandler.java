package com.example.restassignment;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.restassignment.model.view.ApiView;

@ControllerAdvice
public class GlobalExeceptionHandler {
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
	public ResponseEntity<ApiView> notValid(MethodArgumentNotValidException e) {
		System.out.println("notValid");
		return ResponseEntity.badRequest().body(restApi("Faild", 2000));

	}
	/*
	 * @ExceptionHandler(IOException.class) public ResponseEntity<ApiView>
	 * uploadFail(IOException e){ System.out.println("uploadFail"); return
	 * ResponseEntity.badRequest().body(restApi("Faild", 2000)); }
	 */
}
