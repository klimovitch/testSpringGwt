package com.netCracker.testSpringGwt.server.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netCracker.testSpringGwt.server.dao.CustomerDAO;
import com.netCracker.testSpringGwt.server.dao.CustomerTypeDAO;
import com.netCracker.testSpringGwt.shared.dto.CustomerDTO;
import com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO;
import com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType;
import com.netCracker.testSpringGwt.shared.services.CustomerService;
import com.netCracker.testSpringGwt.shared.services.utils.MetaphoneUtils;

@Service("customerService")
public class CustomerServiceImp implements CustomerService {

	private static Logger logger = Logger.getLogger(CustomerServiceImp.class);

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private CustomerTypeDAO customerTypeDAO;

	@PostConstruct
	public void init() {

	}

	@PreDestroy
	public void destroy() {
	}

	public CustomerDTO findCustomer(long customerId) {

		CustomerDTO customerDTO = customerDAO.findById(customerId);

		logger.info("findCustomer: " + customerDTO.getCustomerTitle() + " " + customerDTO.getCustomerFirstName() + " "
				+ customerDTO.getCustomerFirstNameMetaphone() + " " + customerDTO.getCustomerLastName() + " "
				+ customerDTO.getCustomerLastNameMetaphone() + " " + customerDTO.getCustomerType().getCustomerType() + " "
				+ customerDTO.getCustomerLastModified().toString());

		return customerDTO;

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<CustomerDTO> findAllCustomersByMetaphone(String customerFirstName, String customerLastName) {

		logger.info("findAllCustomersByMetaphone: customerFirstName: " + customerFirstName + ", customerLastName:" + customerLastName);

		MetaphoneUtils metaphoner = new MetaphoneUtils();
		String customerFirstNameMetaphone = metaphoner.metaphoneCustomer(customerFirstName);
		String customerLastNameMetaphone = metaphoner.metaphoneCustomer(customerLastName);

		return customerDAO.findAllMetaphone(customerFirstNameMetaphone, customerLastNameMetaphone);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<CustomerDTO> findLastModifed(final int maxResult) {

		List<CustomerDTO> findRes = customerDAO.findLastModifed(maxResult);

		logger.info("findLastModifed...");

		return findRes;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<String> getAllTypesCustomer() {

		List<String> res = new ArrayList<String>();
		CustomerTypeDTO customerType = new CustomerTypeDTO();
		CustomerType[] findRes = customerType.getCustomerType().values();
		for (CustomerType i : findRes) {
			res.add(i.toString());
		}

		logger.info("getAllTypesCustomer... ");

		return res;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateCustomer(CustomerDTO customerDTO, String customerTitle, String customerFirstName, String customerLastName,
			Date customerLastModified, String customerType) throws Exception {

		logger.info("updateCustomer: " + customerDTO.getCustomerTitle() + " " + customerDTO.getCustomerFirstName() + " "
				+ customerDTO.getCustomerFirstNameMetaphone() + " " + customerDTO.getCustomerLastName() + " "
				+ customerDTO.getCustomerLastNameMetaphone() + " " + customerDTO.getCustomerType().getCustomerType() + " "
				+ customerDTO.getCustomerLastModified().toString());

		logger.info("New field: " + "customerTitle " + customerTitle + ", customerFirstName " + customerFirstName + ", customerLastName "
				+ customerLastName + ", customerType" + customerType + ", customerLastModified " + customerLastModified);

		MetaphoneUtils metaphoner = new MetaphoneUtils();
		String customerFirstNameMetaphone = metaphoner.metaphoneCustomer(customerFirstName);
		String customerLastNameMetaphone = metaphoner.metaphoneCustomer(customerLastName);

		CustomerDTO customer = customerDAO.findById(customerDTO.getCustomerId());

		customer.setCustomerTitle(customerTitle);
		customer.setCustomerFirstName(customerFirstName);
		customer.setCustomerFirstNameMetaphone(customerFirstNameMetaphone);
		customer.setCustomerLastName(customerLastName);
		customer.setCustomerLastNameMetaphone(customerLastNameMetaphone);
		customer.setCustomerLastModified(customerLastModified);
		CustomerTypeDTO custType = customer.getCustomerType();
		custType.setCustomerType(CustomerType.valueOf(customerType));
		customer.setCustomerType(custType);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public CustomerDTO deleteCustomer(long customerId) throws Exception {

		CustomerDTO customerDTO = customerDAO.findById(customerId);

		logger.info("deleteCustomer: " + customerDTO.getCustomerTitle() + " " + customerDTO.getCustomerFirstName() + " "
				+ customerDTO.getCustomerFirstNameMetaphone() + " " + customerDTO.getCustomerLastName() + " "
				+ customerDTO.getCustomerLastNameMetaphone() + " " + customerDTO.getCustomerType().getCustomerType() + " "
				+ customerDTO.getCustomerLastModified().toString());

		if (customerDTO != null) {
			customerDAO.remove(customerDTO);
		}
		return customerDTO;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean saveCustomer(String customerTitle, String customerFirstName, String customerLastName, Date customerLastModified,
			String customerType) throws Exception {

		boolean saved = true;

		MetaphoneUtils metaphoner = new MetaphoneUtils();
		String customerFirstNameMetaphone = metaphoner.metaphoneCustomer(customerFirstName);
		String customerLastNameMetaphone = metaphoner.metaphoneCustomer(customerLastName);

		List<CustomerDTO> findRes = customerDAO.findAllMetaphone(customerFirstNameMetaphone, customerLastNameMetaphone);

		if (findRes.size() == 0) {

			CustomerTypeDTO customerTypeDTO = new CustomerTypeDTO(CustomerType.valueOf(customerType));
			CustomerDTO customerDTO = new CustomerDTO(customerTitle, customerFirstName, customerFirstNameMetaphone, customerLastName,
					customerLastNameMetaphone, customerLastModified);

			customerTypeDTO.getCustomers().add(customerDTO);
			customerDTO.setCustomerType(customerTypeDTO);
			customerTypeDAO.persist(customerTypeDTO);
			customerDAO.persist(customerDTO);

			logger.info("saveCustomer: " + customerDTO.getCustomerTitle() + " " + customerDTO.getCustomerFirstName() + " "
					+ customerDTO.getCustomerFirstNameMetaphone() + " " + customerDTO.getCustomerLastName() + " "
					+ customerDTO.getCustomerLastNameMetaphone() + " " + customerDTO.getCustomerType().getCustomerType() + " "
					+ customerDTO.getCustomerLastModified().toString());

			return saved;
		} else {
			for (CustomerDTO i : findRes) {

				if (i.getCustomerTitle().equals(customerTitle) && i.getCustomerFirstName().equals(customerFirstName)
						&& i.getCustomerLastName().equals(customerLastName) && i.getCustomerType().getCustomerType().toString().equals(customerType))

				{
					return saved = false;

				} else {

					CustomerTypeDTO customerTypeDTO = new CustomerTypeDTO(CustomerType.valueOf(customerType));
					CustomerDTO customerDTO = new CustomerDTO(customerTitle, customerFirstName, customerFirstNameMetaphone, customerLastName,
							customerLastNameMetaphone, customerLastModified);

					customerTypeDTO.getCustomers().add(customerDTO);
					customerDTO.setCustomerType(customerTypeDTO);
					customerTypeDAO.persist(customerTypeDTO);
					customerDAO.persist(customerDTO);

					logger.info("saveCustomer: " + customerDTO.getCustomerTitle() + " " + customerDTO.getCustomerFirstName() + " "
							+ customerDTO.getCustomerFirstNameMetaphone() + " " + customerDTO.getCustomerLastName() + " "
							+ customerDTO.getCustomerLastNameMetaphone() + " " + customerDTO.getCustomerType().getCustomerType() + " "
							+ customerDTO.getCustomerLastModified().toString());

					break;
				}
			}
		}
		return saved;
	}

}
