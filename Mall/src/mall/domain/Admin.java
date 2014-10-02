package mall.domain;

import java.sql.Date;

public class Admin {
	private String adminID;
	private String name;
	private String password;
	private Date AdminDate;
	private int check; // VALID_ADMIN or INVALID_ID or INVALID_PASSWORD

	/** ��ȿ�� ȸ������ ��Ÿ���� ��� */
	public static final int VALID_ADMIN = 1;
	/** memberID�� �������� �ʴ� ȸ������ ��Ÿ���� ��� */
	public static final int INVALID_ID = 0;
	/** password�� ��ġ���� �ʴ� ȸ������ ��Ÿ���� ��� */
	public static final int INVALID_PASSWORD = -1;

	public Admin() {
	}

	public Admin(String adminID, String password) {
		this.adminID = adminID;
		this.password = password;
	}

	public Admin(String adminID, String name, String password) {
		this.adminID = adminID;
		this.name = name;
		this.password = password;
	}

	public String getAdminID() {
		return adminID;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCheck() {
		return check;
	}

	/**
	 * ȸ���� ��ȿ�� ���θ� ��Ÿ���� check ���� �����Ѵ�. check �μ��� ���� Admin.VALID_MEMBER,
	 * Admin.INVALID_ID, Admin.INVALID_PASSWORD �� �ϳ����� �Ѵ�.
	 * 
	 * @param check
	 *            Admin.VALID_MEMBER, Admin.INVALID_ID or
	 *            Admin.INVALID_PASSWORD
	 */
	public void setCheck(int check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", name=" + name + ", password="
				+ password + "]";
	}

}
