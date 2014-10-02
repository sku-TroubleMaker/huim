package mall.domain;


import java.sql.Date;

/**
 * 회원과 관련한 정보를 저장하고 있는 객체를 정의한 도메인 클래스.<br/>
 * 비즈니스 로직 층은 유스케이스로 표현되는 특정 업무나 특정 부서 처리의 통합인 서비스 및 도메인으로 구성된다.<br/>
 * 도메인은 서비스로부터 비즈니스를 실행하는데 있어 당연히 인식되는 클래스(고객이나 주문과 같은)의 집합으로 자신이 무엇인지 나타내는 값과 그
 * 값을 이용한 처리를 실현한다.<br/>
 * 도메인이 로직을 포함하지 않고 단순히 값만 저장하기만 하는 객체일 경우 VO(Value Object: 값을 저장하는 객체)나
 * DTO(Data Transfer Object: 값을 전달하기만 하는 객체)라고 부르기도 한다.
 * 
 * @author 고범석(kidmania@hotmail.com)
 * 
 */
public class Customer {
	private String customerID;
	private String name;
	private String password;
	private String tel;
	private String email;
	private String address;
	private String grade;
	private Date customerDate;
	private int check; // VALID_CUSTOMER or INVALID_ID or INVALID_PASSWORD

	/** 유효한 회원임을 나타내는 상수 */
	public static final int VALID_CUSTOMER = 1;
	/** customerID가 존재하지 않는 회원임을 나타내는 상수 */
	public static final int INVALID_ID = 0;
	/** password가 일치하지 않는 회원임을 나타내는 상수 */
	public static final int INVALID_PASSWORD = -1;

	



	public Customer(String customerID, String password) {
	
		this.customerID = customerID;
		this.password = password;
	}

	

	public Customer(String customerID, String name, String password, String tel,
			String email, String address) {
		this.customerID = customerID;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.address = address;
	}
	
	

	public Customer(String customerID, String name, String password, String tel,
			String email, String address, String grade, Date customerDate) {
		this.customerID = customerID;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.grade = grade;
		this.customerDate = customerDate;
	}
	
	

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setCustomerDate(Date customerDate) {
		this.customerDate = customerDate;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getGrade() {
		return grade;
	}

	public Date getCustomerDate() {
		return customerDate;
	}

	public int getCheck() {
		return check;
	}

	/**
	 * 회원의 유효성 여부를 나타내는 check 값을 설정한다. check 인수의 값은 Customer.VALID_MEMBER,
	 * Customer.INVALID_ID, Customer.INVALID_PASSWORD 중 하나여야 한다.
	 * 
	 * @param check
	 *            Customer.VALID_MEMBER, Customer.INVALID_ID or
	 *            Customer.INVALID_PASSWORD
	 */
	public void setCheck(int check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name
				+ ", password=" + password + ", tel=" + tel + ", email="
				+ email + ", address=" + address + ", grade=" + grade
				+ ", customerDate=" + customerDate + "]";
	}

}
