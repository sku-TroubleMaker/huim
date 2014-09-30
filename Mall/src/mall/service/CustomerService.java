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
	public Customer findCustomer(String CustomerID) throws DataNotFoundException;
	
	/**
	 *  ȸ�������� �����ϱ� ���� �޼ҵ�
	 *  
	 */
	public void updateCustomer(Customer Customer) throws DataNotFoundException;
	
	/**
	 *  ȸ���� �����ϱ� ���� �޼ҵ�
	 */
	public void removeCustomer(Customer Customer) throws DataNotFoundException;
	
	/**
	 *  ȸ���� �α��������� �´��� Ȯ���ϴ� �޼ҵ�
	 *  �α��� ������ �´ٸ� Customer ��ü�� �����Ѵ�.
	 *  @return Customer
	 */
	public Customer loginCheck(String CustomerID, String password);

}
