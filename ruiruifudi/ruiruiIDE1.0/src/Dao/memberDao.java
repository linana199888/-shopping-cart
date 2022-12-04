package Dao;

import Model.member;

public interface memberDao {
	//新增
	void add(member m);//註冊
	
	//查詢
	boolean query(String username,String password);//帳號密碼
	boolean query(String username);//帳號重複
	
}
