package mall.domain;


import java.sql.Date;

/**
 * ȸ���� ������ ������ �����ϰ� �ִ� ��ü�� ������ ������ Ŭ����.<br/>
 * ����Ͻ� ���� ���� �������̽��� ǥ���Ǵ� Ư�� ������ Ư�� �μ� ó���� ������ ���� �� ���������� �����ȴ�.<br/>
 * �������� ���񽺷κ��� ����Ͻ��� �����ϴµ� �־� �翬�� �νĵǴ� Ŭ����(���̳� �ֹ��� ����)�� �������� �ڽ��� �������� ��Ÿ���� ���� ��
 * ���� �̿��� ó���� �����Ѵ�.<br/>
 * �������� ������ �������� �ʰ� �ܼ��� ���� �����ϱ⸸ �ϴ� ��ü�� ��� VO(Value Object: ���� �����ϴ� ��ü)��
 * DTO(Data Transfer Object: ���� �����ϱ⸸ �ϴ� ��ü)��� �θ��⵵ �Ѵ�.
 * 
 * @author �����(kidmania@hotmail.com)
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

	/** ��ȿ�� ȸ������ ��Ÿ���� ��� */
	public static final int VALID_CUSTOMER = 1;
	/** customerID�� �������� �ʴ� ȸ������ ��Ÿ���� ��� */
	public static final int INVALID_ID = 0;
	/** password�� ��ġ���� �ʴ� ȸ������ ��Ÿ���� ��� */
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
	 * ȸ���� ��ȿ�� ���θ� ��Ÿ���� check ���� �����Ѵ�. check �μ��� ���� Customer.VALID_MEMBER,
	 * Customer.INVALID_ID, Customer.INVALID_PASSWORD �� �ϳ����� �Ѵ�.
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
