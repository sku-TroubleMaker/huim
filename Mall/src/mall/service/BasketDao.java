package mall.service;

import mall.domain.Basket;
import mall.domain.Customer;
import mall.domain.Product;

/**
 * ��ٱ��� ���� ������ �׼��� ó���� ����� ��ü�� �԰��� ������ �������̽�.<br/>
 * ������ �׼��� ���� �и������ν� ������ �׼��� �� �̿� ����̳� ������ ����Ǿ ����Ͻ� ���� ���� ������ ���� �ʴ´�.
 */
public interface BasketDao {
	
	//����ü�� ��ǰ��ü�� �޾� ��ٱ��Ͽ� �ִ� ��ǰ�� �˻�.
	public Basket selectBasketItem(Customer customer, Product product);
	
	
	
	

}
