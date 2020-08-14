package com.example.restassignment.model.entity;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCSV {
	@CsvBindByName(column = "회사명")
	private String company_name;
	@CsvBindByName(column = "계정체계")
	private String account_system;
	@CsvBindByName(column = "과목명(세목)")
	private String account_subject_name_detail;
	@CsvBindByName(column = "과목명(목)")
	private String account_subject_name;
	@CsvBindByName(column = "분류")
	private String division;
	@CsvBindByName(column = "관계코드")
	private String relation_code;
	@CsvBindByName(column = "관계계정과목명")
	private String relation_account_subject_name_detail;

}
