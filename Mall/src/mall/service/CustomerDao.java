package mall.service;

import mall.domain.Customer;

/**
 * 회원 관련 데이터 액세스 처리를 담당할 객체의 규격을 정의한 인터페이스.<br/> 
 * 데이터 액세스 층을 분리함으로써 데이터 액세스 층 이용 기술이나 구현이 변경되어도 
 * 비즈니스 로직 층에 영향을 주지 않는다.
 *
 */
public interface CustomerDao {
	
    /**
     * 데이터 저장소에 인수로 주어진 Customer 객체의 정보를 추가한다.
     *
     * @param customer 추가하고자 하는 회원정보를 담고 있는 Customer 객체
     */
	public void insertCustomer(Customer customer);
	
    /**
     * 데이터 저장소에서 인수로 주어진 customerID에 해당하는 회원정보를 검색한다.
     *
     * @param customerID 검색하고자 하는 회원의 customerID
     * @return 검색된 회원정보를 담고 있는 Customer 객체
     */
	public Customer selectCustomer(String customerID);
	
    /**
     * 데이터 저장소에서 인수로 주어진 Customer 객체의 정보를 갱신한다.
     *
     * @param customer 갱신하고자 하는 회원정보를 담고 있는 Customer 객체
     */
	public void updateCustomer(Customer member);
	
    /**
     * 데이터 저장소에서 인수로 주어진 Customer 객체의 정보를 삭제한다.
     *
     * @param customerID 삭제하고자 하는 회원정보를 담고 있는 customerID
     */
	public void deleteCustomer(String customerID);
	
    /**
     * 데이터 저장소에서 인수로 주어진 customerID와 password에 해당하는 회원정보를 확인하여 
     * 유효한 회원인가 여부를 판별한다.<br/>
     * 
     *  아이디가 존재하지 않을 경우에는 Customer의 check 값을 Customer.INVALID_ID 로,
     *  아이디는 존재하나 패스워드가 맞지 않을 경우에는 Customer의 check 값을 Customer.INVALID_PASSWORD 로,
     *  아이디와 패스워드가 모두 일치할 경우에는 Customer의 check의 값은 Customer.VALID_Customer 로 세팅하고 
     *  해당 회원정보를 담은 Customer 객체를 리턴한다.
     *
     * @param customerID 확인하고자 하는 회원의 customerID
     * @param password 확인하고자 하는 회원의 password
     * @return 유효 회원 여부 등의 회원정보를 담고 있는 Customer 객체
     */
	public Customer checkCustomer(String customerID, String password);
	
    /**
     * 데이터 저장소에서 모든 회원정보를 검색한다.
     * 
     * @return 검색된 모든 회원정보를 담고 있는 Customer 배열
     */
	public Customer[] selectAllCustomers();
	
    /**
     * 데이터 저장소에 인수로 주어진 customerID에 해당하는 기존 회원정보가 있는지 확인한다.
     * 
     * @return 해당하는 회원정보가 존재하면 true, 존재하지 않으면 false
     */
	public boolean customerIDExists(String customerID);
	
}
