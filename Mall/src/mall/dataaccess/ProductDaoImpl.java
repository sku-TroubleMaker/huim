package mall.dataaccess;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mall.domain.Product;
import mall.service.ProductDao;

public class ProductDaoImpl implements ProductDao {
	private DataSource dataSource;

	/*
	 * Driver 클래스(oracle.jdbc.driver.OracleDriver)를 Class의 forName 메서드를 사용하여
	 * 로딩한다.
	 */
	public ProductDaoImpl() {
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
	 * casestudy.business.service.ProductDao#selectProduct(java.lang.String)
	 * 
	 * 인자로 받은 productID로 레코드를 찾아(select) 해당 정보를 가진 Product 객체를 리턴한다.
	 */
	@Override
	public Product selectProduct(String productID) {
		Product product = null;

		String query = "SELECT Pro_Code, Pro_Name, pro_Size, pro_Price, pro_Discount_Rate, "
				+ "pro_Sell_Count, pro_Stock, pro_Company, pro_Reg_Date, Pro_Img, pro_Category, Pro_Detail"
				+ "FROM Product WHERE Pro_ID = ?";
		System.out.println("ProductDAOImpl selectProduct() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, productID);
			rs = stmt.executeQuery();

			if (rs.next()) {
				product = new Product(rs.getString("Pro_Code"),
						rs.getString("Pro_Name"), rs.getString("pro_Size"),
						rs.getInt("pro_Price"), rs.getInt("pro_Discount_Rate"),
						rs.getInt("pro_Sell_Count"), rs.getInt("pro_Stock"),
						rs.getString("pro_Company"),
						rs.getDate("pro_Reg_Date"), rs.getString("Pro_Img"),
						rs.getString("pro_Category"),
						rs.getString("Pro_Detail"));
			}

		} catch (SQLException se) {
			System.err.println("ProductDAOImpl selectProduct() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			// throw new RuntimeException("A database error occured. " +
			// se.getMessage());

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
			} catch (SQLException e) {
				e.printStackTrace(System.err);
			}
		}

		return product;
	}

	@Override
	public Product[] selectNameProduct(String productName) {

		String query = "SELECT * FROM Product WHERE Pro_Name Like '%?%'";
		System.out.println("ProductDAOImpl selectProduct() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Product> temp = new ArrayList<Product>();
		Product product = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, productName);
			rs = stmt.executeQuery();

			if (rs.next()) {
				product = new Product(rs.getString("Pro_Code"),
						rs.getString("Pro_Name"), rs.getString("pro_Size"),
						rs.getInt("pro_Price"), rs.getInt("pro_Discount_Rate"),
						rs.getInt("pro_Sell_Count"), rs.getInt("pro_Stock"),
						rs.getString("pro_Company"),
						rs.getDate("pro_Reg_Date"), rs.getString("Pro_Img"),
						rs.getString("pro_Category"),
						rs.getString("Pro_Detail"));
				temp.add(product);
			}

		} catch (SQLException se) {
			System.err.println("ProductDAOImpl selectNameProduct() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			// throw new RuntimeException("A database error occured. " +
			// se.getMessage());

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
			} catch (SQLException e) {
				e.printStackTrace(System.err);
			}
		}

		return temp.toArray(new Product[0]);
	}

	@Override
	public Product[] selectCategoryProduct(String category) {
		String query = "SELECT * FROM Product WHERE Pro_Categoty = ?";
		System.out.println("ProductDAOImpl selectProduct() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Product> temp = new ArrayList<Product>();
		Product product = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, category);
			rs = stmt.executeQuery();

			if (rs.next()) {
				product = new Product(rs.getString("Pro_Code"),
						rs.getString("Pro_Name"), rs.getString("pro_Size"),
						rs.getInt("pro_Price"), rs.getInt("pro_Discount_Rate"),
						rs.getInt("pro_Sell_Count"), rs.getInt("pro_Stock"),
						rs.getString("pro_Company"),
						rs.getDate("pro_Reg_Date"), rs.getString("Pro_Img"),
						rs.getString("pro_Category"),
						rs.getString("Pro_Detail"));
				temp.add(product);
			}

		} catch (SQLException se) {
			System.err.println("ProductDAOImpl selectCategoryProduct() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			// throw new RuntimeException("A database error occured. " +
			// se.getMessage());

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
			} catch (SQLException e) {
				e.printStackTrace(System.err);
			}
		}

