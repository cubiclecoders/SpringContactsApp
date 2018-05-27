package com.ravi.contactsapp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.ravi.contactsapp.domain.User;


//
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {

	@Autowired
	public void setDataSource2(DataSource ds) {
		super.setDataSource(ds);
	}

}
