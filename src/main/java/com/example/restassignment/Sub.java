package com.example.restassignment;

import lombok.Getter;
import lombok.Setter;


public class Sub {
	  int id;
	  String account_system;
	  String account_code;
	  String account_subject_name_detail;
	  String account_subject_name;
	  String division;
	  String created_at;
	  String modified_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount_system() {
		return account_system;
	}
	public void setAccount_system(String account_system) {
		this.account_system = account_system;
	}
	public String getAccount_code() {
		return account_code;
	}
	public void setAccount_code(String account_code) {
		this.account_code = account_code;
	}
	public String getAccount_subject_name_detail() {
		return account_subject_name_detail;
	}
	public void setAccount_subject_name_detail(String account_subject_name_detail) {
		this.account_subject_name_detail = account_subject_name_detail;
	}
	public String getAccount_subject_name() {
		return account_subject_name;
	}
	public void setAccount_subject_name(String account_subject_name) {
		this.account_subject_name = account_subject_name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getModified_at() {
		return modified_at;
	}
	public void setModified_at(String modified_at) {
		this.modified_at = modified_at;
	}
	  
}
