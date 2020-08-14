package com.example.restassignment.model.view;

import java.util.List;

import com.example.restassignment.model.entity.Sub;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListView {
	int id;
	String created_at;
	String modified_at;
	String deleted_at;
	String companyName;
	int users_total;
	int users_deleted;
	int users_use;
	boolean service_avail;
	boolean sync;
	String sync_kind;
	int sync_id;
	int acount_count;
	List<Sub> accounts;
}
