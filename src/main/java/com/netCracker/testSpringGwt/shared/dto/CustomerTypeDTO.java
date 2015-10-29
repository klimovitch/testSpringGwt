package com.netCracker.testSpringGwt.shared.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.google.gwt.user.client.rpc.GwtTransient;

@Entity
@Table(name = "CUSTOMER_TYPES")
public class CustomerTypeDTO implements java.io.Serializable {

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	private static final long serialVersionUID = 6579423265089817474L;

	public enum CustomerType {
		Residential, Business, Enterprise;
	}

	@Id
	@Column(name = "CASTOMER_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUS_TYPE_SEQ")
	@SequenceGenerator(name = "CUS_TYPE_SEQ", sequenceName = "CUS_TYPE_SEQ", allocationSize = 100)
	private long customerId;

	@Column(name = "CUSTOMER_TYPE_CAPTION", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private CustomerType customerType;

	@OneToMany(/* cascade = CascadeType.ALL, */mappedBy = "customerType", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@GwtTransient
	private List<CustomerDTO> customers = new ArrayList<CustomerDTO>();

	public CustomerTypeDTO() {
	}

	public CustomerTypeDTO(long customerId) {
		this.customerId = customerId;
	}

	public CustomerTypeDTO(CustomerType customerType) {
		this.customerType = customerType;
	}

	public List<CustomerDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerDTO> customers) {
		this.customers = customers;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void CustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	@Override
	public String toString() {
		return "CustomerTypeDTO [customerId=" + customerId + ", customerType=" + customerType + ", customers=" + customers + "]";
	}

	
}
