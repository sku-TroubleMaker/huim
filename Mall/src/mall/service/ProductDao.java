package mall.service;


import mall.domain.Product;

/**
 * 상품 관련 데이터 액세스 처리를 담당할 객체의 규격을 정의한 인터페이스.<br/>
 * 데이터 액세스 층을 분리함으로써 데이터 액세스 층 이용 기술이나 구현이 변경되어도 비즈니스 로직 층에 영향을 주지 않는다.
 */
public interface ProductDao {

	/**
	 * 데이터 저장소에서 인수로 주어진 productID에 해당하는 상품정보를 검색한다.
	 * 
	 * @param productID
	 *            검색하고자 하는 상품의 productID
	 * @return 검색된 상품정보를 담고 있는 Product 객체
	 */
	public Product selectProduct(String productID);
	
	/**
	 * 데이터 저장소에서 인수로 주어진 productName에 해당하는 상품들의 정보를 검색한다.
	 * 
	 * @param productName
	 *            검색하고자 하는 상품의 productName
	 * @return 검색된 상품들의 정보를 담고 있는 Product[] 객체
	 */
	public Product[] selectNameProduct(String productName);
	
	/**
	 * 데이터 저장소에서 인수로 주어진 category에 해당하는 상품들의 정보를 검색한다.
	 * 
	 * @param category
	 *            검색하고자 하는 상품의 category
	 * @return 검색된 상품들의 정보를 담고 있는 Product[] 객체
	 * 카테고리: top, bottom, outer, accessory
	 */
	public Product[] selectCategoryProduct(String category);
	
//	/**
//	 * 나열된 상품들을 인수로 주어진 price를 가지고 낮은순, 높은순을 결정하여 정렬한다.
//	 * 
//	 * @param price, highlow
//	 *            검색하고자 하는 상품의 price
//	 * @return 검색된 상품들의 정보를 담고 있는 Product[] 객체
//	 * 
//	 */
//	public Product[] sortPriceProduct(Product[] products, String highlow);
		
	/**
	 * 나열된 상품들을 인수로 주어진 sellCount를 높은순을 결정하여 정렬한다.
	 * 
	 * @param sellCount
	 *            검색하고자 하는 상품의 sellCount
	 * @return 검색된 상품들의 정보를 담고 있는 Product[] 객체
	 * 
	 */
	public Product[] sortSellCountProduct(Product[] Products, int sellCount);
	
	/**
	 * 데이터 저장소에 인수로 주어진 product에 해당하는 상품정보를 등록한다.
	 * 
	 * @param product
	 *            등록하고자 하는 상품 정보를 담고 있는 Product 객체
	 */

	public void insertProduct(Product product);
	
	public void deleteProduct(String productID);
	
	public void updateProduct(Product product);

	public Product[] selectAllProducts();

	/**
	 * 데이터 저장소에 인수로 주어진 productID에 해당하는 기존 상품정보가 있는지 확인한다.
	 * 
	 * @return 해당하는 상품정보가 존재하면 true, 존재하지 않으면 false
	 */
	public boolean productIDExists(String productID);

}
