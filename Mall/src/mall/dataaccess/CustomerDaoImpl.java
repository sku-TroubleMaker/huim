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
	 * 1. JNDI API를 이용하여 네이밍 서비스에 등록(바인딩)된 DataSource를 검색한다. (jdbc/huimMallDB"
	 * 이란 논리적 이름으로 검색)
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
	 * DriverManager의 getConnection() 메소드를 통해 Connection을 만든다.
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
	 * 2. 인자로 받은 Customer 객체 정보를 통해 Customer 테이블에 새로운 레코드를 추가(insert) 한다. 
	 * 2.1. Customer 테이블에 레코드를 INSERT하는 SQL 구문을 작성한다. 
	 * 2.2. obtainConnection() 메소드를 호출해서 Connection을 얻어온다. 
	 * 2.3. Statement 객체를 생성한다. 
	 * 2.4. executeUpdate() 메소드를 호출해 INSERT SQL문을 실행시킨다.
	 */
	@Override
	public void insertCustomer(Customer customer) {
		String query = "INSERT INTO Customer (CUST_ID, CUST_NAME, CUST_PASSWORD, CUST_TEL"
							+ ", CUST_EMAIL, CUST_ADDRESS, CUST_GRADE, CUST_DATE) "
							+ "VALUES (?,?,?,?,?,?,'새싹회원',?)";

		System.out.println("MemberDAOImpl insertMember() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			System.out.println("dao 통과");
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
	 * 3. 인자로 받은 customerID로 레코드를 찾아(select) 해당 정보를 가진 Customer 객체를 리턴한다. 
	 * 3.1. Customer 테이블에서 레코드를 SELECT하는 SQL 구문을 작성한다. 
	 * 3.2. obtainConnection() 메소드를 호출해서 Connection을 얻어온다. 
	 * 3.3. Statement 객체를 생성한다. 
	 * 3.4. executeQuery()를 호출해 SELECT SQL문을 실행시킨다. 
	 * 3.5. ResultSet 객체를 통해 얻어진 필드 데이터들로 Customer 객체를 채워 리턴한다.
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
	 * 4. 인자로 받은 Member 객체의 정보로 Member 테이블의 레코드를 갱신(update) 한다. 4.1. Member 테이블의
	 * 레코드를 UPDATE하는 SQL 구문을 작성한다. 4.2. obtainConnection() 메소드를 호출해서 Connection을
	 * 얻어온다. 4.3. Statement 객체를 생성한다. 4.4. executeUpdate()를 호출해 UPDATE SQL문을
	 * 실행시킨다.
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
	 * 5. 인자로 받은 Member 객체의 정보를 통해 Member 테이블의 레코드를 삭제(delete) 한다. 5.1. Member
	 * 테이블의 레코드를 DELETE하는 SQL 구문을 작성한다. 5.2. obtainConnection() 메소드를 호출해서
	 * Connection을 얻어온다. 5.3. Statement 객체를 생성한다. 5.4. executeUpdate()를 호출해
	 * DELETE SQL문을 실행시킨다.
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
	 * 인자로 받은 아이디와 패스워드 정보로 로그인 가능 여부(id, password 확인)를 확인하고 해당 정보를 담은 Member
	 * 객체를 리턴한다. (1) 아이디가 존재하지 않을 경우 Member의 check의 값을 Member.INVALID_ID 로, (2)
	 * 패스워드가 맞지 않을 경우 Member의 check 값을 Member.INVALID_PASSWORD 로, (3) 아이디와 패스워드가
	 * 모두 일치할 경우 Member의 check의 값을 Member.VALID_MEMBER 로 세팅하여 Member 객체를 리턴한다.
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
	 * 6. Member 테이블에서 모든 회원 정보를 검색해 배열에 담아 리턴한다. 6.1. Member 테이블에서 모든 레코드를
	 * SELECT하는 SQL 구문을 작성한다. 6.2. obtainConnection() 메소드를 호출해서 Connection을
	 * 얻어온다. 6.3. Statement 객체를 생성한다. 6.4. executeQuery()를 호출해 SELECT SQL문을
	 * 실행시킨다. 6.5. ResultSet 객체를 통해 얻어진 필드 데이터들로 채워진 Member 객체들을 임시컬렉션에 추가한다.
	 * 6.6. 컬렉션에 담긴 객체들을 Member 배열에 옮겨 리턴한다.
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
	 * 7. 인자로 받은 memberID에 해당하는 기존 레코드가 Member 테이블에 존재하는지 여부를 확인한다. 7.1. Member
	 * 테이블에서 레코드를 SELECT하는 SQL 구문을 작성한다. 7.2. obtainConnection() 메소드를 호출해서
	 * Connection을 얻어온다. 7.3. Statement 객체를 생성한다. 7.4. executeQuery()를 호출해
	 * SELECT SQL문을 실행시킨다. 7.5. ResultSet 객체를 확인해 레코드가 존재하면 true, 없으면 false를
	 * 리턴한다.
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