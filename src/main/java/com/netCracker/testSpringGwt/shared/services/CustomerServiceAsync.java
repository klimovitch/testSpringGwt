package com.netCracker.testSpringGwt.shared.services;

import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.netCracker.testSpringGwt.shared.dto.CustomerDTO;
import com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO;

public interface CustomerServiceAsync

{

	/**
	 * 
	 * GWT-RPC service asynchronous (client-side) interface
	 * 
	 * @see com.netCracker.testSpringGwt.shared.services.CustomerService
	 * 
	 */

	void findCustomer(long customerId, AsyncCallback callback);

	/**
	 * 
	 * GWT-RPC service asynchronous (client-side) interface
	 * 
	 * @see com.netCracker.testSpringGwt.shared.services.CustomerService
	 * 
	 */

	void findAllCustomersByMetaphone(String customerFirstName, String customerLastName, AsyncCallback callback);

	/**
	 * 
	 * GWT-RPC service asynchronous (client-side) interface
	 * 
	 * @see com.netCracker.testSpringGwt.shared.services.CustomerService
	 * 
	 */
	void findLastModifed(int maxResult, AsyncCallback callback);

	/**
	 * 
	 * GWT-RPC service asynchronous (client-side) interface
	 * 
	 * @see com.netCracker.testSpringGwt.shared.services.CustomerService
	 * 
	 */

	void getAllTypesCustomer(AsyncCallback callback);

	/**
	 * 
	 * GWT-RPC service asynchronous (client-side) interface
	 * 
	 * @see com.netCracker.testSpringGwt.shared.services.CustomerService
	 * 
	 */

	void updateCustomer(CustomerDTO customer, String customerTitle, String customerFirstName, String customerLastName, Date customerLastModified,
			String customerType, AsyncCallback callback);

	/**
	 * 
	 * GWT-RPC service asynchronous (client-side) interface
	 * 
	 * @see com.netCracker.testSpringGwt.shared.services.CustomerService
	 * 
	 */

	void saveCustomer(String customerTitle, String customerFirstName, String customerLastName, Date customerLastModified, String customerType,
			AsyncCallback callback);

	/**
	 * 
	 * GWT-RPC service asynchronous (client-side) interface
	 * 
	 * @see com.netCracker.testSpringGwt.shared.services.CustomerService
	 * 
	 */

	void deleteCustomer(long customerId, AsyncCallback callback);

	/**
	 * 
	 * Utility class to get the RPC Async interface from client-side code
	 * 
	 */

	public static final class Util

	{

		private static CustomerServiceAsync instance;

		public static final CustomerServiceAsync getInstance() {

			if (instance == null)

			{

				instance = (CustomerServiceAsync) GWT.create(CustomerService.class);

				ServiceDefTarget target = (ServiceDefTarget) instance;

				target.setServiceEntryPoint(GWT.getModuleBaseURL() + "springGwtServices/customerService");

			}

			return instance;

		}

		private Util()

		{

			// Utility class should not be instanciated

		}

	}

}