package com.example.restassignment.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.restassignment.mapper.OneMapper;
import com.example.restassignment.model.entity.Com;
import com.example.restassignment.model.entity.Sub;
import com.example.restassignment.model.view.ListView;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OneService {

	@Autowired
	public ObjectMapper om;

	@Autowired
	public OneMapper mapper;

	@Transactional
	public Com searchCompany(int id) {
		return mapper.searchCompany(id);
	}

	@Transactional
	public List<Sub> searchSubject(int id) {
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
	public int edit(int companyId, Com param) {
		param.setId(companyId);
		return mapper.updateCompany(param);
	}

	@Transactional
	public int add(Com param) {
		return mapper.insertCompany(param);
	}
}
