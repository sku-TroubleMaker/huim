package mall.service;

import mall.domain.Customer;

/**
 * @author �ȱٿ�
 * ȸ������ ���񽺸� �����ϱ� ���� �������̽�
 */
public interface CustomerService {
	/**
	 * ȸ���� ����ϱ� ���� �޼ҵ� 
	 */
	public void registerCustomer(Customer customer) throws DataNotFoundException;;
	
	/**
	 *  ȸ���� �˻��ϱ� ���� �޼ҵ�
	 *  (
	 *  @return Customer
	 */
	public Customer findCustomer(String customerID) throws DataNotFoundException;
	
	/**
	 *  ȸ�������� �����ϱ� ���� �޼ҵ�
	 *  
	 */
	public void updateCustomer(Customer customer) throws DataNotFoundException;
	
	/**
	 *  ȸ���� �����ϱ� ���� �޼ҵ�
	 */
	public void removeCustomer(String customerID) throws DataNotFoundException;
	
	/**
	 *  ȸ���� �α��������� �´��� Ȯ���ϴ� �޼ҵ�
	 *  �α��� ������ �´ٸ� Customer ��ü�� �����Ѵ�.
	 *  @return Customer
	 */
	public Customer loginCheck(String customerID, String password);

}
