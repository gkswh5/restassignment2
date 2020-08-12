package com.example.restassignment.model.view;

import java.util.List;

import com.example.restassignment.model.entity.Sub;

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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getUsers_total() {
		return users_total;
	}
	public void setUsers_total(int users_total) {
		this.users_total = users_total;
	}
	public int getUsers_deleted() {
		return users_deleted;
	}
	public void setUsers_deleted(int users_deleted) {
		this.users_deleted = users_deleted;
	}
	public int getUsers_use() {
		return users_use;
	}
	public void setUsers_use(int users_use) {
		this.users_use = users_use;
	}
	public boolean isService_avail() {
		return service_avail;
	}
	public void setService_avail(boolean service_avail) {
		this.service_avail = service_avail;
	}
	public boolean isSync() {
		return sync;
	}
	public void setSync(boolean sync) {
		this.sync = sync;
	}
	public String getSync_kind() {
		return sync_kind;
	}
	public void setSync_kind(String sync_kind) {
		this.sync_kind = sync_kind;
	}
	public int getSync_id() {
		return sync_id;
	}
	public void setSync_id(int sync_id) {
		this.sync_id = sync_id;
	}
	public int getAcount_count() {
		return acount_count;
	}
	public void setAcount_count(int acount_count) {
		this.acount_count = acount_count;
	}
	public List<Sub> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Sub> accounts) {
		this.accounts = accounts;
	}
	  
}

