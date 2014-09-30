package mall.service;

import mall.domain.Customer;

/**
 * @author 안근영
 * 회원관리 서비스를 구현하기 위한 인터페이스
 */
public interface CustomerService {
	/**
	 * 회원을 등록하기 위한 메소드 
	 */
	public void registerCustomer(Customer customer) throws DataNotFoundException;;
	
	/**
	 *  회원을 검색하기 위한 메소드
	 *  (
	 *  @return Customer
	 */
	public Customer findCustomer(String CustomerID) throws DataNotFoundException;
	
	/**
	 *  회원정보를 수정하기 위한 메소드
	 *  
	 */
	public void updateCustomer(Customer Customer) throws DataNotFoundException;
	
	/**
	 *  회원을 삭제하기 위한 메소드
	 */
	public void removeCustomer(Customer Customer) throws DataNotFoundException;
	
	/**
	 *  회원의 로그인정보가 맞는지 확인하는 메소드
	 *  로그인 정보가 맞다면 Customer 객체를 리턴한다.
	 *  @return Customer
	 */
	public Customer loginCheck(String CustomerID, String password);

}
