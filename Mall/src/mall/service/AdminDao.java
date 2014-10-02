package mall.service;

import mall.domain.Admin;

public interface AdminDao {

	public void insertAdmin(Admin admin);
	
	/**
     *
     *
     * @param customerID 확인하고자 하는 회원의 customerID
     * @param changeGrade 회원의 변경등급을 가지고 있는 changeGrade
     * 
	 */
	public void updateCustomerGrade(String customerID, String changeGrade);
	
	/**
     * 데이터 저장소에서 인수로 주어진 adminID와 password에 해당하는 회원정보를 확인하여 
     * 유효한 회원인가 여부를 판별한다.<br/>
     * 
     *  아이디가 존재하지 않을 경우에는 Admin의 check 값을 Admin.INVALID_ID 로,
     *  아이디는 존재하나 패스워드가 맞지 않을 경우에는 Admin의 check 값을 Admin.INVALID_PASSWORD 로,
     *  아이디와 패스워드가 모두 일치할 경우에는 Customer의 check의 값은 Admin.VALID_Admin 로 세팅하고 
     *  해당 회원정보를 담은 Admin 객체를 리턴한다.
     *
     * @param adminID 확인하고자 하는 회원의 adminID
     * @param password 확인하고자 하는 회원의 password
     * @return 유효 회원 여부 등의 회원정보를 담고 있는 Admin 객체
     */
	public Admin checkAdmin(String adminID, String password);
	
	public boolean adminIDExists(String adminID);
	
}
