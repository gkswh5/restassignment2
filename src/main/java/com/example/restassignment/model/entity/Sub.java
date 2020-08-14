package com.example.restassignment.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sub {
	private int id;
	private String account_system;
	private String account_code;
	private String account_subject_name_detail;
	private String account_subject_name;
	private String division;
	private String relation_code;
	private String relation_account_subject_name_detail;
	private int company_id;
	private String created_at;
	private String modified_at;
	private String deleted_at;
}
