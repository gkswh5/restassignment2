package com.example.restassignment;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OneMapper {
	//List<One> searchCompany(int id);
	Com searchCompany(int id);
	List<Sub> searchSubject(int id);
	int deleteCompany(int id);
	int updateCompany(Com param);
	int insertCompany(Com param);
}
