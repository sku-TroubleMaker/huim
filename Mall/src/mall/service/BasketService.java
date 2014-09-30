package mall.service;

import mall.domain.Basket;
import mall.domain.Customer;
import mall.domain.Product;

/**
 * @author 안근영
 * 장바구니 서비스를 구현하기 위한 인터페이스
 */
public interface BasketService {
	/**
	 * 회원과 물품의 정보를 받아 장바구니에 저장
	 * (장바구니에 담기)
	 */
	public void registerBasketItem(Customer customer, Product product);
	
	/**
	 *  회원의 아이디를 이용해 장바구니 내의 물품들을 검색하기 위한 메소드
	 *  (장바구니 목록을 보여주기 위함)
	 *  @return Customer
	 */
	public Basket[] findAllBasketItem(String customerID) throws DataNotFoundException;
	
	/**
	 *  회원의 아이디와 물품의 아이디를 이용해 장바구니 내의 물품을 검색하기 위한 메소드
	 *  (물품 구매시 사용) // 프로덕트에서 하면 되지 않을까?
	 *  @return Basket
	 */
	public Basket findBasketItem(String customerID, String ProductID) throws DataNotFoundException;
	
	/**
	 *  장바구니의 물품을 삭제하기 위한 메소드
	 *  (장바구니 물품 삭제)
	 */
	public void removeBasketItem(Basket basket) throws DataNotFoundException;
	
}
