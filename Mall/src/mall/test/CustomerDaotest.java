package mall.test;

import java.sql.Date;

import mall.domain.Customer;
import mall.service.CustomerDao;

public class CustomerDaotest implements CustomerDao {
	
	private String customerID;
	private String name;
	private String password;
	private String tel;
	private String email;
	private String address;
	private String grade;
	private Date customerDate;
	private int check;
	
	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer selectCustomer(String customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(String customerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer checkCustomer(String customerID, String password) {
		Customer cust = new Customer(customerID, password, password, tel, password, customerID, password, customerDate);
		return cust;
	}

	@Override
	public Customer[] selectAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean customerIDExists(String customerID) {
		// TODO Auto-generated method stub
		return false;
	}

}
