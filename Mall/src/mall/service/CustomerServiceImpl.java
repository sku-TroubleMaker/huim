package mall.service;

import mall.dataaccess.CustomerDaoImpl;
import mall.domain.Customer;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDataAccess;
	
	
	
	public CustomerServiceImpl() {
		customerDataAccess = new CustomerDaoImpl(); 
	}

	@Override
	public void registerCustomer(Customer customer)
			throws DataNotFoundException {
		customerDataAccess.insertCustomer(customer);
		
	}

	@Override
	public Customer findCustomer(String customerID)
			throws DataNotFoundException {
		
		return customerDataAccess.selectCustomer(customerID);
	}

	@Override
	public void updateCustomer(Customer customer) throws DataNotFoundException {
		customerDataAccess.updateCustomer(customer);
		
	}

	@Override
	public void removeCustomer(String customerID) throws DataNotFoundException {
		customerDataAccess.deleteCustomer(customerID);
		
	}

	@Override
	public Customer loginCheck(String customerID, String password) {
		return customerDataAccess.checkCustomer(customerID, password);
		
		
	}

}
