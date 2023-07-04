package com.one.abc.customer.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_OccupationType")
public class OccupationType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OccupationType_seq_gen")
	@SequenceGenerator(name = "OccupationType_seq_gen", sequenceName = "OccupationType_seq")
	private int id;

	
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "customer_id")
	//@JsonBackReference
  //  private Customer customer;
	
	//@OneToMany(mappedBy = "OccupationType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JsonManagedReference 
	
	 
	
	
	@Column(name = "OccupationType")
	private String occupationType;

	@Column(name = "State")
	private String state;

	@Column(name = "CreatedBy")
	private String createdby;

	@Column(name = "CreatedDate")
	private Date createddate;

	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Column(name = "ModififedDate")
	private Date modififedDate;

	@Column(name = "Active")
	private String active;
	
	

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
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

	 

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	 

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public OccupationType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getModififedDate() {
		return modififedDate;
	}

	public void setModififedDate(Date modififedDate) {
		this.modififedDate = modififedDate;
	}

	public OccupationType(int id, String occupationType, String state, String createdby, Date createddate,
			String modifiedBy, Date modififedDate, String active) {
		super();
		this.id = id;
		this.occupationType = occupationType;
		this.state = state;
		this.createdby = createdby;
		this.createddate = createddate;
		this.modifiedBy = modifiedBy;
		this.modififedDate = modififedDate;
		this.active = active;
	}

	 

	 
	 

	 
	
	
	
	
	

}
