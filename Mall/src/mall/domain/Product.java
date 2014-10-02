package mall.domain;



import java.sql.Date;

public class Product {
	private String code;
	private String name;
	private String size;
	private int price;
	private int discountRate;
	private int sellCount;
	private int stock;
	private String company;
	private Date registationDate;
	private String imageRoot;
	private String category;
	private String detail;

	public Product() {
		
	}
	
	public Product(String code, String name, String size, int price,
			int discountRate, int sellCount, int stock, String company,
			 String imageRoot,String category, String detail) {
		super();
		this.code = code;
		this.name = name;
		this.size = size;
		this.price = price;
		this.discountRate = discountRate;
		this.sellCount = sellCount;
		this.stock = stock;
		this.company = company;
		this.imageRoot = imageRoot;
		this.category = category;
		this.detail = detail;
	}

	public Product(String code, String name, String size, int price,
			int discountRate, int sellCount, int stock, String company,
			Date registationDate, String imageRoot, String category,
			String detail) {
		super();
		this.code = code;
		this.name = name;
		this.size = size;
		this.price = price;
		this.discountRate = discountRate;
		this.sellCount = sellCount;
		this.stock = stock;
		this.company = company;
		this.registationDate = registationDate;
		this.imageRoot = imageRoot;
		this.category = category;
		this.detail = detail;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setRegistationDate(Date registationDate) {
		this.registationDate = registationDate;
	}

	public void setImageRoot(String imageRoot) {
		this.imageRoot = imageRoot;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public int getPrice() {
		return price;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public int getSellCount() {
		return sellCount;
	}

	public int getStock() {
		return stock;
	}

	public String getCompany() {
		return company;
	}

	public Date getRegistationDate() {
		return registationDate;
	}

	public String getImageRoot() {
		return imageRoot;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	

}
