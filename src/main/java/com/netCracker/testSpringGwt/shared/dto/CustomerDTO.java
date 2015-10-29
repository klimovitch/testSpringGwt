package com.netCracker.testSpringGwt.shared.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "CUSTOMERS")
public class CustomerDTO implements java.io.Serializable {

	private static final long serialVersionUID = -4175570189545012130L;

	@Id
	@Column(name = "CASTOMER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUS_SEQ")
	@SequenceGenerator(name = "CUS_SEQ", sequenceName = "CUS_SEQ", allocationSize = 100)
	private long customerId;

	@Column(name = "TITLE", length = 3, nullable = false)
	private String customerTitle;

	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String customerFirstName;

	@Column(name = "FIRST_NAME_METAPHONE", length = 30, nullable = false)
	private String customerFirstNameMetaphone;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String customerLastName;

	@Column(name = "LAST_NAME_METAPHONE", length = 30, nullable = false)
	private String customerLastNameMetaphone;

	@Column(name = "MODIFIED_WHEN")
	private Date customerLastModified;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CASTOMER_TYPE_ID")
	private CustomerTypeDTO customerType;

	public CustomerDTO() {
	}

	public CustomerDTO(long customerId) {
		this.customerId = customerId;
	}

	public CustomerDTO(String customerTitle, String customerFirstName, String customerFirstNameMetaphone,
			String customerLastName, String customerLastNameMetaphone, Date customerLastModified) {
		this.customerTitle = customerTitle;
		this.customerFirstName = customerFirstName;
		this.customerFirstNameMetaphone = customerFirstNameMetaphone;
		this.customerLastName = customerLastName;
		this.customerLastNameMetaphone = customerLastNameMetaphone;
		this.customerLastModified = customerLastModified;
	}

	public CustomerTypeDTO getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerTypeDTO customerType) {
		this.customerType = customerType;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerTitle() {
		return customerTitle;
	}

	public void setCustomerTitle(String customerTitle) {
		this.customerTitle = customerTitle;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerFirstNameMetaphone() {
		return customerFirstNameMetaphone;
	}

	public void setCustomerFirstNameMetaphone(String customerFirstNameMetaphone) {
		this.customerFirstNameMetaphone = customerFirstNameMetaphone;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerLastNameMetaphone() {
		return customerLastNameMetaphone;
	}

	public void setCustomerLastNameMetaphone(String customerLastNameMetaphone) {
		this.customerLastNameMetaphone = customerLastNameMetaphone;
	}

	public Date getCustomerLastModified() {
		return customerLastModified;
	}

	public void setCustomerLastModified(Date customerLastModified) {
		this.customerLastModified = customerLastModified;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", customerTitle=" + customerTitle + ", customerFirstName=" + customerFirstName
				+ ", customerFirstNameMetaphone=" + customerFirstNameMetaphone + ", customerLastName=" + customerLastName
				+ ", customerLastNameMetaphone=" + customerLastNameMetaphone + ", customerLastModified=" + customerLastModified + ", customerType="
				+ customerType + "]";
	}
	
	

}
