package com.inxedu.os.edu.entity.system;

import lombok.Data;

import java.io.Serializable;

/**
 * 后台用户 查询辅助类
 * @author www.inxedu.com
 */
public class QuerySysUser implements Serializable{
	private static final long serialVersionUID = -4245147909069772323L;
	private String keyWord;

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
}
