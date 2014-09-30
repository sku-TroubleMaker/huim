package mall.service;

import mall.domain.Basket;
import mall.domain.Buy;

/**
 * @author �ȱٿ�
 * ���� ���񽺸� �����ϱ� ���� �������̽�
 */
public interface BuyService {

	/**
	 * ȸ���� ���Ź�ǰ�� ������ �޾� ���Ÿ�Ͽ� ����
	 * (���Ÿ�Ͽ� ����)
	 */
	public void registerBuyItem(Basket basket);
	
	/**
	 *  ȸ���� ���̵� �̿��� ��ٱ��� ���� ������ ��ǰ���� ��ȸ�ϱ� ���� �޼ҵ�
	 *  (�����Ѹ���� �����ֱ� ����)
	 *  @return Buy[]
	 */
	public Buy[] findAllBoughtItem(String customerID) throws DataNotFoundException;
	
}
