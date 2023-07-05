package com.one.abc.customer.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_PINMGT")
public class PinMgt {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "currentMpin")
	private String currentMpin;

	@Column(name = "mpinExpiry")
	private Date mpinExpiry;

	@Column(name = "createdBy")
	private String createdBy;

	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "createdDate")
	private Date createdDate;
	
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "modifiedDate")
	private Date modifiedDate;

	@Column(name = "modifiedBy")
	private String modifiedBy;
	
	@Column(name = "active")
	private String active;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cust_id")
	private Customer customer;
	
}
