package com.example.restassignment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.restassignment.lib.CSVLib;
import com.example.restassignment.mapper.OneMapper;
import com.example.restassignment.model.entity.CSVfiles;
import com.example.restassignment.model.entity.Com;
import com.example.restassignment.model.entity.Sub;
import com.example.restassignment.model.view.ListView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class OneService {

	@Autowired
	private ObjectMapper om;

	@Autowired
	private OneMapper mapper;

	@Transactional
	public Com searchCompany(int id) {
		return mapper.searchCompany(id);
	}

	/*
	 * public Com searchCompanybyName(String name) { return
	 * mapper.searchCompany(id); }
	 */
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
	public int addCom(Com param) {
		return mapper.insertCompany(param);
	}

	@Transactional
	public int addmassiveCom(final Iterator<Com> it) {
		int result = 0;
		List<Com> sublist = new ArrayList<Com>();
		while(it.hasNext()) {
			sublist.add(it.next());
			if(sublist.size()>1000) {
				result += mapper.insertbulkCompany(sublist);
				sublist.clear();
			}
		}
		result += mapper.insertbulkCompany(sublist);
		sublist.clear();
		return result;
	}

	@Transactional
	public int addSub(Sub param) {
		return mapper.insertSubject(param);
	}
	
	@Transactional
	public int addmassiveSub(final Iterator<Sub> it) {
		int result = 0;
		List<Sub> sublist = new ArrayList<Sub>();
		while(it.hasNext()) {
			sublist.add(it.next());
			if(sublist.size()>1000) {
				result += mapper.insertbulkSubject(sublist);
				sublist.clear();
			}
		}
		result += mapper.insertbulkSubject(sublist);
		sublist.clear();
		return result;
	}


	public Map<String, Integer> processCSV(@Valid CSVfiles files) throws IOException {
		int coms = this.ComCsvinsert(files.getCompanyfile());
		
		//int subs = this.SubCsvinsert(files.getAccountsfile());

		Map<String, Integer> result = new HashMap<String, Integer>();

		// subsuc = this.addmassiveSub(subs);
		result.put("Com", coms);
		//result.put("Sub", subs);
		return result;
	}

	public int ComCsvinsert(MultipartFile file) {
		BufferedReader reader = null;
		int result =0;
		try {
			reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

			CsvToBean<Com> csv = new CsvToBeanBuilder(reader).withType(Com.class).withIgnoreLeadingWhiteSpace(true)
					.build();
			Iterator<Com> csvIterator = csv.iterator();
			result = this.addmassiveCom(csvIterator);
			return result;
		} catch (IOException e) {
			// 글로벌 익셉션핸들러 못쓰나?
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {

				}
			}
		}
		return 0;

	}
	public int SubCsvinsert(MultipartFile file) {
		BufferedReader reader = null;
		int result =0;
		try {
			reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

			CsvToBean<Sub> csv = new CsvToBeanBuilder(reader).withType(Sub.class).withIgnoreLeadingWhiteSpace(true)
					.build();
			Iterator<Sub> csvIterator = csv.iterator();
			result = this.addmassiveSub(csvIterator);
			return result;
		} catch (IOException e) {
			// 글로벌 익셉션핸들러 못쓰나?
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {

				}
			}
		}
		return 0;

	}

}
