package com.sameer.employees.Model;
// default package
// Generated Jul 23, 2016 1:52:39 AM by Hibernate Tools 4.0.0.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DeptEmp generated by hbm2java
 */
@Entity
@Table(name = "DEPT_EMP", schema = "SCOTT")
public class DeptEmp implements java.io.Serializable {

	private DeptEmpId id;
	private Employees employees;
	private Departments departments;
	private Date fromDate;
	private Date toDate;

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "empNo", column = @Column(name = "EMP_NO", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "deptNo", column = @Column(name = "DEPT_NO", nullable = false, length = 4)) })
	public DeptEmpId getId() {
		return this.id;
	}

	public void setId(DeptEmpId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_NO", nullable = false, insertable = false, updatable = false)
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_NO", nullable = false, insertable = false, updatable = false)
	public Departments getDepartments() {
		return this.departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FROM_DATE", nullable = false, length = 7)
	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TO_DATE", nullable = false, length = 7)
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
