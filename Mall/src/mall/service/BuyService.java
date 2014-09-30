package mall.service;

import mall.domain.Basket;
import mall.domain.Buy;

/**
 * @author 안근영
 * 구매 서비스를 구현하기 위한 인터페이스
 */
public interface BuyService {

	/**
	 * 회원과 구매물품의 정보를 받아 구매목록에 저장
	 * (구매목록에 저장)
	 */
	public void registerBuyItem(Basket basket);
	
	/**
	 *  회원의 아이디를 이용해 장바구니 내의 구매한 물품들을 조회하기 위한 메소드
	 *  (구매한목록을 보여주기 위함)
	 *  @return Buy[]
	 */
	public Buy[] findAllBoughtItem(String customerID) throws DataNotFoundException;
	
}