		return temp.toArray(new Product[0]);
	}

	@Override
	public Product[] sortSellCountProduct(Product[] Products, int sellCount) {

		return null;
	}

	@Override
	public void insertProduct(Product product) {
		String query = "INSERT INTO Product VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		System.out.println("ProductDAOImpl insertProduct() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;

		try {

			connection = obtainConnection();
			stmt = connection.prepareStatement(query);

			stmt.setString(1, product.getCode());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getSize());
			stmt.setInt(4, product.getPrice());
			stmt.setInt(5, product.getDiscountRate());
			stmt.setInt(6, product.getSellCount());
			stmt.setInt(7, product.getStock());
			stmt.setString(8, product.getCompany());
			stmt.setDate(9, new Date(System.currentTimeMillis()));
			stmt.setString(10, product.getImageRoot());
			stmt.setString(11, product.getCategory());
			stmt.setString(12, product.getDetail());

			stmt.executeUpdate();

		} catch (SQLException se) {
			System.err.println("ProductDAOImpl insertProduct() Error :"
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

	@Override
	public void deleteProduct(String productID) {
		String query = "DELETE FROM Product WHERE Pro_Code= ?";

		System.out.println("ProductDAOImpl deleteProduct() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;

		try {

			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, productID);
			stmt.executeUpdate();

		} catch (SQLException se) {
			System.err.println("ProductDAOImpl deleteProduct() Error :"
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

	@Override
	public void updateProduct(Product product) {
		String query = "UPDATE Product SET Pro_Name =?, pro_Size=?, pro_Price=?, "
				+ "pro_Discount_Rate=?, pro_Sell_Count=?, pro_Stock=?, pro_Company=?, "
				+ "Pro_Img=?, pro_Category=?, Pro_Detail=? WHERE Pro_ID = ? ";
		System.out.println("ProductDAOImpl updateProduct() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);

			stmt.setString(1, product.getName());
			stmt.setString(2, product.getSize());
			stmt.setInt(3, product.getPrice());
			stmt.setInt(4, product.getDiscountRate());
			stmt.setInt(5, product.getSellCount());
			stmt.setInt(6, product.getStock());
			stmt.setString(7, product.getCompany());
			stmt.setString(8, product.getImageRoot());
			stmt.setString(9, product.getCategory());
			stmt.setString(10, product.getDetail());
			stmt.setString(11, product.getCode());
			stmt.executeUpdate();

		} catch (SQLException se) {
			System.err.println("ProductDAOImpl updateProduct() Error :"
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

	@Override
	public Product[] selectAllProducts() {
		String query = "SELECT Pro_Code, Pro_Name, pro_Size, pro_Price, pro_Discount_Rate, pro_Sell_Count, pro_Stock, pro_Company, pro_Reg_Date, Pro_Img, pro_Category, Pro_Detail FROM Product";

		System.out
				.println("ProductDAOImpl selectAllProducts() query: " + query);

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Product> temp = new ArrayList<Product>();
		Product product = null;

		try {
			connection = obtainConnection();
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				product = new Product(rs.getString("Pro_Code"),
						rs.getString("Pro_Name"), rs.getString("pro_Size"),
						rs.getInt("pro_Price"), rs.getInt("pro_Discount_Rate"),
						rs.getInt("pro_Sell_Count"), rs.getInt("pro_Stock"),
						rs.getString("pro_Company"),
						rs.getDate("pro_Reg_Date"), rs.getString("Pro_Img"),
						rs.getString("pro_Category"),
						rs.getString("Pro_Detail"));
				temp.add(product);

			}

		} catch (SQLException se) {
			System.err.println("productDAOImpl selectAllProducts() Error :"
					+ se.getMessage());
			se.printStackTrace(System.err);
			// throw new RuntimeException("A database error occurred. " +
			// se.getMessage());

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

		return temp.toArray(new Product[0]);
	}

	@Override
	public boolean productIDExists(String productID) {
		boolean result = false;

		String query = "SELECT Pro_Code FROM Product WHERE Pro_Code = '"
				+ productID + "'";
		System.out.println("MemberDAOImpl memberIDExists() query: " + query);

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = obtainConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);

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
