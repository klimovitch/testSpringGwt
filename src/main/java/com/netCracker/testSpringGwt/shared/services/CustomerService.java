package com.netCracker.testSpringGwt.shared.services;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.netCracker.testSpringGwt.shared.dto.CustomerDTO;

@RemoteServiceRelativePath("springGwtServices/customerService")
public interface CustomerService extends RemoteService {

	public CustomerDTO findCustomer(long customerId);

	public List<CustomerDTO> findAllCustomersByMetaphone(String customerFirstName, String customerLastName);

	public List<CustomerDTO> findLastModifed(int maxResult);

	public List<String> getAllTypesCustomer();

	public void updateCustomer(CustomerDTO customer, String customerTitle, String customerFirstName, String customerLastName,
			Date customerLastModified, String customerType) throws Exception;

	public boolean saveCustomer(String customerTitle, String customerFirstName, String customerLastName, Date customerLastModified,
			String customerType) throws Exception;

	public CustomerDTO deleteCustomer(long customerId) throws Exception;

}
