package com.example.restassignment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.restassignment.model.entity.Com;
import com.example.restassignment.model.entity.Sub;

@Repository
@Mapper
public interface OneMapper {

	Com searchCompany(int id);

	List<Sub> searchSubject(int id);

	int deleteCompany(int id);

	int updateCompany(Com param);

	int insertCompany(Com param);
}
