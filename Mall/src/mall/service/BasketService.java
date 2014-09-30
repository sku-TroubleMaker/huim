package mall.service;

import mall.domain.Basket;
import mall.domain.Customer;
import mall.domain.Product;

/**
 * @author �ȱٿ�
 * ��ٱ��� ���񽺸� �����ϱ� ���� �������̽�
 */
public interface BasketService {
	/**
	 * ȸ���� ��ǰ�� ������ �޾� ��ٱ��Ͽ� ����
	 * (��ٱ��Ͽ� ���)
	 */
	public void registerBasketItem(Customer customer, Product product);
	
	/**
	 *  ȸ���� ���̵� �̿��� ��ٱ��� ���� ��ǰ���� �˻��ϱ� ���� �޼ҵ�
	 *  (��ٱ��� ����� �����ֱ� ����)
	 *  @return Customer
	 */
	public Basket[] findAllBasketItem(String customerID) throws DataNotFoundException;
	
	/**
	 *  ȸ���� ���̵�� ��ǰ�� ���̵� �̿��� ��ٱ��� ���� ��ǰ�� �˻��ϱ� ���� �޼ҵ�
	 *  (��ǰ ���Ž� ���) // ���δ�Ʈ���� �ϸ� ���� ������?
	 *  @return Basket
	 */
	public Basket findBasketItem(String customerID, String ProductID) throws DataNotFoundException;
	
	/**
	 *  ��ٱ����� ��ǰ�� �����ϱ� ���� �޼ҵ�
	 *  (��ٱ��� ��ǰ ����)
	 */
	public void removeBasketItem(Basket basket) throws DataNotFoundException;
	
}
