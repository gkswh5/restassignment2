package com.example.restassignment.model.entity;

import javax.validation.constraints.NotBlank;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComCSV {
	@CsvBindByName(column = "회사명")
	@NotBlank
	private String companyName;
	@CsvBindByName(column = "사용자 총 계정수")
	private int users_total;
	@CsvBindByName(column = "삭제 계정수")
	private int users_deleted;
	@CsvBindByName(column = "사용 계정수")
	private int users_use;
	@CsvBindByName(column = "서비스 사용유무")
	private boolean service_avail;
	@CsvBindByName(column = "타시스템 연동 여부")
	private boolean sync;
	@CsvBindByName(column = "연동시스템 종류")
	private String sync_kind;
	@CsvBindByName(column = "연동 ID")
	private int sync_id;
	
}
