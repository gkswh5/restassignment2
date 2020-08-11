package com.example.restassignment;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	public ApiView getList(int id) {
		ListView result = new ListView();
		Com company = this.searchCompany(id);
		List<Sub> subject = this.searchSubject(id);
		BeanUtils.copyProperties(company, result);
		result.setAcount_count(subject.size());
		result.setAccounts(subject);
		return this.restApi(result,200);
	}

	@Transactional
	public ApiView del(int companyId) {
		int result = mapper.deleteCompany(companyId);
		if (result == 1)
			return this.restApi("Success", 200);
		else
			return this.restApi("Failed", 2000);
	}
	@Transactional
	public ApiView edit(int companyId ,Com param) {
		param.setId(companyId);
		int result = mapper.updateCompany(param);
		if (result == 1)
			return this.restApi("Success", 200);
		else
			return this.restApi("Failed", 2000);
	}
	@Transactional
	public ApiView add(Com param) {
		int result = mapper.insertCompany(param);
		if (result == 1)
			return this.restApi("Success", 200);
		else
			return this.restApi("Failed", 2000);
	}
	public ApiView restApi(Object o,int status) {
		ApiView v = new ApiView();
		switch (status){
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
}
