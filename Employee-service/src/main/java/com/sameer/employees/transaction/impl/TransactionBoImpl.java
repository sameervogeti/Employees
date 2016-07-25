package com.sameer.employees.transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sameer.employees.Dao.DepartmentsDaoimpl;

import com.sameer.employees.transaction.TransactionBo;

@Service
public class TransactionBoImpl implements TransactionBo {
	@Autowired
	DepartmentsDaoimpl deptdao;
	

	public void setDeptdao(DepartmentsDaoimpl deptdao) {
		this.deptdao = deptdao;
	}


	public String save() {

		return deptdao.deptlist().toString();

	}

}