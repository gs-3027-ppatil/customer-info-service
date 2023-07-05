package com.one.abc.customer.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_State")
public class State {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "state")
	private String state;

	@Column(name = "createdby")
	private String createdby;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "modifiedby")
	private String modifiedBy;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "modififeddate")
	private Date modififedDate;

	@Column(name = "active")
	private String active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	@JsonBackReference
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModififedDate() {
		return modififedDate;
	}

	public void setModififedDate(Date modififedDate) {
		this.modififedDate = modififedDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(long id, String state, String createdby, Date createddate, String modifiedBy, Date modififedDate,
			String active, Address address) {
		super();
		this.id = id;
		this.state = state;
		this.createdby = createdby;
		this.createddate = createddate;
		this.modifiedBy = modifiedBy;
		this.modififedDate = modififedDate;
		this.active = active;
		this.address = address;
	}

}
