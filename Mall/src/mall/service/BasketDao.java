package mall.service;

import mall.domain.Basket;
import mall.domain.Customer;
import mall.domain.Product;

/**
 * 장바구니 관련 데이터 액세스 처리를 담당할 객체의 규격을 정의한 인터페이스.<br/>
 * 데이터 액세스 층을 분리함으로써 데이터 액세스 층 이용 기술이나 구현이 변경되어도 비즈니스 로직 층에 영향을 주지 않는다.
 */
public interface BasketDao {
	
	//고객객체와 물품객체를 받아 장바구니에 있는 물품을 검색.
	public Basket selectBasketItem(Customer customer, Product product);
	
	
	
	

}
