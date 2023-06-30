package com.one.abc.customer.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.one.abc.customer.entity.PinMgt;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Customer") 
public class Customer {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private long id;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq")
	private long id; 
 
	
	@Column(name = "MobileNumber", unique = true)
	private String mobileNumber;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "DOB")
	private String dateOfBirth;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Kyc> kycCoustomer;
	
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
      private List<LoanType> loanType;
	
	@Column(name = "PanNumber")
	private String panNumber;
	
	@Column(name = "AdharNumber")
	private String adharNumber;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Gender")
	private String gender;
	
	//@OneToMany(cascade = CascadeType.ALL)  
	//@JoinColumn(name="id")  
	//@OrderColumn(name="AddressLine")  
	//@Column(name = "AddressLine")
	//private List<Address> addressLine;
	
	@Column(name = "Landmark")
	private String landmark;
	
	@Column(name = "Pincode")
	private String pincode;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference 
	private List<OccupationType> occupationType; 
	
	@Column(name = "CompanyName")
	private String companyName;
	
	@Column(name = "NriCustomer")
	private boolean nriCustomer;
	
	@Column(name = "MonthlyIncome")
	private String monthlyIncome;
	
	@Column(name = "LoanAmount")
	private String loanAmount;
	
	@Column(name = "Createdby")
	private String createdby;
	
	@Column(name = "Createddate")
	private String createddate;
	
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	
	@Column(name = "ModififedDate")
	private String modififedDate;
	
	@Column(name = "Active")
	private String active;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private PinMgt mpin;
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Kyc> getKycCoustomer() {
		return kycCoustomer;
	}

	public void setKycCoustomer(List<Kyc> kycCoustomer) {
		this.kycCoustomer = kycCoustomer;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean isNriCustomer() {
		return nriCustomer;
	}

	public void setNriCustomer(boolean nriCustomer) {
		this.nriCustomer = nriCustomer;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModififedDate() {
		return modififedDate;
	}

	public void setModififedDate(String modififedDate) {
		this.modififedDate = modififedDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<LoanType> getLoanType() {
		return loanType;
	}

	public void setLoanType(List<LoanType> loanType) {
		this.loanType = loanType;
	}

	 
	public List<OccupationType> getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(List<OccupationType> occupationType) {
		this.occupationType = occupationType;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long id, String mobileNumber, String firstName, String lastName, String dateOfBirth,
			List<Kyc> kycCoustomer, List<LoanType> loanType, String panNumber, String adharNumber, String email,
			String gender, String landmark, String pincode, List<OccupationType> occupationType, String companyName,
			boolean nriCustomer, String monthlyIncome, String loanAmount, String createdby, String createddate,
			String modifiedBy, String modififedDate, String active) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.kycCoustomer = kycCoustomer;
		this.loanType = loanType;
		this.panNumber = panNumber;
		this.adharNumber = adharNumber;
		this.email = email;
		this.gender = gender;
		this.landmark = landmark;
		this.pincode = pincode;
		this.occupationType = occupationType;
		this.companyName = companyName;
		this.nriCustomer = nriCustomer;
		this.monthlyIncome = monthlyIncome;
		this.loanAmount = loanAmount;
		this.createdby = createdby;
		this.createddate = createddate;
		this.modifiedBy = modifiedBy;
		this.modififedDate = modififedDate;
		this.active = active;
	}

	 
 
	
}
	
	
