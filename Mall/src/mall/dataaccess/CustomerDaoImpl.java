package mall.dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mall.domain.Customer;
import mall.service.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {
	private DataSource dataSource;

	/*
	 * 1. JNDI API�� �̿��Ͽ� ���̹� ���񽺿� ���(���ε�)�� DataSource�� �˻��Ѵ�. (jdbc/huimMallDB"
	 * �̶� ���� �̸����� �˻�)
	 */
	public CustomerDaoImpl() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context
					.lookup("java:comp/env/jdbc/huimMallDB");
		} catch (NamingException ne) {
			System.err.println("JNDI error ocurred");
			ne.printStackTrace(System.err);
			throw new RuntimeException("JNDI error ocurred" + ne.getMessage());
		}
	}

	/*
	 * DriverManager�� getConnection() �޼ҵ带 ���� Connection�� �����.
	 */

	private Connection obtainConnection() throws SQLException {
		return dataSource.getConnection();
		// return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * huim.business.service.CustomerDao#insertCustomer(huim.business.
	 * domain.Customer)
	 * 
	 * 2. ���ڷ� ���� Customer ��ü ������ ���� Customer ���̺� ���ο� ���ڵ带 �߰�(insert) �Ѵ�. 
	 * 2.1. Customer ���̺� ���ڵ带 INSERT�ϴ� SQL ������ �ۼ��Ѵ�. 
	 * 2.2. obtainConnection() �޼ҵ带 ȣ���ؼ� Connection�� ���´�. 
	 * 2.3. Statement ��ü�� �����Ѵ�. 
	 * 2.4. executeUpdate() �޼ҵ带 ȣ���� INSERT SQL���� �����Ų��.
	 */
	@Override
	public void insertCustomer(Customer customer) {
		String query = "INSERT INTO Customer (CUST_ID, CUST_NAME, CUST_PASSWORD, CUST_TEL"
							+ ", CUST_EMAIL, CUST_ADDRESS, CUST_GRADE, CUST_DATE) "
							+ "VALUES (?,?,?,?,?,?,'����ȸ��',?)";

		System.out.println("MemberDAOImpl insertMember() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			System.out.println("dao ���");
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);

			stmt.setString(1, customer.getCustomerID());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getPassword());
			stmt.setString(4, customer.getTel());
			stmt.setString(5, customer.getEmail());
			stmt.setString(6, customer.getAddress());
			stmt.setDate(7, new Date(System.currentTimeMillis()));
			stmt.executeUpdate();

		} catch (SQLException se) {
			System.err.println("CustomerDAOImpl insertCustomer() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			throw new RuntimeException("A database error occurred. "
					+ se.getMessage());

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see huim.business.service.CustomerDao#selectCustomer(java.lang.String)
	 * 
	 * 3. ���ڷ� ���� customerID�� ���ڵ带 ã��(select) �ش� ������ ���� Customer ��ü�� �����Ѵ�. 
	 * 3.1. Customer ���̺��� ���ڵ带 SELECT�ϴ� SQL ������ �ۼ��Ѵ�. 
	 * 3.2. obtainConnection() �޼ҵ带 ȣ���ؼ� Connection�� ���´�. 
	 * 3.3. Statement ��ü�� �����Ѵ�. 
	 * 3.4. executeQuery()�� ȣ���� SELECT SQL���� �����Ų��. 
	 * 3.5. ResultSet ��ü�� ���� ����� �ʵ� �����͵�� Customer ��ü�� ä�� �����Ѵ�.
	 */
	@Override
	public Customer selectCustomer(String customerID) {
		Customer customer = null;

		String query = "SELECT * FROM Customer WHERE CUST_ID = ?";

		System.out.println("CustomerrDAOImpl selectCustomer() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, customerID);

			rs = stmt.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getString("CUST_ID"),
						rs.getString("CUST_NAME"), rs.getString("CUST_PASSWORD"),
						rs.getString("CUST_TEL"), rs.getString("CUST_EMAIL"),
						rs.getString("CUST_ADDRESS"), rs.getString("CUST_GRADE"),
						rs.getDate("CUST_DATE"));
			}

		} catch (SQLException se) {
			System.err.println("CustomerDAOImpl selectCustomer() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			throw new RuntimeException("A database error occurred. "
					+ se.getMessage());

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}

		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * casestudy.business.service.MemberDao#updateMember(casestudy.business.
	 * domain.Member)
	 * 
	 * 4. ���ڷ� ���� Member ��ü�� ������ Member ���̺��� ���ڵ带 ����(update) �Ѵ�. 4.1. Member ���̺���
	 * ���ڵ带 UPDATE�ϴ� SQL ������ �ۼ��Ѵ�. 4.2. obtainConnection() �޼ҵ带 ȣ���ؼ� Connection��
	 * ���´�. 4.3. Statement ��ü�� �����Ѵ�. 4.4. executeUpdate()�� ȣ���� UPDATE SQL����
	 * �����Ų��.
	 */
	@Override
	public void updateCustomer(Customer customer) {
		String query = "UPDATE Customer SET CUST_NAME=?, CUST_PASSWORD=?,  "
				+ "CUST_TEL=?, CUST_EMAIL=?, CUST_ADDRESS=? WHERE CUST_ID=? ";
		System.out.println("CustomerDAOImpl updateCustomer() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);

			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getPassword());
			stmt.setString(3, customer.getTel());
			stmt.setString(4, customer.getEmail());
			stmt.setString(5, customer.getAddress());
			stmt.setString(6, customer.getCustomerID());

			stmt.executeUpdate();

		} catch (SQLException se) {
			System.err.println("CustomerDAOImpl updateCustomer() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			throw new RuntimeException("A database error occurred. "
					+ se.getMessage());

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * casestudy.business.service.MemberDao#deleteMember(casestudy.business.
	 * domain.Member)
	 * 
	 * 5. ���ڷ� ���� Member ��ü�� ������ ���� Member ���̺��� ���ڵ带 ����(delete) �Ѵ�. 5.1. Member
	 * ���̺��� ���ڵ带 DELETE�ϴ� SQL ������ �ۼ��Ѵ�. 5.2. obtainConnection() �޼ҵ带 ȣ���ؼ�
	 * Connection�� ���´�. 5.3. Statement ��ü�� �����Ѵ�. 5.4. executeUpdate()�� ȣ����
	 * DELETE SQL���� �����Ų��.
	 */
	@Override
	public void deleteCustomer(String customerID) {
		String query = "DELETE FROM Customer WHERE CUST_ID = ?";

		System.out.println("CustomerDAOImpl deleteCustomer() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;

		try {

			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, customerID);
			stmt.executeUpdate();

		} catch (SQLException se) {
			System.err.println("CustomerDAOImpl deleteCustomer() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			throw new RuntimeException("A database error occurred. "
					+ se.getMessage());

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see casestudy.business.service.MemberDao#checkMember(java.lang.String,
	 * java.lang.String)
	 * 
	 * ���ڷ� ���� ���̵�� �н����� ������ �α��� ���� ����(id, password Ȯ��)�� Ȯ���ϰ� �ش� ������ ���� Member
	 * ��ü�� �����Ѵ�. (1) ���̵� �������� ���� ��� Member�� check�� ���� Member.INVALID_ID ��, (2)
	 * �н����尡 ���� ���� ��� Member�� check ���� Member.INVALID_PASSWORD ��, (3) ���̵�� �н����尡
	 * ��� ��ġ�� ��� Member�� check�� ���� Member.VALID_MEMBER �� �����Ͽ� Member ��ü�� �����Ѵ�.
	 */
	@Override
	public Customer checkCustomer(String customerID, String password) {
		Customer customer = new Customer(customerID, password);
		
		String query = "SELECT CUST_NAME, CUST_PASSWORD, CUST_TEL, CUST_EMAIL, CUST_ADDRESS,"
							+ " CUST_GRADE, CUST_DATE FROM CUSTOMER WHERE CUST_ID= ?";
		System.out.println("CustomerDAOImpl checkCustomer() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, customerID);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				String pw = rs.getString("CUST_PASSWORD");
				if (pw.equals(password)) {
					customer.setName(rs.getString("CUST_NAME"));
					customer.setEmail(rs.getString("CUST_EMAIL"));
					customer.setTel(rs.getString("CUST_TEL"));
					customer.setAddress(rs.getString("CUST_ADDRESS"));
					customer.setGrade(rs.getString("CUST_GRADE"));
					customer.setCustomerDate(rs.getDate("CUST_DATE"));
					customer.setCheck(Customer.VALID_CUSTOMER);
				} else {
					customer.setCheck(Customer.INVALID_PASSWORD);
				}
			} else {
				customer.setCheck(Customer.INVALID_ID);
			}

		} catch (SQLException se) {
			System.err.println("CustomerDAOImpl checkCustomer() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			throw new RuntimeException("A database error occurred. "
					+ se.getMessage());

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}

		return customer;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see casestudy.business.service.MemberDao#selectAllMembers()
	 * 
	 * 6. Member ���̺��� ��� ȸ�� ������ �˻��� �迭�� ��� �����Ѵ�. 6.1. Member ���̺��� ��� ���ڵ带
	 * SELECT�ϴ� SQL ������ �ۼ��Ѵ�. 6.2. obtainConnection() �޼ҵ带 ȣ���ؼ� Connection��
	 * ���´�. 6.3. Statement ��ü�� �����Ѵ�. 6.4. executeQuery()�� ȣ���� SELECT SQL����
	 * �����Ų��. 6.5. ResultSet ��ü�� ���� ����� �ʵ� �����͵�� ä���� Member ��ü���� �ӽ��÷��ǿ� �߰��Ѵ�.
	 * 6.6. �÷��ǿ� ��� ��ü���� Member �迭�� �Ű� �����Ѵ�.
	 */
	@Override
	public Customer[] selectAllCustomers() {
		String query = "SELECT CUST_ID, CUST_Name, CUST_Password, CUST_Tel, CUST_Email, "
						   + " CUST_Address, CUST_GRADE, CUST_Date FROM Customer";
		System.out.println("CustomerDAOImpl selectAllCustomers() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Customer> temp = new ArrayList<Customer>();
		Customer customer = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String CustomerID = rs.getString("CUST_Name");
				String name = rs.getString("CUST_Name");
				String password = rs.getString("CUST_Password");
				String tel = rs.getString("CUST_Tel");
				String email = rs.getString("CUST_Email");
				String address = rs.getString("CUST_Address");

				customer = new Customer(CustomerID, name, password, tel, email, address);
				temp.add(customer);

			}

		} catch (SQLException se) {
			System.err.println("MemberDAOImpl selectAllMembers() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			throw new RuntimeException("A database error occurred. "
					+ se.getMessage());

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace(System.err);
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace(System.err);
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace(System.err);
			}
		}

		return temp.toArray(new Customer[0]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * casestudy.business.service.MemberDao#memberIDExists(java.lang.String)
	 * 
	 * 7. ���ڷ� ���� memberID�� �ش��ϴ� ���� ���ڵ尡 Member ���̺� �����ϴ��� ���θ� Ȯ���Ѵ�. 7.1. Member
	 * ���̺��� ���ڵ带 SELECT�ϴ� SQL ������ �ۼ��Ѵ�. 7.2. obtainConnection() �޼ҵ带 ȣ���ؼ�
	 * Connection�� ���´�. 7.3. Statement ��ü�� �����Ѵ�. 7.4. executeQuery()�� ȣ����
	 * SELECT SQL���� �����Ų��. 7.5. ResultSet ��ü�� Ȯ���� ���ڵ尡 �����ϸ� true, ������ false��
	 * �����Ѵ�.
	 */
	@Override
	public boolean customerIDExists(String customerID) {
		boolean result = false;

		String query = "SELECT CUST_ID FROM MEMBER WHERE CUST_ID =?";
		System.out.println("CustomerDAOImpl customerIDExists() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, customerID);
			rs = stmt.executeQuery();

			result = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace(System.err);
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace(System.err);
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace(System.err);
			}
		}
		return result;
	}
}