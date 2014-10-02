package mall.test;

import java.sql.Date;

import mall.domain.Product;
import mall.service.ProductDao;

public class ProductDaotest implements ProductDao {
	
	private String code = "0";
	private String name = "π∞«∞¿Ã∏ß";
	private String size = "ªÁ¿Ã¡Ó";
	private int price = 300;
	private int discountRate = 10;
	private int sellCount = 0;
	private int stock = 30;
	private String company = "»ﬁ¿Ãø•" ;
	private Date registationDate ;
	private String imageRoot = "";
	private String category = "ªÛ¿«";
	private String detail = "º≈√˜";
	
	@Override
	public Product selectProduct(String productID) {
		code = productID;
		Product product = new Product(productID, name, size, price, discountRate, sellCount, stock, company, imageRoot, category, detail);
		return product;
	}

	@Override
	public Product[] selectNameProduct(String productName) {
		
		return null;
	}

	@Override
	public Product[] selectCategoryProduct(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] sortSellCountProduct(Product[] Products, int sellCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(String productID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product[] selectAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean productIDExists(String productID) {
		// TODO Auto-generated method stub
		return false;
	}

}
