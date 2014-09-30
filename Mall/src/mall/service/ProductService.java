package mall.service;

import mall.domain.Product;

/**
 * @author 안근영
 * 물품에 대한 서비스를 구현하기 위한 인터페이스
 */
public interface ProductService {

	/**
	 *  ProductDB에 물품을 등록하기 위한 메소드 
	 */
	public void registerProduct(Product Product) throws DataNotFoundException;
	
	/**
	 *  물품ID로 하나의 물품을 검색하기 위한 메소드
	 *  검색된 물품객체를 리턴
	 *  (주로 물품 구매시 사용)
	 *  @return Product[]
	 */
	public Product findProduct(String ProductID) throws DataNotFoundException;
	
	/**
	 *  물품이름으로 물품들을 검색하기 위한 메소드
	 *  물품의 이름을 이용하여 물품 검색 후
	 *  검색된 물품들을 배열에 담아 리턴
	 *  (검색창 사용시 또는 카테고리 클릭시 사용)
	 *  (검색된 물품이 하나여도 이거씁니다.)
	 *  @return Product[]
	 */
	public Product[] getSearchedProducts(String ProductName) throws DataNotFoundException;
	
	/**
	 *  모든 물품들을 검색하기 위한 메소드
	 *  검색된 물품들을 배열에 담아 리턴
	 *  메인페이지 작성용
	 *  (상의,하의, 아우터, 액세서리를 if로 구분하여 물품 찾아 뽑아줍니다.)//어떻게 구분할 것인가
	 *  @return Product[]
	 */
	public Product[] getAllProducts() throws DataNotFoundException;
	
	/**
	 *  물품정보를 수정하기 위한 메소드
	 *  
	 */
	public void updateProduct(Product Product) throws DataNotFoundException;
	
	/**
	 *  물품을 삭제하기 위한 메소드
	 */
	public void removeProduct(Product Product) throws DataNotFoundException;
	
	
}
