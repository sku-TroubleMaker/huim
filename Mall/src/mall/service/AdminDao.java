package mall.service;

import mall.domain.Admin;

public interface AdminDao {

	public void insertAdmin(Admin admin);
	
	/**
     *
     *
     * @param customerID Ȯ���ϰ��� �ϴ� ȸ���� customerID
     * @param changeGrade ȸ���� �������� ������ �ִ� changeGrade
     * 
	 */
	public void updateCustomerGrade(String customerID, String changeGrade);
	
	/**
     * ������ ����ҿ��� �μ��� �־��� adminID�� password�� �ش��ϴ� ȸ�������� Ȯ���Ͽ� 
     * ��ȿ�� ȸ���ΰ� ���θ� �Ǻ��Ѵ�.<br/>
     * 
     *  ���̵� �������� ���� ��쿡�� Admin�� check ���� Admin.INVALID_ID ��,
     *  ���̵�� �����ϳ� �н����尡 ���� ���� ��쿡�� Admin�� check ���� Admin.INVALID_PASSWORD ��,
     *  ���̵�� �н����尡 ��� ��ġ�� ��쿡�� Customer�� check�� ���� Admin.VALID_Admin �� �����ϰ� 
     *  �ش� ȸ�������� ���� Admin ��ü�� �����Ѵ�.
     *
     * @param adminID Ȯ���ϰ��� �ϴ� ȸ���� adminID
     * @param password Ȯ���ϰ��� �ϴ� ȸ���� password
     * @return ��ȿ ȸ�� ���� ���� ȸ�������� ��� �ִ� Admin ��ü
     */
	public Admin checkAdmin(String adminID, String password);
	
	public boolean adminIDExists(String adminID);
	
}
