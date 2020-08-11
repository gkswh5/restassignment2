package com.example.restassignment;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OneService {
	
	@Autowired
	public ObjectMapper om;
	
	@Autowired
	public OneMapper mapper;
	
	@Transactional
	public Com searchCompany(int id){
		return mapper.searchCompany(id);
	}
	@Transactional
	public List<Sub> searchSubject(int id){
		return mapper.searchSubject(id);
	}
	
	public ListView getList(int id) {
		ListView result = new ListView();
		Com company = this.searchCompany(id);
		List<Sub> subject = this.searchSubject(id);
		BeanUtils.copyProperties(company, result);
		result.setAcount_count(subject.size());
		result.setAccounts(subject);
		return result;
	}

	@Transactional
	public int del(int companyId) {
		return mapper.deleteCompany(companyId);
	}
	@Transactional
	public int edit(int companyId ,Com param) {
		param.setId(companyId);
		return mapper.updateCompany(param);
	}
	@Transactional
	public int add(Com param) {
		return mapper.insertCompany(param);
	}
}
