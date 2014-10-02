package mall.service;

import mall.domain.Customer;

/**
 * ȸ�� ���� ������ �׼��� ó���� ����� ��ü�� �԰��� ������ �������̽�.<br/> 
 * ������ �׼��� ���� �и������ν� ������ �׼��� �� �̿� ����̳� ������ ����Ǿ 
 * ����Ͻ� ���� ���� ������ ���� �ʴ´�.
 *
 */
public interface CustomerDao {
	
    /**
     * ������ ����ҿ� �μ��� �־��� Customer ��ü�� ������ �߰��Ѵ�.
     *
     * @param customer �߰��ϰ��� �ϴ� ȸ�������� ��� �ִ� Customer ��ü
     */
	public void insertCustomer(Customer customer);
	
    /**
     * ������ ����ҿ��� �μ��� �־��� customerID�� �ش��ϴ� ȸ�������� �˻��Ѵ�.
     *
     * @param customerID �˻��ϰ��� �ϴ� ȸ���� customerID
     * @return �˻��� ȸ�������� ��� �ִ� Customer ��ü
     */
	public Customer selectCustomer(String customerID);
	
    /**
     * ������ ����ҿ��� �μ��� �־��� Customer ��ü�� ������ �����Ѵ�.
     *
     * @param customer �����ϰ��� �ϴ� ȸ�������� ��� �ִ� Customer ��ü
     */
	public void updateCustomer(Customer member);
	
    /**
     * ������ ����ҿ��� �μ��� �־��� Customer ��ü�� ������ �����Ѵ�.
     *
     * @param customerID �����ϰ��� �ϴ� ȸ�������� ��� �ִ� customerID
     */
	public void deleteCustomer(String customerID);
	
    /**
     * ������ ����ҿ��� �μ��� �־��� customerID�� password�� �ش��ϴ� ȸ�������� Ȯ���Ͽ� 
     * ��ȿ�� ȸ���ΰ� ���θ� �Ǻ��Ѵ�.<br/>
     * 
     *  ���̵� �������� ���� ��쿡�� Customer�� check ���� Customer.INVALID_ID ��,
     *  ���̵�� �����ϳ� �н����尡 ���� ���� ��쿡�� Customer�� check ���� Customer.INVALID_PASSWORD ��,
     *  ���̵�� �н����尡 ��� ��ġ�� ��쿡�� Customer�� check�� ���� Customer.VALID_Customer �� �����ϰ� 
     *  �ش� ȸ�������� ���� Customer ��ü�� �����Ѵ�.
     *
     * @param customerID Ȯ���ϰ��� �ϴ� ȸ���� customerID
     * @param password Ȯ���ϰ��� �ϴ� ȸ���� password
     * @return ��ȿ ȸ�� ���� ���� ȸ�������� ��� �ִ� Customer ��ü
     */
	public Customer checkCustomer(String customerID, String password);
	
    /**
     * ������ ����ҿ��� ��� ȸ�������� �˻��Ѵ�.
     * 
     * @return �˻��� ��� ȸ�������� ��� �ִ� Customer �迭
     */
	public Customer[] selectAllCustomers();
	
    /**
     * ������ ����ҿ� �μ��� �־��� customerID�� �ش��ϴ� ���� ȸ�������� �ִ��� Ȯ���Ѵ�.
     * 
     * @return �ش��ϴ� ȸ�������� �����ϸ� true, �������� ������ false
     */
	public boolean customerIDExists(String customerID);
	
}
