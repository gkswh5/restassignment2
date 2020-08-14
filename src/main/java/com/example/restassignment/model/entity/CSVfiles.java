package com.example.restassignment.model.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CSVfiles {
	//vaild체크필요
	MultipartFile companyfile;
	MultipartFile accountsfile;
}
