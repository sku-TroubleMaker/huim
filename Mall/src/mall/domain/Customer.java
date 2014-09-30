package mall.domain;

import java.sql.Date;

import sun.security.util.BigInt;

public class Customer {
	private String customerID;
	private String password;
	private String name;
	private String tel;
	private String email;
	private String address;
	private BigInt cash; //ȸ���� ������ �ִ� �ݾ�
	private Date joinDate; // ���Գ�¥
	private Date birthDate;
	private int check;	// VALID_CUSTOMER or INVALID_ID or INVALID_PASSWORD
	
	/** ��ȿ�� ȸ������ ��Ÿ���� ��� */
	public static final int VALID_CUSTOMER = 1;
	/** customerID�� �������� �ʴ� ȸ������ ��Ÿ���� ��� */
	public static final int INVALID_ID = 0; 
	/** password�� ��ġ���� �ʴ� ȸ������ ��Ÿ���� ��� */
	public static final int INVALID_PASSWORD = -1;
	
	public Customer() { //���� ����� ����?
		super();
	}

	public Customer(String customerID, String password, String name,
			String tel, String email, String address, BigInt cash,
			Date joinDate, Date birthDate, int check) {
		super();
		this.customerID = customerID;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.cash = cash;
		this.joinDate = joinDate;
		this.birthDate = birthDate;
		this.check = check;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", password=" + password
				+ ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", address=" + address + ", cash=" + cash + ", joinDate="
				+ joinDate + ", birthDate=" + birthDate + ", check=" + check
				+ "]";
	}
	
	
}