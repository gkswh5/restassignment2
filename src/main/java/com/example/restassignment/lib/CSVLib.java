package com.example.restassignment.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.example.restassignment.GlobalExeceptionHandler;
import com.example.restassignment.model.entity.CSVfiles;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class CSVLib {
	@Autowired
	GlobalExeceptionHandler errhandler;

	public static boolean isVaild(CSVfiles files) {
		if (files.getAccountsfile().getContentType() != "text/csv"
				|| files.getCompanyfile().getContentType() != "text/csv") {
			return false;
		}
		return true;
	}


}